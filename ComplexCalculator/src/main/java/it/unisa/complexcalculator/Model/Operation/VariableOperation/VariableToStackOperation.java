package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class VariableToStackOperation implements Operation {
    private final Calculator c;
    private final Character var;

    public VariableToStackOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    /*
     * Method for the execution of the stackToVariable Operation 
     */
    @Override
    public void execute() {
        c.variableToStack(var);
    }
    
}
