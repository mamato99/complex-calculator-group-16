package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DropOperationTest {

    private Calculator c;

    public DropOperationTest() {
    }

    @Before
    public void setUp() {
        c = new Calculator();
    }

    /**
     * Test of execute method, of class DropOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("drop execute");
        DropOperation instance = new DropOperation(c);

        ComplexNumber c1 = new ComplexNumber(2, 2);
        ComplexNumber c2 = new ComplexNumber(1, 1);

        c.pushNumber(c1);
        c.pushNumber(c2);

        instance.execute();

        assertEquals(c.getStoredNumbers().top(), c1);
        assertEquals(c.getStoredNumbers().len(), 1);

    }

    /**
     * Test of execute method, of class DropOperation.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("drop execute");
        DropOperation instance = new DropOperation(c);

        instance.execute();

    }

}
