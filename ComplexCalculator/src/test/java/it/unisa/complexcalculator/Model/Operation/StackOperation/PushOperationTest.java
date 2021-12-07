
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class PushOperationTest {
    private NumberMemory storedNumbers;
    private ComplexNumber c1,c2;
    private PushOperation instance;

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1=null;
        c2=null;
    }

    /**
     * Test of execute method, of class PushOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("pushOperation");
         
        c1 = new ComplexNumber(1, 1);
        
        instance = new PushOperation(storedNumbers, c1);
        
        instance.execute();
        
        c2 = new ComplexNumber(2, 2);

        instance = new PushOperation(storedNumbers, c2);
        
        instance.execute();

        assertEquals(storedNumbers.pop(), c2);
        assertEquals(storedNumbers.pop(), c1);

    }
}
