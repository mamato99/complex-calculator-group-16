
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SaveOperation extends Operation {

    private final VariableMemory var;

    public SaveOperation (VariableMemory var) {
        this.var = var;
    }

    @Override
    public void execute() {
        
    }

}

