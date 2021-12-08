
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Memory.VariableStack;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class RestoreOperation extends Operation {

    private final VariableMemory var;
    private final VariableStack varStack;

    public RestoreOperation(VariableMemory var, VariableStack varStack) {
        this.var = var;
        this.varStack = varStack;
    }

    @Override
    public void execute() {
        var.setVarsFromList(varStack.pop());
    }

}
