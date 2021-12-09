
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Memory.VariableStack;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class RestoreOperation extends Operation {

    private final VariableMemory var;
    private final VariableStack varStack;

    public RestoreOperation() {
        this.var = VariableMemory.getVariableMemory();
        this.varStack = VariableStack.getVariableStack();
    }

    @Override
    public void execute() {
        var.getVars().clear();
        for(Variable v : varStack.pop()){
            var.getVars().add(v);
        }
    }

}
