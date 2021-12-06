package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SqrtOperation implements Operation {

    private Calculator c;

    public SqrtOperation(Calculator c) {
        this.c = c;
    }

    /*
     * Method for the execution of the Square Root Operation 
     */
    @Override
    public void execute() {
        c.squareRoot();
    }
}
