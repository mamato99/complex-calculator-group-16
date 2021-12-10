package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class VariableToStackOperation extends Operation {

    private final Character c;

    public VariableToStackOperation(Character c) {
        this.c = c;
    }
    
    @Override
    public void execute() {       
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        num.push(var.getVariable(c));
    }
    
}
