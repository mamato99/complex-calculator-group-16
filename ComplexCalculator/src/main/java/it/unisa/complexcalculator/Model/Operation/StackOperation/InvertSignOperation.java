
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class InvertSignOperation implements Operation{
    private Calculator c;

    public InvertSignOperation(Calculator c) {
        this.c = c;
    }
    
    /*
     * Method for the execution of the Invert Sign Operation 
    */
    @Override
    public void execute() {
        c.invertSign();
    }
}
