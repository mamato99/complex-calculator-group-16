package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplyOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private MultiplyOperation instance;

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1 = null;
        c2 = null;
        instance = new MultiplyOperation(storedNumbers);
    }


    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("multiply");
        c1 = new ComplexNumber(2, 2);
        c2 = new ComplexNumber(2, 3);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        assertEquals(storedNumbers.top(), expResult);
        assertEquals(storedNumbers.len(), 1);

    }

    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test
    public void testMultiplyMaxValues() {
        System.out.println("multiply");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0, 0);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        
        assertEquals(storedNumbers.top(), expResult);
    }
    
    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test
    public void testMultiplyMinValues() {
        System.out.println("multiply");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0, 0);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        
        assertEquals(storedNumbers.top(), expResult);
    }
    
    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test
    public void testMultiplyZeroValues() {
        System.out.println("multiply");
        
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        
        assertEquals(storedNumbers.top(), expResult);
    }
    
    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMultiplyOutOfBoundExceptionMax() {
        System.out.println("multiply");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        
        assertEquals(storedNumbers.top(), expResult);
    }
    
    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMultiplyOutOfBoundExceptionMin() {
        System.out.println("multiply");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        
        assertEquals(storedNumbers.top(), expResult);
    }
    
    /**
     * Test of execute method, of class MultiplyOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("multiply");
        instance.execute();
    }

}
