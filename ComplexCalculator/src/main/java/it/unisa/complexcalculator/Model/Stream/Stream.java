/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.complexcalculator.Model.Stream;

import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Memory.OperationMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author mdr
 */
public abstract class Stream {
    
    public abstract void save(Scene scene);
    public abstract void load(Scene scene);
    
    public void saveData(String file) throws FileNotFoundException, IOException{
        OperationMemory opMem = OperationMemory.getOperationMemory();
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        dout.writeInt(opMem.opLen());

        for (CustomOperation op : opMem.getOps()) {
            String toWrite = op.getName() + ":" + op.getSequence();
            dout.writeUTF(toWrite);
        }
        dout.flush();
        dout.close();
    }
    
    public void loadData(String file) throws FileNotFoundException, IOException{
        ConcreteOperationFactory opFac = new ConcreteOperationFactory();
        OperationMemory opMem = OperationMemory.getOperationMemory();
        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int n = din.readInt();
        opMem.clear();

        String token;

        for (int i = 0; i < n; i++) {
            token = din.readUTF();
            
            opMem.addCustomOperation(opFac.createCustomOperation(token.split(":")[0], token.split(":")[1])); // Null because before invoking it, the calculator populates the arraydeque of operations
        }
    }
    
      /*
     * Method that generates an alert.
     */
    protected void generateAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.ERROR, s, ButtonType.OK);
        alert.showAndWait();
    }
    
    /*
     * Method that generates an alert.
     */
    protected void generateConfirmation(String s) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, s, ButtonType.OK);
        alert.showAndWait();
    }
    
}
