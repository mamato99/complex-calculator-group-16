
package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;


public class AddToVariableOperation implements Operation {
    Calculator c;
    Character var;

    public AddToVariableOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    /*
     * Method for the execution of the addToVariable Operation 
     */
    @Override
    public void execute() {
        c.addToVariable(var);
    }
    
}
