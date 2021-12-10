package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PushOperationTest {

    private NumberMemory stack;
    private ComplexNumber c1, c2;
    private PushOperation instance;

    @Before
    public void setUp() {
        stack = NumberMemory.getNumberMemory();
        stack.clear();
        
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(2, 2);
    }

    /**
     * Test of execute method, of class PushOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("pushOperation");

        instance = new PushOperation(c1);
        instance.execute();

        instance = new PushOperation(c2);
        instance.execute();

        assertEquals(stack.pop(), c2);
        assertEquals(stack.pop(), c1);
    }

}
