package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Exception.ReferencedOperationException;
import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.OperationFactory;
import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OperationMemory implements Serializable{

    private ObservableList<CustomOperation> ops;
    private static OperationMemory instance = null;
    
    public static OperationMemory getOperationMemory(){
        if(instance == null)
            instance = new OperationMemory();
        return instance;
    }
    
    private OperationMemory() {
        ops = FXCollections.observableArrayList();
    }
    
    public void removeCustomOperation(CustomOperation op){
        if(checkNameInSequence(op.getName()))
            throw new ReferencedOperationException();
        ops.remove(op);
    }
    
    public void addCustomOperation(CustomOperation op){
        if(checkDuplicate(op.getName())){
            throw new AlreadyExistentOperationException();
        }
        ops.add(op);
    }
    
    public CustomOperation getCustomOperation(String name){
        for (CustomOperation op : ops){
            if (op.getName().equals(name))
                return op;
            
        }
        return null;
    }
    
    public void refreshName(String oldName, String newName){
        if(checkNameInSequence(oldName))
            throw new ReferencedOperationException();
        if(checkDuplicate(newName))
            throw new AlreadyExistentOperationException();
        getCustomOperation(oldName).setName(newName);
    }
    
    public void refreshSequence(String newSequence, String name){
        getCustomOperation(name).setSequence(newSequence);
    }
    
    public void clear(){
        ops.clear();
    }
    
    public int opLen(){
        return ops.size();
    }
    
    public ObservableList<CustomOperation> getOps() {
        return ops;
    } 
    
    private boolean checkNameInSequence(String name){
        for(CustomOperation o : ops){
            String[] tokens = o.getSequence().split(" ");
            for(String s : tokens){
                if(s.equals(name))
                    return true;
            }
        }
        return false;
    }
    
    private boolean checkDuplicate(String name){
        for(CustomOperation o : ops){
            if(o.getName().equals(name))
                return true;
        }
        return false;
    }
}
