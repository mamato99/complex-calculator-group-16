package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DupOperationTest {
    
    private NumberMemory storedNumbers;
    private ComplexNumber c;
    private DupOperation instance;
    
    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c = null;
        instance = new DupOperation(storedNumbers);
    }

    /**
     * Test of execute method, of class DupOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("dup");
        storedNumbers.getStack().clear();
        c = new ComplexNumber(2, 2);
        storedNumbers.push(c);
        
        instance.execute();
        
        assertEquals(storedNumbers.top(), c);
        assertEquals(storedNumbers.len(), 2);

    }

    /**
     * Test of execute method, of class DupOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("dup");
        instance.execute();
    }
}
