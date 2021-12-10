package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "save" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code> method that performs the operation manipulating the <code>NumberMemory</code> 
 * stack of complex numbers.
 * </p>
 */
public class SaveOperation implements Operation {

    /**
     * Saves the state of the variables into an instance of the <code>VariableMemory</code> class.
     */
    @Override
    public void execute() {
        VariableMemory varMem = VariableMemory.getVariableMemory();
        varMem.saveVariableState();
    }

}
