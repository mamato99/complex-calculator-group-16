package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DropOperation implements Operation {

    private NumberMemory storedNumbers;

    public DropOperation(NumberMemory storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    /**
     * <p>
     * This function takes the last stored element and deletes it</p>
     */
    @Override
    public void execute() {
        storedNumbers.pop();
    }
}
