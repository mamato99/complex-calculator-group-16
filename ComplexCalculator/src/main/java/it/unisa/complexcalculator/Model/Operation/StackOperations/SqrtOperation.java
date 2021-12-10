package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SqrtOperation extends Operation{
  
    /**
     * <p>
     * This method takes the last number saved on the stack and calculates the square root</p>
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.squareRoot(c1);
        storedNumbers.push(result);
    }
}
