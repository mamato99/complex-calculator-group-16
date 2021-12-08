package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class ClearOperation extends Operation {

    private final NumberMemory storedNumbers;

    public ClearOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    /**
     * <p>
     * This function takes the list of saved numbers and empties it</p>
     */
    @Override
    public void execute() {
        while (storedNumbers.len() > 0) {
            storedNumbers.pop();
        }
    }
}
