package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class DropOperation extends Operation {

    /**
     * <p>
     * This function takes the last stored element and deletes it</p>
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.pop();
    }
}
