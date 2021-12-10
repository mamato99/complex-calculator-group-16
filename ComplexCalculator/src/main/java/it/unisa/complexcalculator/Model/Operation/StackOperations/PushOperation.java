package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class PushOperation implements Operation{
   
    private final ComplexNumber c;

    public PushOperation(ComplexNumber c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.push(c);
    }
    
}
