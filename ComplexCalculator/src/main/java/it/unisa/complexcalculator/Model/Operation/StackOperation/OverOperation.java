package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class OverOperation implements Operation {

    private final NumberMemory storedNumbers;

    public OverOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    /**
     * <p>
     * This function takes the second last stored element and push it to the top
     * of the stack</p>
     */
    @Override
    public void execute() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber over = storedNumbers.top();

        storedNumbers.push(c1);
        storedNumbers.push(over);
    }
}
