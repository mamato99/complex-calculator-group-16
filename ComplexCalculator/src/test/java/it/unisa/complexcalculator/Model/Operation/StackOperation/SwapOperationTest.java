
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SwapOperationTest {
    private Calculator c;
    
    public SwapOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    /**
     * Test of execute method, of class SwapOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("swap execute");
        SwapOperation instance = new SwapOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(2,2);
        
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        
        instance.execute();
        
        assertEquals(c1, c.getStoredNumbers().pop());
        assertEquals(c2, c.getStoredNumbers().pop());
        
    }
    
    /**
     * Test of execute method, of class SwapOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("swap execute");
        SwapOperation instance = new SwapOperation(c);
        
        instance.execute();
        
    }
    
}
