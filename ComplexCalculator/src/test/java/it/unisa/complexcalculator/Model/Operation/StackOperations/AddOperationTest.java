package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private AddOperation instance;

    @Before
    public void setUp() {
        storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.clear();
        instance = new AddOperation();
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test
    public void testAddOperationMaxValues() {
        System.out.println("add");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test
    public void testAddOperationMinValues() {
        System.out.println("add");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test
    public void testAddOperationZeroValues() {
        System.out.println("add");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddOperationOutOfBoundExceptionMax() {
        System.out.println("add");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddOperationOutOfBoundExceptionMin() {
        System.out.println("add");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testAddOperationNotEnoughOperandsException() {
        System.out.println("add");
        c1 = new ComplexNumber(1, 1);
        storedNumbers.push(c1);
        instance.execute();
    }

}
