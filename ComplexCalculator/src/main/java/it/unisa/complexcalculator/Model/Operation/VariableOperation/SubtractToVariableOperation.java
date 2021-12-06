
package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class SubtractToVariableOperation implements Operation {
    Calculator c;
    Character var;

    public SubtractToVariableOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    /*
     * Method for the execution of the stackToVariable Operation 
     */
    @Override
    public void execute() {
        c.subtractToVariable(var);
    }
    
}
