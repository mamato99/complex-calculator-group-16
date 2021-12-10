
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "loadVariablesState" operation of the calculator.
 * <p>
 * It contains an <code>execute()</code> method that performs a load operation
 * manipulating the variables stored in the <code>VariableMemory</code>.
 * </p>
 */
public class RestoreOperation implements Operation {
    
     /**
     * 
     * This function restore the state of the <code>VariableMemory</code> stack.
     * 
     */
    @Override
    public void execute() {
        VariableMemory varMem = VariableMemory.getVariableMemory();
        varMem.loadVariableState();
    }

}
