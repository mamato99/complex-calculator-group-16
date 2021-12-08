package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Model.Operation.Operation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OperationMemory {

    private ObservableList<Operations> ops;

    public OperationMemory() {
        ops = FXCollections.observableArrayList();
    }
    
    public void addOperation(String name, String sequence, Operation op){
        //controllo
        if(contains(name)){
            throw new AlreadyExistentOperationException();
        }
        ops.add(new Operations(name, sequence, op));
    }
    
    public Operation getOperation(String name){
        for (Operations c : ops){
            if (c.getName().equals(name))
                return c.getOp();
            
        }
        return null;
    }

    public ObservableList<Operations> getOps() {
        return ops;
    }

    public void setOps(ObservableList<Operations> ops) {
        this.ops = ops;
    }   
    
    private boolean contains(String name){
        for(Operations o : ops){
            if(o.getName().equals(name))
                return true;
        }
        return false;
    }
}
