
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class SwapOperation implements Operation{
    private Calculator c;

    public SwapOperation(Calculator c) {
        this.c = c;
    }
    
    /*
     * Method for the execution of the Swap Operation 
     */
    @Override
    public void execute() {
        c.swap();
    }
}
