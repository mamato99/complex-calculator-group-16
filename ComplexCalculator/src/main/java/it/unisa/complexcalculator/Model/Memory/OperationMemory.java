package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OperationMemory {

    private ObservableList<CustomOperation> ops;

    public OperationMemory() {
        ops = FXCollections.observableArrayList();
    }
    
    public void addCustomToOperationMemory(CustomOperation op){
        //controllo
        if(contains(op.getName())){
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
    
    public void refreshSequences(String oldName, String newName){
        if(contains(newName))
            throw new AlreadyExistentOperationException();
        for(CustomOperation op: ops){
            op.setSequence(op.getSequence().replaceAll(oldName, newName));
        }
    }
    
    public ObservableList<CustomOperation> getOps() {
        return ops;
    }

    public void setOps(ObservableList<CustomOperation> ops) {
        this.ops = ops;
    }   
    
    private boolean contains(String name){
        for(CustomOperation o : ops){
            if(o.getName().equals(name))
                return true;
        }
        return false;
    }
}
