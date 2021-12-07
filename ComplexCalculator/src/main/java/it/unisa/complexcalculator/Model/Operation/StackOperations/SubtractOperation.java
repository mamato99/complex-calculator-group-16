package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SubtractOperation implements Operation{
    
    private final NumberMemory storedNumbers;

    public SubtractOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }
    
    /**
     * <p>
     * This method takes the last two numbers saved on the stack and subtracts them together </p>
     */
    @Override
    public void execute() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.difference(c1, c2);
        storedNumbers.push(result);
    }
}
