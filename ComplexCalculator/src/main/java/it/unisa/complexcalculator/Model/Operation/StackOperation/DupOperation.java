package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DupOperation implements Operation {

    private final NumberMemory storedNumbers;

    public DupOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    /**
     * <p>
     * This function store a new number on the stack that is a copy of the
     * last</p>
     */
    @Override
    public void execute() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber dup = storedNumbers.top();
        storedNumbers.push(dup);
    }
}