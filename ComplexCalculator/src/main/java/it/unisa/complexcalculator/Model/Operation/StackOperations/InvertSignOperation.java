package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class InvertSignOperation extends Operation{
    private final NumberMemory storedNumbers;

    public InvertSignOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }
    
    /**
     * <p>
     * This method takes the last number saved on the stack and reverses its sign </p>
     */
    @Override
    public void execute() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.signInversion(c1);
        storedNumbers.push(result);
    }
}
