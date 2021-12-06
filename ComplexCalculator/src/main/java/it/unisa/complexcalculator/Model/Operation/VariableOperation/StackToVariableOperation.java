
package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class StackToVariableOperation implements Operation {
    private Calculator c;
    private Character var;

    public StackToVariableOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    /*
     * Method for the execution of the stackToVariable Operation 
     */
    @Override
    public void execute() {
        c.stackToVariable(var);
    }
    
}
