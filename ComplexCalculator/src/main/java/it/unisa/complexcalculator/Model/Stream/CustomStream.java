package it.unisa.complexcalculator.Model.Stream;

import java.io.File;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.FileChooser;

/**
 * The istance of a <code>CustomStream</code> class represent represents an
 * object that allows the flow of data on file, both in input and in output. In
 * this case the file will be choosed by the user.
 */
public class CustomStream extends Stream {
    
    private final Scene scene;

    public CustomStream(Scene scene) {
        this.scene = scene;
    }
    
    /**
     * Takes the file on which save data from the user and calls the
     * <code>saveData()</code> method.
     *
     * @return the file pointer
     */
    @Override
    public File save() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save file...");
        File f = fc.showSaveDialog(scene.getWindow());
        if (f != null) {
            try {
                saveData(f.getAbsolutePath());
                return f;
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }

    /**
     * Takes the file from which load data from the user and calls the
     * <code>loadData()</code> method.
     * 
     * @return the file pointer
     */
    @Override
    public File load() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose file...");
        File f = fc.showOpenDialog(scene.getWindow());
        if (f != null) {
            try {
                loadData(f.getAbsolutePath());
                return f;
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }

}
