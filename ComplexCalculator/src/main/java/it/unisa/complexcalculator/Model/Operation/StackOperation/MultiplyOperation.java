
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class MultiplyOperation implements Operation {

    private Calculator c;

    public MultiplyOperation(Calculator c) {
        this.c = c;
    }

    /*
     * Method for the execution of the Multiply Operation 
     */
    @Override
    public void execute() {
        c.multiply();
    }
}
