
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class RestoreOperation implements Operation {

    @Override
    public void execute() {
        VariableMemory varMem = VariableMemory.getVariableMemory();
        varMem.loadVariableState();
    }

}
