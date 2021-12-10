package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 * This class represent the "push" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code>
 * method that performs the operation manipulating the <code>NumberMemory</code> stack of complex numbers and has
 * an istance of a <code>ComplexNumber</code> that represent the complex number to be inserted.
 * </p>
 */
public class PushOperation implements Operation{
   
    private final ComplexNumber c;
    
    /**
     * The <code>PushOperation</code> constructor.
     * @param c the complex number which will be stored.
    */
    public PushOperation(ComplexNumber c) {
        this.c = c;
    }
    
    /**
     * Stores a complex number in the calculator number memory pushing it at the top of the stack of complex numbers.
     */
    @Override
    public void execute() {
        NumberMemory storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.push(c);
    }
    
}
