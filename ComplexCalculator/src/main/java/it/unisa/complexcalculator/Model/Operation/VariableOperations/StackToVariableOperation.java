package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class StackToVariableOperation extends Operation {
    
    private final VariableMemory var;
    private final NumberMemory num;
    private final Character c;

    public StackToVariableOperation (Character c) {
        this.var = VariableMemory.getVariableMemory();
        this.num = NumberMemory.getNumberMemory();
        this.c = c;
    }

    @Override
    public void execute() {
        var.updateVariable(c, num.pop());
    }

}