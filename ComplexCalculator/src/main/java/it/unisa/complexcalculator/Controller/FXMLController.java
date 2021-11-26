package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;


public class FXMLController implements Initializable {

    @FXML
    private Button dotButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button prodButton;
    @FXML
    private Button divButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button invButton;
    @FXML
    private ListView<ComplexNumber> storedElements;
    @FXML
    private Label realLabel;
    @FXML
    private Label imgLabel;
    @FXML
    private Button realButton;
    @FXML
    private Button imgButton;
    @FXML
    private ToggleButton signReal;
    @FXML
    private ToggleButton signImg;
    
    Calculator c = new Calculator();

    /**
     * Initializes all elements according to user preferences by default
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {                 
        storedElements.setItems(c.getStoredNumbers().getStack());       
        realButton.setDisable(true);
        refreshButtonState();
    }
    
    /*
     * Method to handle changing button properties after specific operations
     */
    private void refreshButtonState(){
        
        if (realButton.isDisable()){
            if (realLabel.getText().contains("."))
                dotButton.setDisable(true);
            else
                dotButton.setDisable(false);
        }else{
            if (imgLabel.getText().contains("."))
                dotButton.setDisable(true);
            else
                dotButton.setDisable(false);
        }
        
        int size = c.getStoredNumbers().len();
        if(size>=2){
            plusButton.setDisable(false);
            minusButton.setDisable(false);
            prodButton.setDisable(false);
            divButton.setDisable(false);
            sqrtButton.setDisable(false);
            invButton.setDisable(false);
        }else if (size == 1){
            plusButton.setDisable(true);
            minusButton.setDisable(true);
            prodButton.setDisable(true);
            divButton.setDisable(true);
            sqrtButton.setDisable(false);
            invButton.setDisable(false);
        }else{
            plusButton.setDisable(true);
            minusButton.setDisable(true);
            prodButton.setDisable(true);
            divButton.setDisable(true);
            sqrtButton.setDisable(true);
            invButton.setDisable(true);
        }

    }
    
    /*
     * Method to manage the modification of the labels according to the pressed button 
     */
    private void updateLabel(String to_add) {
        if (realLabel.getText().equalsIgnoreCase("err") && imgLabel.getText().equalsIgnoreCase("err")){
            realLabel.setText("");
            imgLabel.setText("");
        }
        if (realButton.isDisable()) {
            if ("del".equals(to_add) && realLabel.getText().length() > 0) {
                if ("Re".equals(realLabel.getText())) {
                    realLabel.setText("");
                } else {
                    realLabel.setText(realLabel.getText().substring(0, realLabel.getText().length() - 1));
                }
            } else if ("Re".equals(realLabel.getText())) {
                realLabel.setText(to_add);
            } else if (!"del".equals(to_add)) {
                realLabel.setText(realLabel.getText() + to_add);
            }
        } else {
            if ("del".equals(to_add) && imgLabel.getText().length() > 0) {
                if ("Im".equals(imgLabel.getText())) {
                    imgLabel.setText("");
                } else {
                    imgLabel.setText(imgLabel.getText().substring(0, imgLabel.getText().length() - 1));
                }
            } else if ("Im".equals(imgLabel.getText())) {
                imgLabel.setText(to_add);
            } else if (!"del".equals(to_add)) {
                imgLabel.setText(imgLabel.getText() + to_add);
            }
        }
        refreshButtonState();
    }
    
    /*
     * Method to manage the modification of the labels when button with "1" as label is clicked
     */
    @FXML
    private void oneClicked(MouseEvent event) {
        updateLabel("1");
    }
    
    /*
     * Method to manage the modification of the labels when button with "2" as label is clicked
     */
    @FXML
    private void twoClicked(MouseEvent event) {
        updateLabel("2");
    }

    /*
     * Method to manage the modification of the labels when button with "3" as label is clicked
     */
    @FXML
    private void threeClicked(MouseEvent event) {
        updateLabel("3");
    }
    
    /*
     * Method to manage the modification of the labels when button with "4" as label is clicked
     */
    @FXML
    private void fourClicked(MouseEvent event) {
        updateLabel("4");
    }

    /*
     * Method to manage the modification of the labels when button with "5" as label is clicked
     */
    @FXML
    private void fiveClicked(MouseEvent event) {
        updateLabel("5");
    }

    /*
     * Method to manage the modification of the labels when button with "6" as label is clicked
     */
    @FXML
    private void sixClicked(MouseEvent event) {
        updateLabel("6");
    }

    /*
     * Method to manage the modification of the labels when button with "7" as label is clicked
     */
    @FXML
    private void sevenClicked(MouseEvent event) {
        updateLabel("7");
    }

    /*
     * Method to manage the modification of the labels when button with "8" as label is clicked
     */
    @FXML
    private void eightClicked(MouseEvent event) {
        updateLabel("8");
    }

    /*
     * Method to manage the modification of the labels when button with "9" as label is clicked
     */
    @FXML
    private void nineClicked(MouseEvent event) {
        updateLabel("9");
    }

    /*
     * Method to manage the modification of the labels when button with "." as label is clicked
     */
    @FXML
    private void dotClicked(MouseEvent event) {
        updateLabel(".");
    }

    /*
     * Method to manage the modification of the labels when button with "0" as label is clicked
     */
    @FXML
    private void zeroClicked(MouseEvent event) {
        updateLabel("0");
    }

    /*
     * Method to manage the storing of a new complex number when button with "INS" as label is clicked
     */
    @FXML
    private void insClicked(MouseEvent event) {
        String real;
        String img;
        
        if (realLabel.getText().isEmpty() && imgLabel.getText().isEmpty())
            return;
        if (realLabel.getText().equalsIgnoreCase("err") && imgLabel.getText().equalsIgnoreCase("err"))
            return;
        
        if ("+".equals(signReal.getText()))
            real = "+" + realLabel.getText();
        else
            real = "-" + realLabel.getText();
        
        if ("+".equals(signImg.getText()))
            img = "+" + imgLabel.getText();
        else
            img = "-" + imgLabel.getText();
        
        
        c.pushNumber(real, img);
        refreshButtonState();
    }
    
    /*
     * Method to manage the modification of the labels when button with "del" as label is clicked
     */
    @FXML
    private void delClicked(MouseEvent event) {
        updateLabel("del");        
    }
    
    /*
     * Method to manage the associated operation when button with "+" as label is clicked
     */
    @FXML
    private void plusClicked(MouseEvent event) {
        c.add();
        refreshButtonState();
    }

    /*
     * Method to manage the associated operation when button with "-" as label is clicked
     */
    @FXML
    private void minusClicked(MouseEvent event) {
        c.subtract();
        refreshButtonState();
    }

    /*
     * Method to manage the associated operation when button with "x" as label is clicked
     */
    @FXML
    private void prodClicked(MouseEvent event) {
        c.multiply();
        refreshButtonState();
    }

    /*
     * Method to manage the associated operation when button with "%" as label is clicked
     */
    @FXML
    private void divClicked(MouseEvent event) {
        try{
            c.divide();
        } catch(RuntimeException ex){
            imgLabel.setText("Err");
            realLabel.setText("Err");
        }
        refreshButtonState();
    }

    /*
     * Method to manage the associated operation when button with "√" as label is clicked
     */
    @FXML
    private void sqrtClicked(MouseEvent event) {
        c.squareRoot();
        refreshButtonState();
    }

    /*
     * Method to manage the associated operation when button with "+-" as label is clicked
     */
    @FXML
    private void invClicked(MouseEvent event) {
        c.invertSign();
        refreshButtonState();
    }

    /*
     * Method to manage the action of signReal toggleButton clicked
     */
    @FXML
    private void changeRealSign(ActionEvent event) {
        if (signReal.isSelected()) {
            signReal.setText("+");
        } else {
            signReal.setText("-");
        }
    }

    /*
     * Method to manage the action of signImg toggleButton clicked
     */
    @FXML
    private void changeImgSign(ActionEvent event) {
        if (signImg.isSelected()) {
            signImg.setText("+");
        } else {
            signImg.setText("-");
        }
    }

    /*
     * Method to manage the modification of the labels when button with "AC" as label is clicked
     */
    @FXML
    private void acClicked(MouseEvent event) {
        realLabel.setText("");
        imgLabel.setText("");
        refreshButtonState();
    }

    /*
     * Method to manage the selected label to use when button with "Re" as label is clicked
     */
    @FXML
    private void realClicked(MouseEvent event) {
        realButton.setDisable(true);
        imgButton.setDisable(false);
        refreshButtonState();
    }

    /*
     * Method to manage the selected label to use when button with "Im" as label is clicked
     */
    @FXML
    private void imgClicked(MouseEvent event) {
        imgButton.setDisable(true);
        realButton.setDisable(false);
        refreshButtonState();
    }

}
