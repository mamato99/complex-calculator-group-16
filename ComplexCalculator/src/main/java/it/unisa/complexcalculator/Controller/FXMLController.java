package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private ListView<ComplexNumber> storedElements;

    private KeyCombination sum;
    private KeyCombination difference;

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

        sum = new KeyCodeCombination(KeyCode.S, KeyCodeCombination.SHIFT_DOWN);
        difference = new KeyCodeCombination(KeyCode.D, KeyCodeCombination.SHIFT_DOWN);

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
     * Method to manage the modification of the labels when button with "1" as label is clicked
     */
    @FXML
    private void oneClicked() {
        updateInputBox("1");
    }

    /*
     * Method to manage the modification of the labels when button with "2" as label is clicked
     */
    @FXML
    private void twoClicked() {
        updateInputBox("2");
    }

    /*
     * Method to manage the modification of the labels when button with "3" as label is clicked
     */
    @FXML
    private void threeClicked() {
        updateInputBox("3");
    }

    /*
     * Method to manage the modification of the labels when button with "4" as label is clicked
     */
    @FXML
    private void fourClicked() {
        updateInputBox("4");
    }

    /*
     * Method to manage the modification of the labels when button with "5" as label is clicked
     */
    @FXML
    private void fiveClicked() {
        updateInputBox("5");
    }

    /*
     * Method to manage the modification of the labels when button with "6" as label is clicked
     */
    @FXML
    private void sixClicked() {
        updateInputBox("6");
    }

    /*
     * Method to manage the modification of the labels when button with "7" as label is clicked
     */
    @FXML
    private void sevenClicked() {
        updateInputBox("7");
    }

    /*
     * Method to manage the modification of the labels when button with "8" as label is clicked
     */
    @FXML
    private void eightClicked() {
        updateInputBox("8");
    }

    /*
     * Method to manage the modification of the labels when button with "9" as label is clicked
     */
    @FXML
    private void nineClicked() {
        updateInputBox("9");
    }

    /*
     * Method to manage the modification of the labels when button with "." as label is clicked
     */
    @FXML
    private void dotClicked() {
        updateInputBox(".");
    }

    /*
     * Method to manage the modification of the labels when button with "0" as label is clicked
     */
    @FXML
    private void zeroClicked() {
        updateInputBox("0");
    }

    /*
     * Method to manage the storing of a new complex number when button with "INS" as label is clicked
     */
    @FXML
    private void insClicked() {
        double real = 0;
        double img = 0;

        String input = inputBox.getText();

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
                    img += Double.parseDouble(s.substring(0, s.length() - 1));
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
        try{
            c.add();
        }catch(NotEnoughOperandsException ex){
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
        try{
            c.subtract();
        }catch(NotEnoughOperandsException ex){
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "x" as label is clicked
     */
    @FXML
    private void prodClicked() {
        try{
            c.multiply();
        }catch(NotEnoughOperandsException ex){
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "%" as label is clicked
     */
    @FXML
    private void divClicked() {
         try{
            c.divide();
        }catch(NotEnoughOperandsException ex){
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "√" as label is clicked
     */
    @FXML
    private void sqrtClicked() {
         try{
            c.squareRoot();
        }catch(NotEnoughOperandsException ex){
            generateAlert("Not enough operands.");
        }
    }

    /*
     * Method to manage the associated operation when button with "+-" as label is clicked
     */
    @FXML
    private void invClicked() {
         try{
            c.invertSign();
        }catch(NotEnoughOperandsException ex){
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
    private void handleKey(KeyEvent event) {
        if (sum.match(event)) {
            plusClicked();
        }
        if (difference.match(event)) {
            minusClicked();
        }
    }

    @FXML
    private void posClicked() {
        updateInputBox("+");
    }

    @FXML
    private void negClicked() {
        updateInputBox("-");
    }

    @FXML
    private void gtClicked() {
    }

    @FXML
    private void ltClicked() {
    }

    @FXML
    private void dupClicked() {
    }

    @FXML
    private void swapClicked() {
         try{
            c.swap();
        }catch(NotEnoughOperandsException ex){
            generateAlert("Not enough operands.");
        }
    }

    @FXML
    private void dropClicked() {
    }

    @FXML
    private void overClicked() {
    }

    @FXML
    private void clearClicked() {
    }

    private void getNumbers() {

    }

    @FXML
    private void imgClicked(MouseEvent event) {
    }

}
