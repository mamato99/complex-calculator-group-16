package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Operation.StackOperations.ClearOperation;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;

public class ClearOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1;
    private ClearOperation instance;

    public ClearOperationTest() {
    }

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        instance = new ClearOperation(storedNumbers);
        c1 = null;;
    }

    /**
     * Test of execute method, of class ClearOperation.
     */
    @Test
    public void testClearOperation() {
        System.out.println("clear");
        c1 = new ComplexNumber(1, 1);
        storedNumbers.push(c1);
        instance.execute();
        assert (storedNumbers.len() == 0);
    }
}
