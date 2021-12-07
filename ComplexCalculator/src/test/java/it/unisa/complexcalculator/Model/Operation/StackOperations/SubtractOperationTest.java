package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Operation.StackOperations.SubtractOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubtractOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private SubtractOperation instance;

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1 = null;
        c2 = null;
        instance = new SubtractOperation(storedNumbers);
    }

    /**
     * Test of execute method, of class SubtractOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("subtract");

        SubtractOperation instance = new SubtractOperation(storedNumbers);

        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(1, 1);

        storedNumbers.push(c1);
        storedNumbers.push(c2);

        instance.execute();

        assertEquals(storedNumbers.pop(), ComplexOperations.difference(c1, c2));

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
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
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
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
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
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMax() {
        System.out.println("subtract");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());;
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMin() {
        System.out.println("subtract");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of subtract method, of class SubtractOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSubtractNotEnoughOperandsException() {
        System.out.println("subtract");
        c1 = new ComplexNumber(1, 1);
        storedNumbers.push(c1);
        instance.execute();
    }

}
