package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import org.junit.Before;
import org.junit.Test;

public class ClearOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1;
    private ClearOperation instance;

    @Before
    public void setUp() {
        storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.clear();
        instance = new ClearOperation();
        c1 = new ComplexNumber(1, 1);
    }

    /**
     * Test of execute method, of class ClearOperation.
     */
    @Test
    public void testClearOperation() {
        System.out.println("clear");
        instance.execute();
        assert (storedNumbers.len() == 0);
    }
}
