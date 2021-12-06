package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import org.junit.Before;
import org.junit.Test;

public class ClearOperationTest {

    private Calculator c;

    public ClearOperationTest() {
    }

    @Before
    public void setUp() {
        c = new Calculator();
    }

    /**
     * Test of execute method, of class ClearOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("clear execute");
        ClearOperation instance = new ClearOperation(c);

        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);

        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);

        instance.execute();

        assert (c.getStoredNumbers().len() == 0);

    }

}
