package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubtractOperationTest {

    private NumberMemory stack;
    private ComplexNumber c1, c2;
    private SubtractOperation instance;

    @Before
    public void setUp() {
        stack = NumberMemory.getNumberMemory();
        c1 = null;
        c2 = null;
        instance = new SubtractOperation();
    }

    /**
     * Test of execute method, of class SubtractOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("subtract");

        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(1, 1);
        
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);

        stack.push(c1);
        stack.push(c2);

        instance.execute();

        assertEquals(stack.pop(), expResult);

    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test
    public void testSubtractMaxValues() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        
        stack.push(c2);
        stack.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, stack.pop());
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test
    public void testSubtractMinValues() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
                
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        
        stack.push(c2);
        stack.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, stack.pop());
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test
    public void testSubtractZeroValues() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        
        stack.push(c2);
        stack.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, stack.pop());
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMax() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        
        stack.push(c2);
        stack.push(c1);
        
        instance.execute();
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMin() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        
        stack.push(c2);
        stack.push(c1);
        
        instance.execute();
    }

    /**
     * Test of subtract method's NotEnoughOperandsException, of class SubtractOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSubtractNotEnoughOperandsException() {
        System.out.println("subtract");
        
        c1 = new ComplexNumber(1, 1);
        
        stack.push(c1);
        
        instance.execute();
    }
    
    /**
     * Test of subtract method's NotEnoughOperandsException, of class SubtractOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSubtractNotEnoughOperandsExceptionNoOperands() {
        System.out.println("subtract");
        
        instance.execute();
    }

}
