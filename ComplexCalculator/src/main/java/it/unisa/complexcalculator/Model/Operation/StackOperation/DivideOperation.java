package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class DivideOperation implements Operation {

    private Calculator c;

    public DivideOperation(Calculator c) {
        this.c = c;
    }

    /*
     * Method for the execution of the Divide Operation 
    */
    @Override
    public void execute() {
        c.divide();
    }
}
