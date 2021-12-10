package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.ReferencedOperationException;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.OperationMemory;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.OperationInvoker;
import it.unisa.complexcalculator.Model.Stream.CustomStream;
import it.unisa.complexcalculator.Model.Stream.DefaultStream;
import it.unisa.complexcalculator.Model.Stream.Stream;
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

public class FXMLController implements Initializable {

    @FXML
    private ListView<ComplexNumber> storedElements;
    
    private Stream stream;
    
    private ConcreteOperationFactory c;

    private OperationInvoker invoker;
    
    private final CustomStream cuStream = new CustomStream();
    private final DefaultStream defStream = new DefaultStream();
    
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
        setStream();
        c = new ConcreteOperationFactory();
        invoker = new OperationInvoker();
        storedElements.setItems(NumberMemory.getNumberMemory().getStack());

        varColumn.setCellValueFactory(new PropertyValueFactory<>("var")); //fai apparire nella tabella il valore della data
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value")); //fai apparire il valore della descrizione
        varTable.setItems(VariableMemory.getVariableMemory().getVars());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //fai apparire nella tabella il valore della data
        seqColumn.setCellValueFactory(new PropertyValueFactory<>("sequence")); //fai apparire il valore della descrizione
        opsTable.setItems(OperationMemory.getOperationMemory().getOps());

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
            CustomOperation op = c.createCustomOperation(name, seq);
            OperationMemory.getOperationMemory().addCustomOperation(op);
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
    private void setStream(){
        if(pathCheckbox.isSelected())
            stream = defStream;
        else
            stream = cuStream;
    }
    
    @FXML
    private void saveCustomOperation() {        
        stream.save(root.getScene());
        opsTable.refresh();
    }

    @FXML
    private void loadCustomOperation() {
        stream.load(root.getScene());
        opsTable.refresh();
    }

    @FXML
    private void updateNameColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        String old = opsTable.getSelectionModel().getSelectedItem().getName();
        if(!checkOperationValidity(event.getNewValue())){
            opsTable.refresh();
            return;     
        }
        try {
            OperationMemory.getOperationMemory().refreshName(old, event.getNewValue());
        } catch (AlreadyExistentOperationException ex) {
            generateAlert("Already existent operation.");
            opsTable.refresh();
            return;
        } catch (ReferencedOperationException ex) {
            generateAlert("Referenced operation, cannot update.");
            opsTable.refresh();
            return;
        }
        opsTable.refresh();
    }

    @FXML
    private void updateSeqColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        OperationMemory opMem = OperationMemory.getOperationMemory();
        CustomOperation selected = opsTable.getSelectionModel().getSelectedItem();
        try {
            opMem.refreshSequence(event.getNewValue(), selected.getName());
            opsTable.refresh();
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
        try{
            c.createOperation(name);
        }catch(NumberFormatException ex){
            return true;
        }
        generateAlert("Invalid operation name, already existent operation.");
        return false;
    }
    
    
    private void executeOperation(String s) {
        try {
            Operation op = c.createOperation(s);
            invoker.execute(op);
        } catch (NumberFormatException ex) {
            inputBox.setText("");
            generateAlert("Invalid number or operation format.");
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
        
        try{
            OperationMemory.getOperationMemory().removeCustomOperation(op);
        }catch(ReferencedOperationException ex){
            generateAlert("Can't delete this operation, it is used by another one.");
        }
    }
    
}
