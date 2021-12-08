package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SwapOperation extends Operation {

    private NumberMemory storedNumbers;

    public SwapOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    /**
     * <p>
     * This method takes the last two numbers saved in the stack and swaps
     * them.</p>
     */
    @Override
    public void execute() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();

        storedNumbers.push(c1);
        storedNumbers.push(c2);

    }
}
