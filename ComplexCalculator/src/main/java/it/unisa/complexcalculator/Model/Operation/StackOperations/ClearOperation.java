package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class ClearOperation implements Operation {
   
    /**
     * <p>
     * Takes the list of saved numbers and cleans it</p>
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        while (storedNumbers.len() > 0) {
            storedNumbers.pop();
        }
    }
}
