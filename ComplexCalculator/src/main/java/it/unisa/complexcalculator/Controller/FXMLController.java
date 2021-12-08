package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.Operations;
import it.unisa.complexcalculator.Model.Memory.Variables;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.AddOperation;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private ListView<ComplexNumber> storedElements;
    
    private Calculator c;
    
    @FXML
    private TextField inputBox;
    @FXML
    private TableView<Variables> varTable;
    @FXML
    private TableColumn<Variables, Character> varColumn;
    @FXML
    private TableColumn<Variables, ComplexNumber> valueColumn;
    @FXML
    private TableView<Operations> opsTable;
    @FXML
    private TableColumn<Operations, String> nameColumn;
    @FXML
    private TableColumn<Operations, String> seqColumn;

    /**
     * Initializes all elements according to user preferences by default
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c = new Calculator();
        
        storedElements.setItems(c.getNumbers().getStack());
        
        varColumn.setCellValueFactory(new PropertyValueFactory<>("var")); //fai apparire nella tabella il valore della data
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value")); //fai apparire il valore della descrizione
        
        varTable.setItems(c.getVariables().getVars());
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //fai apparire nella tabella il valore della data
        seqColumn.setCellValueFactory(new PropertyValueFactory<>("sequence")); //fai apparire il valore della descrizione
        
        opsTable.setItems(c.getOperations().getOps());
        
        seqColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Become editable
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Become editable
        
        // Enter key to submit and Escape key to clear
        inputBox.setOnKeyPressed(value -> {
            if (value.getCode().equals(KeyCode.ENTER))
                ins();
            else if (value.getCode().equals(KeyCode.ESCAPE))
                ac();
        });
    }

    /*
     * Method to manage the storing of a new complex number when button with "INS" as label is clicked
     */
    @FXML
    private void ins() {

        String input = inputBox.getText();
        
        try{
            Operation op = c.parseOperation(input);
            op.execute();
        } catch (NumberFormatException ex){
            inputBox.setText("");
            generateAlert("Invalid number format.");
        }
        inputBox.setText("");
        varTable.refresh();
        
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
        Button b = (Button)event.getSource();
        String s = b.getText().toLowerCase();
        
        try{
            Operation op = c.parseOperation(s);
            op.execute();
        } catch (NumberFormatException ex){
            inputBox.setText("");
            generateAlert("Invalid number format.");
        }
        inputBox.setText("");
        varTable.refresh();
    }

    @FXML
    private void loadVariablesState(MouseEvent event) {
    }

    @FXML
    private void saveVariablesState(MouseEvent event) {
    }

    @FXML
    private void insertCustomOperation(MouseEvent event) {
    }

    @FXML
    private void saveCustomOperation(MouseEvent event) {
    }

    @FXML
    private void loadCustomOperation(MouseEvent event) {
    }

    @FXML
    private void updateNameColumn(TableColumn.CellEditEvent<Operations, String> event) {
        opsTable.getSelectionModel().getSelectedItem().setName(event.getNewValue());
        opsTable.refresh();
    }

    @FXML
    private void updateSeqColumn(TableColumn.CellEditEvent<Operations, String> event) {
    }
    
}
