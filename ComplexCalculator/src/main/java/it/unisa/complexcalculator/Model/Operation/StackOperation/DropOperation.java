package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DropOperation implements Operation {

    private Calculator c;

    public DropOperation(Calculator c) {
        this.c = c;
    }

    /*
     * Method for the execution of the Drop Operation 
     */
    @Override
    public void execute() {
        c.drop();
    }
}
