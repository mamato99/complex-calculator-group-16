
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OverOperationTest {
    private Calculator c;
    
    public OverOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class OverOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        OverOperation instance = new OverOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().pop(), c1);
        
    }
    
    /**
     * Test of execute method, of class OverOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("execute");
        OverOperation instance = new OverOperation(c);
        
        instance.execute();
        
    }
    
}
