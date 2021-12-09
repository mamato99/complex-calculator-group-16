package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DropOperation extends Operation {

    private NumberMemory storedNumbers;

    public DropOperation() {
        this.storedNumbers = NumberMemory.getNumberMemory();
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
