package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "swap" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code>
 * method that performs the operation manipulating the <code>NumberMemory</code> stack of complex numbers.
 * </p>
 */
public class SwapOperation implements Operation {

    /**
     * Takes the last two numbers saved from the stack and swaps them.
     * <p>
     * Can throw NotEnoughOperandsException.
     * </p>
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();

        storedNumbers.push(c1);
        storedNumbers.push(c2);

    }
}
