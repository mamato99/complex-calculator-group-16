package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

public class VariableToStackOperation implements Operation {
    
    private final VariableMemory var;
    private final NumberMemory num;
    private final Character c;

    public VariableToStackOperation(NumberMemory num, VariableMemory var, Character c) {
        this.var=var;
        this.num=num;
        this.c = c;
    }
    
    @Override
    public void execute() {        
        num.push(var.getVariable(c));
    }
    
}
