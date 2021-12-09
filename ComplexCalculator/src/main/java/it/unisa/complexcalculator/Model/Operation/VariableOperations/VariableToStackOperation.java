package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class VariableToStackOperation extends Operation {
    
    private final VariableMemory var;
    private final NumberMemory num;
    private final Character c;

    public VariableToStackOperation(Character c) {
        this.var = VariableMemory.getVariableMemory();
        this.num = NumberMemory.getNumberMemory();
        this.c = c;
    }
    
    @Override
    public void execute() {        
        num.push(var.getVariable(c));
    }
    
}
