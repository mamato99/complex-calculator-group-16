package it.unisa.complexcalculator.Controller;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable{

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
    private ListView<String> storedElements;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        storedElements.setItems(FXCollections.observableArrayList("3+2i", "6+6i", "5", "6+6i","6+6i","6+6i"));
    }
    
    private void updateLabel(String to_add) {
        /*
        if ("del".equals(to_add) && userLabel.getText().length() > 0) {
            if ("Welcome".equals(userLabel.getText())) {
                userLabel.setText("");
            } else {
                userLabel.setText(userLabel.getText().substring(0, userLabel.getText().length() - 1));
            }
        } else if ("Welcome".equals(userLabel.getText())) {
            userLabel.setText(to_add);
        } else if (!"del".equals(to_add)) {
            userLabel.setText(userLabel.getText() + to_add);
        }
        */
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
    }

    @FXML
    private void delClicked(MouseEvent event) {
        updateLabel("del");
    }

    @FXML
    private void plusClicked(MouseEvent event) {
        updateLabel("+");
    }

    @FXML
    private void minusClicked(MouseEvent event) {
        updateLabel("-");
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
        }else
            signReal.setText("-");
    }

    @FXML
    private void changeImgSign(ActionEvent event) {
        if (signImg.isSelected()) {
            signImg.setText("+");
        }else
            signImg.setText("-");
    }

    @FXML
    private void acClicked(MouseEvent event) {
    }

    @FXML
    private void realClicked(MouseEvent event) {
    }

    @FXML
    private void imgClicked(MouseEvent event) {
    }

}
