package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class StackToVariableOperation extends Operation {
    
    private final VariableMemory var;
    private final NumberMemory num;
    private final Character c;

    public StackToVariableOperation (NumberMemory num, VariableMemory var, Character c) {
        this.var = var;
        this.num = num;
        this.c = c;
    }

    @Override
    public void execute() {
        var.addVariable(c, num.pop());
    }

}