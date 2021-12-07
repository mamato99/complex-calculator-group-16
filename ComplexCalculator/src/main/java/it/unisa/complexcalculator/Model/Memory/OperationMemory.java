package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.Operation.Operation;

import java.util.HashMap;

public class OperationMemory {

    private HashMap<String, Operation> operations;

    public OperationMemory() {
        operations = new HashMap<>();
    }
    
    public void addOperation(String name, Operation op){
        operations.put(name, op);
    }
    
    public Operation getOperation(String name){
        return operations.get(name);
    }
    
    
}
