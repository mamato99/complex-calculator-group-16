package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwapOperationTest {

    private NumberMemory stack;
    private ComplexNumber c1, c2;
    private SwapOperation instance;

    @Before
    public void setUp() {
        stack = NumberMemory.getNumberMemory();
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(2, 2);
        instance = new SwapOperation();
    }

    /**
     * Test of execute method, of class SwapOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("swap");

        stack.push(c1);
        stack.push(c2);

        instance.execute();

        assertEquals(c1, stack.pop());
        assertEquals(c2, stack.pop());
    }

    /**
     * Test of execute method's NotEnoughOperandsException, of class SwapOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeptionNoOperands() {
        System.out.println("swap");

        instance.execute();
    }

    /**
     * Test of swap method, of class SwapOperation.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");

        ComplexNumber[] expResult = {c1, c2};
        ComplexNumber[] result = new ComplexNumber[2];

        stack.push(c1);
        stack.push(c2);

        instance.execute();

        result[0] = stack.pop();
        result[1] = stack.pop();

        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    /**
     * Test of swap method's NotEnoughOperandsException, of class SwapOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSwapNotEnoughOperandsExeption() {
        System.out.println("swap");

        instance.execute();
    }

}
