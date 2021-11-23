package it.unisa.complexcalculator;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLController {

    @FXML
    private Button primaryButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
