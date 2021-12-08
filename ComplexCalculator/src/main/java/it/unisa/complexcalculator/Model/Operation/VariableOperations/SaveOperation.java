package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Memory.VariableStack;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SaveOperation extends Operation {

    private final VariableMemory var;
    private final VariableStack varStack;

    public SaveOperation(VariableMemory var, VariableStack varStack) {
        this.var = var;
        this.varStack = varStack;
    }

    @Override
    public void execute() {
        varStack.push(var.getVarsAsList());
    }

}
