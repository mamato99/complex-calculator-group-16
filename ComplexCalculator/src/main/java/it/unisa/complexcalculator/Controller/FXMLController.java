package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Exception.*;
import it.unisa.complexcalculator.Model.Operation.*;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.*;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.OperationInvoker;
import it.unisa.complexcalculator.Model.Stream.*;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {

    private Stream stream; 
    private ConcreteOperationFactory opFac;
    private OperationInvoker invoker;
    
    private NumberMemory numMem;
    private VariableMemory varMem;
    private OperationMemory opMem;
    
    @FXML
    private ListView<ComplexNumber> storedElements;
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
     * Initializes all elements according to user preferences by default.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStream();
        
        numMem = NumberMemory.getNumberMemory();
        varMem = VariableMemory.getVariableMemory();
        opMem = OperationMemory.getOperationMemory();
        
        opFac = new ConcreteOperationFactory();
        invoker = new OperationInvoker();
        
        storedElements.setItems(numMem.getStack()); // Create a binding between NumberMemory's list of ComplexNumber and storedElement

        varColumn.setCellValueFactory(new PropertyValueFactory<>("var")); // Creates a binding between Variable's "var" attribute and the varColumn
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value")); // Creates a binding between Variable's "value" attribute and the varColumn
        varTable.setItems(varMem.getVars()); // Create a binding between VariableMemory's list of Variables and varTable

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); // Creates a binding between CustomOperation's "name" attribute and the varColumn
        seqColumn.setCellValueFactory(new PropertyValueFactory<>("sequence")); // Creates a binding between CustomOperation's "sequence" attribute and the varColumn
        opsTable.setItems(opMem.getOps()); // Create a binding between OperationMemory's list of CustomOperations and opsTable

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
        
        // Enter key to submit in nameField
        nameField.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER)) {
                insertCustomOperation();
            }
        }); 
        
        // Enter key to submit in seqField
        seqField.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER)) {
                insertCustomOperation();
            }
        }); 
    }

    /**
     * Method that manages the press of the "INS" button or the event of submitting in the <code>inputBox</code>.
     * <p>
     * It takes the string in the input box and executes the <code>Operation</code> represented by the string, then refreshes the view.
     * </p>
     */
    @FXML
    private void ins() {

        String input = inputBox.getText();

        executeOperation(input);
        
        varTable.refresh();
        opsTable.refresh();
    }

    /**
     * Method that manages the press of the "DEL" button or the BACKSPACE key in the <code>inputBox</code>.
     * <p>
     * It deletes the character before the cursor position.
     * </p>
     */
    @FXML
    private void del() {
        inputBox.deletePreviousChar();
    }

    /**
     * Method that manages the press of the "AC" button or the ESCAPE key in the <code>inputBox</code>.
     * <p>
     * It clears the inputBox deleting all the caracters in it.
     * </p>
     */
    @FXML
    private void ac() {
        inputBox.clear();
    }

    /**
     * Method that manages the press of an operation button.
     * <p>
     * It takes its label and executes the operation identified by the label.
     * </p>
     * @param event the event informations.
     */
    @FXML
    private void operation(MouseEvent event) {
        Button b = (Button) event.getSource();
        String s = b.getText().toLowerCase();
        executeOperation(s);
    }

    /**
     * Method that manages the press of a the "LOAD VARIABLE STATE" button.
     * <p>
     * It executes the <code>Operation</code> of restoring/loading the variable state.
     * </p>
     */
    @FXML
    private void loadVariablesState() {
        executeOperation("restore");
        varTable.refresh();
    }

    /**
     * Method that manages the press of a the "SAVE VARIABLE STATE" button.
     * <p>
     * It executes the <code>Operation</code> of saving the variable state.
     * </p>
     */
    @FXML
    private void saveVariablesState() {
        executeOperation("save");
        varTable.refresh();
    }

    /**
     * Method that inserts in the <code>OperationMemory</code> a new <code>CustomOperation</code>.
     * <p>
     * It first checks if the <code>Operation</code> is already defined (case in which it generates an alert), then
     * proceeds to add it into the <code>OperationMemory</code>.
     * </p>
     */
    @FXML
    private void insertCustomOperation() {
        String name = nameField.getText();
        String seq = seqField.getText();

        if(!checkOperationValidity(name)){
            opsTable.refresh();
            return;
        }
        try {
            CustomOperation op = opFac.createCustomOperation(name, seq);
            opMem.addCustomOperation(op);
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

    /**
     * Method that sets the stream of output to Default or Custom, based on checkbox status.
     */
    @FXML
    private void setStream(){
        if(pathCheckbox.isSelected())
            stream = new DefaultStream();
        else
            stream = new CustomStream(root.getScene());
    }
    
    /**
     * Method that saves the state of all the stored <code>CustomOperation</code> in a file.
     * <p>
     * The output path can vary based on the user preferences.
     * </p>
     */
    @FXML
    private void saveCustomOperation() {        
        if(stream.save() != null){
            generateConfirmation("File saved successfully.");
            opsTable.refresh();
        }else{
            generateAlert("Error while saving file.");
        }    
    }

    /**
     * Method that loads the state of all the stored <code>CustomOperation</code> from a file.
     * <p>
     * The output path can vary based on the user preferences.
     * </p>
     */
    @FXML
    private void loadCustomOperation() {
        if(stream.load() != null){
            generateConfirmation("File loaded successfully.");
            opsTable.refresh();
        }else{
            generateAlert("Error while loading file.");
        }  
    }
    
    /**
     * Method that updates the name of a <code>CustomOperation</code> contained in the <code>OperationMemory</code>.
     * <p>
     * If the name is not avaible or the operation is referenced by another one, it can shows an alert that
     * informs the user of the error.
     * </p>
     */
    @FXML
    private void updateNameColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        String old = opsTable.getSelectionModel().getSelectedItem().getName();
        if(!checkOperationValidity(event.getNewValue())){
            opsTable.refresh();
            return;     
        }
        try {
            opMem.refreshName(old, event.getNewValue());
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

    /**
     * Method that updates the name of a <code>CustomOperation</code> contained in the <code>OperationMemory</code>.
     * <p>
     * If the name is not avaible or the operation is referenced by another one, it can shows an alert that
     * informs the user of the error.
     * </p>
     */
    @FXML
    private void updateSeqColumn(TableColumn.CellEditEvent<CustomOperation, String> event) {
        CustomOperation selected = opsTable.getSelectionModel().getSelectedItem();
        try {
            opFac.createCustomOperation(selected.getName(), event.getNewValue());
            opMem.refreshSequence(event.getNewValue(), selected.getName());
            opsTable.refresh();
        } catch (Exception ex) {
            generateAlert("Invalid sequence format.");
            opsTable.refresh();
            return;
        }
        opsTable.refresh();

    }

    /**
     * Method that manages the press of the "Ivoke" button from the context menu in the <code>opsTable</code>.
     * <p>
     * It takes the selected <code>CustomOperation</code> and executes it.
     * </p>
     */
    @FXML
    private void invokeOperation() {
        CustomOperation op = opsTable.getSelectionModel().getSelectedItem();
        executeOperation(op.getName());
    }

    /**
     * Method that manages the press of the "Delete" button from the context menu in the <code>opsTable</code>.
     * <p>
     * It takes the selected <code>CustomOperation</code> and deletes it. If the operation is referenced by another one,
     * it generates an alert that informs the user of the error.
     * </p>
     */
    @FXML
    private void deleteOperation() {
        CustomOperation op = opsTable.getSelectionModel().getSelectedItem();
        try{
            opMem.removeCustomOperation(op);
        }catch(ReferencedOperationException ex){
            generateAlert("Can't delete this operation, it is used by another one.");
        }
    }

    
    
    //---------------------------------Utility methods-----------------------------------
    
    /**
     * Method that checks wether an <code>Operation</code> name is valid or not and if it is already existent.
     * <p>
     * In both cases it generates an alert that informs the user of the error.
     * </p>
     * @param name the name of the <code>Operation</code> to check.
     */
    private boolean checkOperationValidity(String name){
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            generateAlert("Operation name must contain alphanumeric characters.");
            opsTable.refresh();
            return false;
        }
        try{
            opFac.createOperation(name);
        }catch(NumberFormatException ex){
            return true;
        }
        generateAlert("Invalid operation name, already existent operation.");
        return false;
    }
    
    /**
     * Method that executes an <code>Operation</code> using the <code>OperationInvoker</code> object.
     * <p>
     * If it fails to execute, it generates an alert to inform the user of the error occurred.
     * </p>
     * @param s the string corresponding to the <code>Operation</code> to perform.
     */
    private void executeOperation(String s) {
        try {
            Operation op = opFac.createOperation(s);
            invoker.execute(op);
        } catch (NumberFormatException ex) {
            inputBox.setText("");
            generateAlert("Invalid number or operation format.");
        } catch (NotEnoughOperandsException ex) {
            inputBox.setText("");
            generateAlert("Not enough operands.");
        } catch (EmptyStackException ex) {
            inputBox.setText("");
            generateAlert("Stack empty.");
        } catch (NoSuchElementException ex) {
            inputBox.setText("");
            generateAlert("No state to restore.");
        } catch (ArithmeticException ex) {
            inputBox.setText("");
            generateAlert("Invalid operation.");
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
    
    /**
     * Method that generates a generic alert.
     * @param s the string to show in the alert window.
     */
    private void generateAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR, s, ButtonType.OK);
        alert.showAndWait();
    }
    
    /**
     * Generate a Confrimation Alert
     *
     * @param s message to display
     */
    protected void generateConfirmation(String s) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, s, ButtonType.OK);
        alert.showAndWait();
    }
    
}
