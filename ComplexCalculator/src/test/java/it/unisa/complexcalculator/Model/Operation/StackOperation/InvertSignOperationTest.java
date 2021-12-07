package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvertSignOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c;
    private InvertSignOperation instance;
    
    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c = null;
        
        instance = new InvertSignOperation(storedNumbers);
    }

    /**
     * Test of execute method, of class InvertSignOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("invert sign");
        storedNumbers.getStack().clear();
        c = new ComplexNumber(2, 2);
        storedNumbers.push(c);
        
        instance.execute();
        ComplexNumber expResult = ComplexOperations.signInversion(c);

        assertEquals(storedNumbers.top(), expResult);
        assertEquals(storedNumbers.len(), 1);

    }

 
    /**
     * Test of execute method, of class InvertSignOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("invert sign");
        instance.execute();
    }
}
