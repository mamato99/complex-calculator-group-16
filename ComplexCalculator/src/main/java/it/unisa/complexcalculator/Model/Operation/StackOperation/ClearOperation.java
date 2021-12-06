package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class ClearOperation implements Operation{
    private Calculator c;

    public ClearOperation(Calculator c) {
        this.c = c;
    }
    
    /*
     * Method for the execution of the Clear Operation 
    */
    @Override
    public void execute() {
        c.clear();
    }
}
