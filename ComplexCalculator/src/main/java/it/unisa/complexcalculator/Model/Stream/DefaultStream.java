package it.unisa.complexcalculator.Model.Stream;

import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;

/**
 *
 * @author mdr
 */
public class DefaultStream extends Stream {

    @Override
    public void save(Scene scene) {
        File f = new File("backup");
        try {
            saveData(f.getAbsolutePath());
            generateConfirmation("Saved successfully.");           
        } catch (IOException ex) {
            generateAlert("Error while saving file.");
        }
    }

    @Override
    public void load(Scene scene) {
        File f = new File("backup");
        try {
            loadData(f.getAbsolutePath());
            generateConfirmation("Loaded successfully.");           
        } catch (IOException ex) {
            generateAlert("Error while loading file.");
        }
    }

}
