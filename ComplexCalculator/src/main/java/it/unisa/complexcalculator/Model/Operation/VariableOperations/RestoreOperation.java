
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class RestoreOperation extends Operation {

    private final VariableMemory varMem;

    public RestoreOperation() {
        this.varMem = VariableMemory.getVariableMemory();
    }

    @Override
    public void execute() {
        varMem.loadVariableState();
    }

}
