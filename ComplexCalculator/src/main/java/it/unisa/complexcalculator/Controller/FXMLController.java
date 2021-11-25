package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button twoButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button dotButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button insButton;
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
    private Button delButton;
    @FXML
    private Button acButton1;
    @FXML
    private Button realButton;
    @FXML
    private Button imgButton;
    @FXML
    private ToggleButton signReal;
    @FXML
    private ToggleButton signImg;
    
    
    ObservableList<ComplexNumber> values;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        values= FXCollections.observableArrayList();
        //storedElements.setItems(FXCollections.observableArrayList(new ComplexNumber(Double.parseDouble("3"), Double.parseDouble("2"))));
        storedElements.setItems(values);
        
        realButton.setDisable(true);
        

    }

    private void updateLabel(String to_add) {
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
    }

    @FXML
    private void oneClicked(MouseEvent event) {
        updateLabel("1");
    }

    @FXML
    private void twoClicked(MouseEvent event) {
        updateLabel("2");
    }

    @FXML
    private void threeClicked(MouseEvent event) {
        updateLabel("3");
    }

    @FXML
    private void fourClicked(MouseEvent event) {
        updateLabel("4");

    }

    @FXML
    private void fiveClicked(MouseEvent event) {
        updateLabel("5");
    }

    @FXML
    private void sixClicked(MouseEvent event) {
        updateLabel("6");
    }

    @FXML
    private void sevenClicked(MouseEvent event) {
        updateLabel("7");
    }

    @FXML
    private void eightClicked(MouseEvent event) {
        updateLabel("8");
    }

    @FXML
    private void nineClicked(MouseEvent event) {
        updateLabel("9");
    }

    @FXML
    private void dotClicked(MouseEvent event) {
        updateLabel(".");
    }

    @FXML
    private void zeroClicked(MouseEvent event) {
        updateLabel("0");
    }

    private void imClicked(MouseEvent event) {
        updateLabel("i");
    }

    @FXML
    private void insClicked(MouseEvent event) {
        double real, img;
        if ("+".equals(signReal.getText()))
            real = Double.parseDouble(realLabel.getText());
        else
            real = -Double.parseDouble(realLabel.getText());
        
        if ("+".equals(signImg.getText()))
            img = Double.parseDouble(imgLabel.getText());
        else
            img = -Double.parseDouble(imgLabel.getText());
            
        values.add(new ComplexNumber(real, img));
    }

    @FXML
    private void delClicked(MouseEvent event) {
        updateLabel("del");
        
    }

    @FXML
    private void plusClicked(MouseEvent event) {
        
    }

    @FXML
    private void minusClicked(MouseEvent event) {
        
    }

    @FXML
    private void prodClicked(MouseEvent event) {
    }

    @FXML
    private void divClicked(MouseEvent event) {
    }

    @FXML
    private void sqrtClicked(MouseEvent event) {
    }

    @FXML
    private void invClicked(MouseEvent event) {
    }

    @FXML
    private void changeRealSign(ActionEvent event) {
        if (signReal.isSelected()) {
            signReal.setText("+");
        } else {
            signReal.setText("-");
        }
    }

    @FXML
    private void changeImgSign(ActionEvent event) {
        if (signImg.isSelected()) {
            signImg.setText("+");
        } else {
            signImg.setText("-");
        }
    }

    @FXML
    private void acClicked(MouseEvent event) {
        realLabel.setText("");
        imgLabel.setText("");
    }

    @FXML
    private void realClicked(MouseEvent event) {
        realButton.setDisable(true);
        imgButton.setDisable(false);
    }

    @FXML
    private void imgClicked(MouseEvent event) {
        imgButton.setDisable(true);
        realButton.setDisable(false);
    }

}
