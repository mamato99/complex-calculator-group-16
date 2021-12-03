package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import java.net.URL;
import java.util.EmptyStackException;
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
        
        if(checkStackOperation(input)){
            inputBox.setText("");
            return;
        }
            
        if(checkVariableOperation(input)){
            inputBox.setText("");
            return;
        }
            
        checkNumberInsertion(input);
        inputBox.setText("");
    }

    private boolean checkStackOperation(String in){
        switch(in){
            case "dup": dup(); return true;
            case "clear": clear(); return true;
            case "swap": swap(); return true;
            case "drop": drop(); return true;
            case "over": over(); return true;
            case "+": plus(); return true;
            case "-": minus(); return true;
            case "*": prod(); return true;
            case "/": div(); return true;
            case "sqrt": sqrt(); return true;
            case "+-": inv(); return true;
            default: return false;
        }
    }
    
    private boolean checkVariableOperation(String in){
        if(in.length() != 2)
            return false;
        if(!(in.startsWith(">") || in.startsWith("<") || in.startsWith("+") || in.startsWith("-")))
            return false;
        return in.substring(1).matches("[A-Z]"); //UPPERCASE TO AVOID "i" as imaginary part
    }
    
    private void checkNumberInsertion(String input){
        double real = 0;
        double img = 0;
        
        String toAnalyze = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                if (i != 0) {
                    toAnalyze += ",";
                }
                toAnalyze += input.charAt(i);
            } else {
                toAnalyze += input.charAt(i);
            }
        }

        String[] splitted = toAnalyze.split(",");

        for (String s : splitted) {
            try {
                if (s.contains("i")) {
                    if (s.equals("+i") || s.equals("i")) {
                        img += 1;
                    }
                    else if (s.equals("-i")) {
                        img -= 1;
                    }
                    else {
                        img += Double.parseDouble(s.substring(0, s.length() - 1));
                    }
                } else {
                    real += Double.parseDouble(s.substring(0, s.length()));
                }
            } catch (NumberFormatException ex) {
                generateAlert("Invalid number format.");
                return;
            }
        }
        c.pushNumber(real, img);
    }
    
    /*
     * Method to manage the modification of the labels when button with "del" as label is clicked
     */
    @FXML
    private void del() {
        inputBox.deletePreviousChar();
    }

    /*
     * Method to manage the associated operation when button with "+" as label is clicked
     */
    @FXML
    private void plus() {
        try {
            c.add();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    private void generateAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR, s, ButtonType.OK);
        alert.showAndWait();
    }

    /*
     * Method to manage the associated operation when button with "-" as label is clicked
     */
    @FXML
    private void minus() {
        try {
            c.subtract();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "x" as label is clicked
     */
    @FXML
    private void prod() {
        try {
            c.multiply();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "%" as label is clicked
     */
    @FXML
    private void div() {
        try {
            c.divide();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "√" as label is clicked
     */
    @FXML
    private void sqrt() {
        try {
            c.squareRoot();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "+-" as label is clicked
     */
    @FXML
    private void inv() {
        try {
            c.invertSign();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the modification of the labels when button with "AC" as label is clicked
     */
    @FXML
    private void ac() {
        inputBox.clear();
    }
    
    @FXML
    private void dup() {
        try {
            c.dup();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not Enough Operands.");
        }
    }

    @FXML
    private void swap() {
        try {
            c.swap();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    @FXML
    private void drop() {
        try {
            c.drop();
        } catch (EmptyStackException ex) {
            generateAlert("Stack empty, no elements to drop.");
        }
    }

    @FXML
    private void over() {
        try {
            c.over();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    @FXML
    private void clear() {
        c.clear();
    }

    /*
     * Method that shows on the input box the label of the button clicked.
     */
    @FXML
    private void digit(MouseEvent event) {
        Button b = (Button)event.getSource();
        inputBox.appendText(b.getText().replaceAll("\\(", "").replaceAll("\\)", ""));
    }
}
