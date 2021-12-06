package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class AddOperation implements Operation{
    private final Calculator c;

    public AddOperation(Calculator c) {
        this.c = c;
    }
    /*
     * Method for the execution of the Add Operation 
    */
    @Override
    public void execute() {
        c.add();
    }
    
}
