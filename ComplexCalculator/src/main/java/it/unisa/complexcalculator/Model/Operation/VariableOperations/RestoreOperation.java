
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class RestoreOperation extends Operation {

    private final VariableMemory var;

    public RestoreOperation(VariableMemory var) {
        this.var = var;
    }

    @Override
    public void execute() {
        
    }

}
