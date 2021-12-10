package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "add" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code> method that performs the operation manipulating the <code>NumberMemory</code> 
 * stack of complex numbers.
 * </p>
 */
public class AddOperation implements Operation{
 
     /**
     * Takes the two last stored complex numbers from the calculator number memory and 
     * push the sum of them to the top of the stack.
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
        ComplexNumber result = ComplexOperations.add(c1, c2);
        storedNumbers.push(result);
    }
    
}
