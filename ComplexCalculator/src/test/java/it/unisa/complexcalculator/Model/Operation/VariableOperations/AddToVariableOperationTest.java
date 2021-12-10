
package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import java.util.EmptyStackException;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class AddToVariableOperationTest { 
    private AddToVariableOperation instance;
    private NumberMemory stack;
    private VariableMemory varMem;
    private ComplexNumber cmpx;
    private Character c;

    @Before
    public void setUp() {
        c = 'a';
        
        instance = new AddToVariableOperation(c);

        stack = NumberMemory.getNumberMemory();
        stack.clear();

        varMem = VariableMemory.getVariableMemory();
        for(char c = 'a'; c <= 'z'; c++){
            varMem.updateVariable(c, new ComplexNumber(0,0));
        }
        cmpx = new ComplexNumber(1,1);
    }

    /**
     * Test of execute method, of class AddToVariableOperation.
     */
    @Test
    public void testExecute() {
        stack.push(cmpx);
        stack.push(cmpx);
        
        instance.execute();
        instance.execute();
        
        assertEquals(varMem.getVariable(c), new ComplexNumber(2,2));
        
    }
    /**
     * Test of execute method, of class AddToVariableOperation.
     */
    @Test(expected=EmptyStackException.class)
    public void testExecuteException() {
        instance.execute();        
    }
    
}
