package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class AddToVariableOperation extends Operation {

    private final VariableMemory var;
    private final NumberMemory num;
    private final Character c;

    public AddToVariableOperation(Character c) {
        this.var = VariableMemory.getVariableMemory();
        this.num = NumberMemory.getNumberMemory();
        this.c = c;
    }

    @Override
    public void execute() {
        var.updateVariable(c, ComplexOperations.add(var.getVariable(c), num.pop()));
    }

}