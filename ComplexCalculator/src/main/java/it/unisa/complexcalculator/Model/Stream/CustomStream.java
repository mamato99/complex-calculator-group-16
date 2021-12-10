package it.unisa.complexcalculator.Model.Stream;

import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

public class CustomStream extends Stream{

    @Override
    public void save(Scene scene) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save file...");
        File f = fc.showSaveDialog(scene.getWindow());
        if (f != null) {
            try {
                saveData(f.getAbsolutePath());
                generateConfirmation("Saved successfully.");
            } catch (IOException ex) {
                generateAlert("Error while saving file.");
            }
        }
    }

    @Override
    public void load(Scene scene) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose file...");
        File f = fc.showOpenDialog(scene.getWindow());
        if (f != null) {
            try {
                loadData(f.getAbsolutePath());
                generateConfirmation("Loaded successfully."); 
            } catch (IOException ex) {
                generateAlert("Error while loading file.");
            }
        }
    }
    
}