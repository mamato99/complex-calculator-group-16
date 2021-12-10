package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class SubtractToVariableOperation extends Operation {

    private final Character c;

    public SubtractToVariableOperation(Character c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        var.updateVariable(c, ComplexOperations.difference(var.getVariable(c), num.pop()));
    }
    
}
