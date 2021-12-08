package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class PushOperation extends Operation{
   
    private final ComplexNumber c;
    private final NumberMemory storedNumbers;

    public PushOperation(NumberMemory storedNumbers, ComplexNumber c) {
        this.c = c;
        this.storedNumbers = storedNumbers;
    }
    
    @Override
    public void execute() {
        storedNumbers.push(c);
    }
    
}
