
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SubtractOperationTest {
    private Calculator c;
    
    public SubtractOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class SubtractOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("subtract execute test");
        SubtractOperation instance = new SubtractOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().pop(), ComplexOperations.difference(c1, c2));
        
    }
    
    
    /**
     * Test of execute method, of class SubtractOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("execute");
        SubtractOperation instance = new SubtractOperation(c);
        
        instance.execute();
        
    }
    
}
