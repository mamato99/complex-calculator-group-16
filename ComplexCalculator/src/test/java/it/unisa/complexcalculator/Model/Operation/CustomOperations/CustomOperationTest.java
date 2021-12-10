package it.unisa.complexcalculator.Model.Operation.CustomOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Memory.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CustomOperationTest {
    
    private ConcreteOperationFactory fact;
    private CustomOperation op1;
    private NumberMemory numMem;
    private VariableMemory varMem;
    
    @Before
    public void setUp() {
        numMem = NumberMemory.getNumberMemory();
        varMem = VariableMemory.getVariableMemory();
        fact = new ConcreteOperationFactory();
    }

    /**
     * Test of execute method, of class CustomOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        op1 = fact.createCustomOperation("op1", "2 3 +");
        
        op1.execute();
        
        assertEquals(numMem.pop(), new ComplexNumber(5,0));
        
        op1 = fact.createCustomOperation("op1", "2 3 >a +a");
        
        op1.execute();
        
        assertEquals(varMem.getVariable('a'), new ComplexNumber(5,0));
    }
    
}
