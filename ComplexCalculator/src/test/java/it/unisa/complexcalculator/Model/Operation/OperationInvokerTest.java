package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperationInvokerTest {

    private ConcreteOperationFactory opFac;
    private NumberMemory numbers;
    private VariableMemory variables;
    private Character var;


    @Before
    public void setUp() {
        opFac = new ConcreteOperationFactory();
        numbers = NumberMemory.getNumberMemory();
        numbers.clear();
        
        variables = VariableMemory.getVariableMemory();
        for(char c = 'a'; c <= 'z'; c++){
            variables.updateVariable(c, new ComplexNumber(0,0));
        }
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        
        CustomOperation op = opFac.createCustomOperation("op1", "3 3 >a >b");
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op);
        
        assertEquals(numbers.len(), 0);
                
        
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteWithRestore() {
        System.out.println("execute with restore");
        
        var = 'a';
        
        numbers.push(new ComplexNumber(5,5));
        
        variables.updateVariable('a', new ComplexNumber(8,8));
        
        CustomOperation op = opFac.createCustomOperation("op1", "8+7i >a >b >c");
        OperationInvoker instance = new OperationInvoker();
        
        try{
            instance.execute(op);
        } catch(EmptyStackException ex){
            assertEquals(numbers.pop(), new ComplexNumber(5,5));
            assertEquals(variables.getVariable(var), new ComplexNumber(8,8));
        }
        
    }

    
}
