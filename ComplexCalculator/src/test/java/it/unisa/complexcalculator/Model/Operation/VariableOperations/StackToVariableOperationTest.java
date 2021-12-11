package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackToVariableOperationTest {
    
    private StackToVariableOperation instance;
    private NumberMemory stack;
    private VariableMemory varMem;
    private ComplexNumber cmpx;

    @Before
    public void setUp() {
        instance = new StackToVariableOperation('a');

        cmpx = new ComplexNumber(1,1);
        
        stack = NumberMemory.getNumberMemory();
        stack.clear();

        varMem = VariableMemory.getVariableMemory();
        
        for(char c = 'a'; c < 'z'; c++) {
            varMem.updateVariable(c, new ComplexNumber(0,0));
        }
    }

    @After
    public void tearDown() {
        stack.clear();
        for (char c = 'a'; c < 'z'; c++) {
            varMem.addVariable(new Variable(c, new ComplexNumber(0, 0)));
        }
    }
    
    /**
     * Test of execute method, of class StackToVariableOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("stackToVariable");
        
        stack.push(cmpx);
        assertEquals(stack.len(), 1);
        
        instance.execute();
        
        assertEquals(stack.len(), 0);
        assertEquals(varMem.getVariable('a'), cmpx);
    }
    
     /**
     * Test of execute method, of class StackToVariableOperation.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteEmptyStackException() {
        System.out.println("stackToVariable");
        
        instance.execute();
        
    }
}
