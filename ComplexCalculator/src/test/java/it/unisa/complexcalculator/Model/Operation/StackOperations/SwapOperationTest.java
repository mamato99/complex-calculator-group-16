package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Operation.StackOperations.SwapOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwapOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1, c2;
    private SwapOperation instance;

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1 = null;
        c2 = null;
        instance = new SwapOperation(storedNumbers);
    }

    /**
     * Test of execute method, of class SwapOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("swap execute");
        SwapOperation instance = new SwapOperation(storedNumbers);

        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 2);

        storedNumbers.push(c1);
        storedNumbers.push(c2);

        instance.execute();

        assertEquals(c1, storedNumbers.pop());
        assertEquals(c2, storedNumbers.pop());

    }

    /**
     * Test of execute method, of class SwapOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("swap execute");
        SwapOperation instance = new SwapOperation(storedNumbers);

        instance.execute();

    }

    /**
     * Test of swap method, of class SwapOperation.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(-1, -1);

        ComplexNumber[] expResult = {c1, c2};
        ComplexNumber[] result;
        result = new ComplexNumber[2];

        storedNumbers.push(c1);
        storedNumbers.push(c2);

        instance.execute();

        result[0] = storedNumbers.pop();
        result[1] = storedNumbers.pop();

        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    /**
     * Test of swap method, of class SwapOperation.
     */
    @Test(expected = Exception.class)
    public void testSwapException() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);

        storedNumbers.push(c1);

        instance.execute();
    }

    /**
     * Test of swap method, of class SwapOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSwapNotEnoughOperandsException() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);

        storedNumbers.push(c1);

        instance.execute();
    }

}
