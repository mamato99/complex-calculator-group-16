
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class DupOperation implements Operation{
    private Calculator c;

    public DupOperation(Calculator c) {
        this.c = c;
    }
    
    /*
     * Method for the execution of the Dup Operation 
     */
    @Override
    public void execute() {
        c.dup();
    }
}
