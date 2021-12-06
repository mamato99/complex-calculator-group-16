package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class OverOperation implements Operation {

    private Calculator c;

    public OverOperation(Calculator c) {
        this.c = c;
    }

    /*
     * Method for the execution of the Over Operation 
     */
    @Override
    public void execute() {
        c.over();
    }
}
