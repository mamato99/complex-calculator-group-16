package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.*;
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
    
    private Calculator c;
    
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
        c = new Calculator();
        
        storedElements.setItems(c.getNumbers().getStack());
        
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
            Operation op = c.createOperation(input);
            op.execute();
        } catch (NumberFormatException ex){
            inputBox.setText("");
            generateAlert("Invalid number format.");
        }
        inputBox.setText("");
        
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
        
        try{
            Operation op = c.createOperation(s);
            op.execute();
        } catch (NumberFormatException ex){
            inputBox.setText("");
            generateAlert("Invalid number format.");
        }
        inputBox.setText("");
    }
  
}
