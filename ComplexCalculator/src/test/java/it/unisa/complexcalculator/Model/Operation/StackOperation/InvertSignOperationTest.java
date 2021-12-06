package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvertSignOperationTest {

    private Calculator c;

    public InvertSignOperationTest() {
    }

    @Before
    public void setUp() {
        c = new Calculator();
    }

    /**
     * Test of execute method, of class InvertSignOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("invert sign execute");
        InvertSignOperation instance = new InvertSignOperation(c);

        ComplexNumber c1 = new ComplexNumber(2, 2);

        c.pushNumber(c1);

        instance.execute();

        assertEquals(c.getStoredNumbers().top(), ComplexOperations.signInversion(c1));
        assertEquals(c.getStoredNumbers().len(), 1);

    }

    /**
     * Test of execute method, of class InvertSignOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("invert sign execute");
        InvertSignOperation instance = new InvertSignOperation(c);

        instance.execute();

    }
}
