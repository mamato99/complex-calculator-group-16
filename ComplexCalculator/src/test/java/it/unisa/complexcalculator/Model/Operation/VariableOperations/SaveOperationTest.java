package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaveOperationTest {
    
    private SaveOperation instance;
    private NumberMemory stack;
    private VariableMemory varMem;
    private ComplexNumber cmpx;
    
    @Before
    public void setUp() {
        instance = new SaveOperation();

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
     * Test of execute method, of class SaveOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        
        cmpx = new ComplexNumber(1, 1);
        
        instance.execute();
        
        varMem.updateVariable('a', cmpx);
        
        varMem.loadVariableState();
        
        assertNotEquals(varMem.getVariable('a'), cmpx);
    }
    
}
