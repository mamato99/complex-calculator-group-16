package it.unisa.complexcalculator.Model.Stream;

import java.io.File;
import java.io.IOException;

/**
 * The istance of a <code>DefaultStream</code> class represent represents an
 * object that allows the flow of data on file, both in input and in output. In
 * this case the file will be the default, named "backup".
 */
public class DefaultStream extends Stream {

    /**
     * Takes the file on which save data from the user and calls the
     * <code>saveData()</code> method.
     *
     * @return the file pointer
     */
    @Override
    public File save() {
        File f = new File("backup");
        try {
            saveData(f.getAbsolutePath());     
            return f;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Takes the file from which load data from the user and calls the
     * <code>loadData()</code> method.
     * 
     * @return the file pointer 
     */
    @Override
    public File load() {
        File f = new File("backup");
        try {
            loadData(f.getAbsolutePath());
            return f;           
        } catch (IOException ex) {
            return null;
        }
    }

}
