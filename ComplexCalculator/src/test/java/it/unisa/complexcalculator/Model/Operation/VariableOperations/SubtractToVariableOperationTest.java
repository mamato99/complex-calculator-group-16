package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Exception.OutOfBoundException;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SubtractToVariableOperationTest {

    private SubtractToVariableOperation instance;
    private NumberMemory stack;
    private VariableMemory varMem;
    private ComplexNumber cmpx;

    @Before
    public void setUp() {
        instance = new SubtractToVariableOperation('a');

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
     * Test of execute method, of class SubtractToVariableOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("subtractToVariable");
        
        cmpx = new ComplexNumber(1, 1);
        
        stack.push(cmpx); 
        ComplexNumber expResult = ComplexOperations.difference(varMem.getVariable('a'), cmpx);
         
        instance.execute();
        
        assertEquals(expResult, varMem.getVariable('a'));
    }
    
    /**
     * Test of execute method's EmptyStackException, of class SubtractToVariableOperation.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteEmptyStackException() {
        System.out.println("subtractToVariable");
         
        instance.execute();
    }
    
    /**
     * Test of execute method's OutOfBoundException, of class SubtractToVariableOperation.
     */
    @Test(expected = OutOfBoundException.class)
    public void testExecuteOutOfBoundException() {
        System.out.println("execute SubtractToVariable");
        
        cmpx = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        
        stack.push(cmpx);
        
        varMem.updateVariable('a', new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE));
        
        instance.execute();
    }
    
    

}
