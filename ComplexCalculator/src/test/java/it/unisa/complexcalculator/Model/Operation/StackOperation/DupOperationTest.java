package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DupOperationTest {

    private Calculator c;

    public DupOperationTest() {
    }

    @Before
    public void setUp() {
        c = new Calculator();
    }

    /**
     * Test of execute method, of class DupOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("dup execute");
        DupOperation instance = new DupOperation(c);

        ComplexNumber c1 = new ComplexNumber(2, 2);

        c.pushNumber(c1);

        instance.execute();

        assertEquals(c.getStoredNumbers().top(), c1);
        assertEquals(c.getStoredNumbers().len(), 2);

    }

    /**
     * Test of execute method, of class DupOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("dup execute");
        DupOperation instance = new DupOperation(c);

        instance.execute();

    }

}
