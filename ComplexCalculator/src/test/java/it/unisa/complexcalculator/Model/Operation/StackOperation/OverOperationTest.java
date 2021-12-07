
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OverOperationTest {
    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private OverOperation instance;
    
    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1 = new ComplexNumber(2, 2);
        c2 = new ComplexNumber(3, 4);
        instance = new OverOperation(storedNumbers);
    }
    
    /**
     * Test of execute method, of class OverOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("over");
        storedNumbers.getStack().clear();
        c1 = new ComplexNumber(2, 2);
        c2 = new ComplexNumber(3, 4);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        
        instance.execute();
        assertEquals(storedNumbers.top(), c1);
        assertEquals(storedNumbers.len(), 3);
    }
    
    /**
     * Test of execute method, of class OverOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("over");
        instance.execute();
    }
    
}
