
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class SubtractOperation implements Operation{
    private Calculator c;

    public SubtractOperation(Calculator c) {
        this.c = c;
    }
    
    /*
     * Method for the execution of the Subtract Operation 
    */
    @Override
    public void execute() {
        c.subtract();
    }
}
