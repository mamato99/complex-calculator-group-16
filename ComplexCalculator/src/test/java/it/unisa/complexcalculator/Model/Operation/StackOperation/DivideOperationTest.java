package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivideOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private DivideOperation instance;

    public DivideOperationTest() {
    }

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        instance = new DivideOperation(storedNumbers);
        c1 = null;
        c2 = null;
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test
    public void testDivideOperationtMaxValues() {
        System.out.println("divide");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1, 0);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test
    public void testDivideOperationMinValues() {
        System.out.println("divide");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1, 0);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test
    public void testDivideOperationWithDividendZero() {
        System.out.println("divide");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        storedNumbers.push(c2);
        storedNumbers.push(c1);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test(expected = ArithmeticException.class)
    public void testDivideOperationForZero() {
        System.out.println("divide");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDivideOperationOutOfBoundExceptionMax() {
        System.out.println("divide");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0 / Double.MAX_VALUE, 1.0 / Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDivideOperationOutOfBoundExceptionMin() {
        System.out.println("divide");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0 / Double.MAX_VALUE, 1.0 / Double.MAX_VALUE);
        storedNumbers.push(c1);
        storedNumbers.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testDivideOperationNotEnoughOperandsException() {
        System.out.println("divide");
        c1 = new ComplexNumber(1, 1);
        storedNumbers.push(c1);
        instance.execute();
    }

}
