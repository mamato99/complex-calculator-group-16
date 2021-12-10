package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "drop" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code> method that performs the operation manipulating the <code>NumberMemory</code> 
 * stack of complex numbers.
 * </p>
 */
public class DropOperation implements Operation {

    /**
     * 
     * This function takes the last stored element and deletes it
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.pop();
    }
}
