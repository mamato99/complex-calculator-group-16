package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "subtract" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code>
 * method that performs the operation manipulating the <code>NumberMemory</code> stack of complex numbers.
 * </p>
 */
public class SubtractOperation implements Operation{
 
    /**
     * Takes the last two numbers saved from the stack and subtracts them together, then pushes
     * the result in the stack of stored complex numbers.
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
        ComplexNumber result = ComplexOperations.difference(c1, c2);
        storedNumbers.push(result);
    }
}
