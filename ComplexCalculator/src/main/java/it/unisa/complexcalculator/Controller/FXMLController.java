package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.Operation.OperationInvoker;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Operation.OperationFactory;
import it.unisa.complexcalculator.Model.Operation.StackOperation.StackOperationFactory;
import it.unisa.complexcalculator.Model.Operation.VariableOperation.VariableOperationFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private ListView<ComplexNumber> storedElements;
    private OperationInvoker opInvoker;
    Calculator c = new Calculator();
    @FXML
    private TextField inputBox;

    /**
     * Initializes all elements according to user preferences by default
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storedElements.setItems(c.getStoredNumbers().getStack());
        opInvoker = new OperationInvoker();
        
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
        OperationFactory opFac = new StackOperationFactory();
        Operation op = opFac.parseOperation(input, c);
        
        if (op != null){
            opInvoker.execute(op);
            inputBox.setText("");
            return;
        }
        
        opFac = new VariableOperationFactory();
        op = opFac.parseOperation(input, c);
        if (op != null){
            opInvoker.execute(op);
            inputBox.setText("");
            return;
        }
        
        try{
            ComplexNumber num = ComplexNumber.parse(input);
            inputBox.setText("");
            c.pushNumber(num);
        } catch (NumberFormatException ex){
            inputBox.setText("");
            generateAlert("Invalid number format.");
        }
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
     * Method that shows on the input box the label of the button clicked.
     */
    @FXML
    private void digit(MouseEvent event) {
        Button b = (Button)event.getSource();
        inputBox.appendText(b.getText().replaceAll("\\(", "").replaceAll("\\)", ""));
    }

    /*
     * Method that handle the button operation clicked.
     */
    @FXML
    private void operation(MouseEvent event) {
        Button b = (Button)event.getSource();
        String s = b.getText().toLowerCase();
        
        OperationFactory opFac = new StackOperationFactory();
        Operation op = opFac.parseOperation(s, c);
        
        if (op != null){
            opInvoker.execute(op);
            inputBox.setText("");
        }
    }
  
}
