package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.OperationInvoker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {

    @FXML
    private ListView<ComplexNumber> storedElements;

    private Calculator c;

    private OperationInvoker invoker;
    
    private final String defaultPath = "backup";
    
    @FXML
    private TextField inputBox;
    @FXML
    private TextField nameField;
    @FXML
    private TextField seqField;
    @FXML
    private TableView<Variable> varTable;
    @FXML
    private TableColumn<Variable, Character> varColumn;
    @FXML
    private TableColumn<Variable, ComplexNumber> valueColumn;
    @FXML
    private TableView<CustomOperation> opsTable;
    @FXML
    private TableColumn<CustomOperation, String> nameColumn;
    @FXML
    private TableColumn<CustomOperation, String> seqColumn;
    @FXML
    private AnchorPane root;
    @FXML
    private CheckBox pathCheckbox;

    /**
     * Initializes all elements according to user preferences by default
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c = new Calculator();
        invoker = new OperationInvoker(c);
        storedElements.setItems(c.getNumberList());

        varColumn.setCellValueFactory(new PropertyValueFactory<>("var")); //fai apparire nella tabella il valore della data
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value")); //fai apparire il valore della descrizione
        varTable.setItems(c.getVariableList());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //fai apparire nella tabella il valore della data
        seqColumn.setCellValueFactory(new PropertyValueFactory<>("sequence")); //fai apparire il valore della descrizione
        opsTable.setItems(c.getCustomOperationList());

        seqColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Become editable
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Become editable

        // Enter key to submit and Escape key to clear in inputBox
        inputBox.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER)) {
                ins();
            } else if (value.getCode().equals(KeyCode.ESCAPE)) {
                ac();
            }
        });
        
        // 
        nameField.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER)) {
                insertCustomOperation();
            }
        }); 
        
        seqField.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER)) {
                insertCustomOperation();
            }
        }); 
    }

    /*
     * Method to manage the storing of a new complex number when button with "INS" as label is clicked
     */
    @FXML
    private void ins() {

        String input = inputBox.getText();

        executeOperation(input);
        
        varTable.refresh();
        opsTable.refresh();
    }

    /*
     * Method to manage the modification of the labels when button with "del" as label is clicked
     */
    @FXML
    private void del() {
        inputBox.deletePreviousChar();
    }

    /*
     * Method that generates an alert.
     */
    private void generateAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR, s, ButtonType.OK);
        alert.showAndWait();
    }
    
    /*
     * Method that generates an alert.
     */
    private void generateConfirmation(String s) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, s, ButtonType.OK);
        alert.showAndWait();
    }

    /*
     * Method to manage the modification of the labels when button with "AC" as label is clicked
     */
    @FXML
    private void ac() {
        inputBox.clear();
    }

    /*
     * Method that handle the button operation clicked.
     */
    @FXML
    private void operation(MouseEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText().toLowerCase();
        executeOperation(s);
    }

    @FXML
    private void loadVariablesState() {
        executeOperation("restore");
        varTable.refresh();
    }

    @FXML
    private void saveVariablesState() {
        executeOperation("save");
        varTable.refresh();
    }

    @FXML
    private void insertCustomOperation() {
        String name = nameField.getText();
        String seq = seqField.getText();

        if(!checkOperationValidity(name)){
            opsTable.refresh();
            return;
        }
        try {
            c.addCustomOperation(name, seq);
        } catch (AlreadyExistentOperationException ex) {
            generateAlert("Already existent operation.");
            return;
        } catch (Exception ex) {
            generateAlert("Invalid operation format.");
            return;
        }

        nameField.clear();
        seqField.clear();
    }

    
    @FXML
    private void saveCustomOperation() {
        
        File f = chooseFile(pathCheckbox.isSelected(), true);
        if (f != null) {
            try {
                c.save(f.getAbsolutePath());
                generateConfirmation("Saved successfully.");
                opsTable.refresh();
            } catch (IOException ex) {
                generateAlert("Error while saving file.");
                return;
            }
        }
    }

    @FXML
    private void loadCustomOperation() {
        
        File f = chooseFile(pathCheckbox.isSelected(), false);
        if (f != null) {
            try {
                c.load(f.getAbsolutePath());
                generateConfirmation("Loaded successfully.");
                opsTable.refresh();
            } catch (IOException ex) {
                generateAlert("Error while loading file.");
                return;
            } catch (ClassNotFoundException ex) {
                generateAlert("Error: " + ex.getMessage());
                return;
            }
        }
    }

    @FXML
    private void updateNameColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        String old = opsTable.getSelectionModel().getSelectedItem().getName();
        if(!checkOperationValidity(event.getNewValue())){
            opsTable.refresh();
            return;     
        }
        
        try {
            c.refreshSequences(old, event.getNewValue());
        } catch (AlreadyExistentOperationException ex) {
            generateAlert("Already existent operation.");
            opsTable.refresh();
            return;
        }
        opsTable.getSelectionModel().getSelectedItem().setName(event.getNewValue());
        opsTable.refresh();
    }

    @FXML
    private void updateSeqColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        CustomOperation selected = opsTable.getSelectionModel().getSelectedItem();
        try {
            String newSeq = c.sequenceToOperation(selected.getName(), event.getNewValue()).getSequence();
            selected.setSequence(newSeq);
        } catch (Exception ex) {
            generateAlert("Invalid sequence format.");
            opsTable.refresh();
            return;
        }
        opsTable.refresh();

    }

    private boolean checkOperationValidity(String name){
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            generateAlert("Operation name must contain alphanumeric characters.");
            opsTable.refresh();
            return false;
        }
        if(c.parseOperation(name) != null){
            generateAlert("Invalid operation name, already existent operation.");
            return false;
        }
        return true;
    }
    
    
    private void executeOperation(String s) {
        try {
            Operation op = c.parseOperation(s);
            invoker.execute(op);
        } catch (NumberFormatException ex) {
            inputBox.setText("");
            generateAlert("Invalid number format.");
        } catch (NotEnoughOperandsException ex) {
            inputBox.setText("");
            generateAlert("Not Enough operands.");
        } catch (EmptyStackException ex) {
            inputBox.setText("");
            generateAlert("Stack Empty.");
        }catch (NoSuchElementException ex) {
            inputBox.setText("");
            generateAlert("No one state to restore.");
        } catch (Exception ex) {
            inputBox.setText("");
            generateAlert("Error: " + ex.getMessage());
        } finally {
            inputBox.setText("");
            varTable.refresh();
            opsTable.refresh();
            storedElements.refresh();
        }
    }

    @FXML
    private void invokeOperation() {
        CustomOperation op = opsTable.getSelectionModel().getSelectedItem();
        executeOperation(op.getName());
    }

    @FXML
    private void deleteOperation() {
        CustomOperation op = opsTable.getSelectionModel().getSelectedItem();
        c.removeCustomOperation(op);
    }
    
    private File chooseFile(boolean checked, boolean save){
        if(!checked){
            FileChooser fc = new FileChooser();
            fc.setTitle("Choose file...");
            if(save)
                return fc.showSaveDialog(root.getScene().getWindow());
            else
                return fc.showOpenDialog(root.getScene().getWindow()); 
        }
        return new File(defaultPath);
    }
}
