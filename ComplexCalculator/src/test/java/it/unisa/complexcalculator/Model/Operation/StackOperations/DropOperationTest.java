package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

public class DropOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1;
    private DropOperation instance;

    @Before
    public void setUp() {
        storedNumbers = NumberMemory.getNumberMemory();
        storedNumbers.clear();
        instance = new DropOperation();
        c1 = null;
    }

    /**
     * Test of execute method, of class DropOperation.
     */
    @Test(expected = EmptyStackException.class)
    public void testDropOperationEmptyStackException() {
        System.out.println("drop");
        instance.execute();
    }

    /**
     * Test of execute method, of class DropOperation.
     */
    @Test
    public void testDropOperation() {
        System.out.println("drop");
        c1 = new ComplexNumber(1, 1);
        storedNumbers.push(c1);
        instance.execute();
        assert (storedNumbers.len() == 0);
    }

}
