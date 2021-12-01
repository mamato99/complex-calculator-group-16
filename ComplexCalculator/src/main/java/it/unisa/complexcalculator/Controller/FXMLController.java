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
import javafx.scene.input.KeyEvent;
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
        
    }

    /*
     * Method to manage the modification of the labels according to the pressed button 
     */
    private void updateInputBox(String upd) {

        if ("del".equals(upd) && inputBox.getText().length() > 0) {
            inputBox.deletePreviousChar();
        } else if ("ac".equals(upd) && inputBox.getText().length() > 0) {
            inputBox.setText("");
        } else {
            inputBox.appendText(upd);
        }
    }

    /*
     * Method to manage the storing of a new complex number when button with "INS" as label is clicked
     */
    @FXML
    private void insClicked() {

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
            case "dup": dupClicked(); return true;
            case "clear": clearClicked(); return true;
            case "swap": swapClicked(); return true;
            case "drop": dropClicked(); return true;
            case "over": overClicked(); return true;
            case "+": plusClicked(); return true;
            case "-": minusClicked(); return true;
            case "*": prodClicked(); return true;
            case "/": divClicked(); return true;
            case "sqrt": sqrtClicked(); return true;
            case "+-": invClicked(); return true;
            default: return false;
        }
    }
    
    private boolean checkVariableOperation(String in){
        if(in.length() != 2)
            return false;
        if(!(in.startsWith(">") || in.startsWith("<") || in.startsWith("+") || in.startsWith("-")))
            return false;
        return in.substring(1).matches("[a-z]");
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
                    if (!s.matches(".*\\d.*")) {
                        if (s.contains("-")) img -= 1;
                        else img += 1;
                    } else {
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
    private void delClicked() {
        updateInputBox("del");
    }

    /*
     * Method to manage the associated operation when button with "+" as label is clicked
     */
    @FXML
    private void plusClicked() {
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
    private void minusClicked() {
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
    private void prodClicked() {
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
    private void divClicked() {
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
    private void sqrtClicked() {
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
    private void invClicked() {
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
    private void acClicked() {
        updateInputBox("ac");
    }

    @FXML
    private void handleSpecialKeys(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER))
            insClicked();
        if (event.getCode().equals(KeyCode.ESCAPE))
            acClicked();
    }
    
    @FXML
    private void dupClicked() {
        try {
            c.dup();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not Enough Operands.");
        }
    }

    @FXML
    private void swapClicked() {
        try {
            c.swap();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    @FXML
    private void dropClicked() {
        try {
            c.drop();
        } catch (EmptyStackException ex) {
            generateAlert("Stack empty, no elements to drop.");
        }
    }

    @FXML
    private void overClicked() {
        try {
            c.over();
        } catch (NotEnoughOperandsException ex) {
            generateAlert("Not enough operands.");
        }
    }

    @FXML
    private void clearClicked() {
        c.clear();
    }

    /*
     * Method that shows on the input box the label of the button clicked.
     */
    @FXML
    private void digitClicked(MouseEvent event) {
        Button b = (Button)event.getSource();
        updateInputBox(b.getText().replaceAll("\\(", "").replaceAll("\\)", ""));
    }

}
