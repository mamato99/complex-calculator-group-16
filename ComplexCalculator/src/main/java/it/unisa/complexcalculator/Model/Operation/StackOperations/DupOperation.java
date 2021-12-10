package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DupOperation extends Operation {
     /**
     * <p>
     * This function store a new number on the stack that is a copy of the
     * last</p>
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber dup = storedNumbers.top();
        storedNumbers.push(dup);
    }
}
