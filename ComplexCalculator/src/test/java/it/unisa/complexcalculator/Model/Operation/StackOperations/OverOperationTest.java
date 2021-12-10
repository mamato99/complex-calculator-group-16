
package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class OverOperationTest {
    private NumberMemory stack;
    private ComplexNumber c1, c2;
    private OverOperation instance;
    
    @Before
    public void setUp() {
        stack = NumberMemory.getNumberMemory();
        stack.clear();
        
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(2, 2);
        
        instance = new OverOperation();
    }
    
    /**
     * Test of execute method, of class OverOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("over");
        
        stack.push(c1);
        stack.push(c2);
        
        instance.execute();
        
        assertEquals(stack.top(), c1);
        assertEquals(stack.len(), 3);
    }
    
    /**
     * Test of execute method's NotEnoughOperandsException, of class OverOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("over");
        
        stack.push(c1);
        
        instance.execute();
    }
    
     /**
     * Test of execute method's NotEnoughOperandsException, of class OverOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeptionNoOperands() {
        System.out.println("over");
        
        stack.push(c1);
        
        instance.execute();
    }
    
}
