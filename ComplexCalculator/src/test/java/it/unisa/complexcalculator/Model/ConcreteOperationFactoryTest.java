package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConcreteOperationFactoryTest {
    
    private ConcreteOperationFactory opFac;
    NumberMemory numMem;
    VariableMemory varMem;
    
    @Before
    public void setUp() {
        opFac = new ConcreteOperationFactory();
        numMem = NumberMemory.getNumberMemory();
        numMem.clear();
    }  
    
    /**
     * Test of createDupOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDupOperation() {
        System.out.println("createDupOperation");
        String s = "dup"; 
        Operation result = opFac.createOperation(s);
        assert(result instanceof DupOperation);
    }
    
     /**
     * Test of createClearOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateClearOperation() {
        System.out.println("createClearOperation");
        String s = "clear"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof ClearOperation);
    }
    
     /**
     * Test of createSwapOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSwapOperation() {
        System.out.println("createSwapOperation");
        String s = "swap"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SwapOperation);
        
    }
    
     /**
     * Test of createDropOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDropOperation() {
        System.out.println("createSwapOperation");
        String s = "drop"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof DropOperation);
        
    }
    
     /**
     * Test of createOverOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateOverOperation() {
        System.out.println("createOverOperation");
        String s = "over"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof OverOperation);
        
    }
    
     /**
     * Test of createAddOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateAddOperation() {
        System.out.println("createAddOperation");
        String s = "+"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof AddOperation);
        
    }
    
     /**
     * Test of createSubtractOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSubtractOperation() {
        System.out.println("createSubtractOperation");
        String s = "-"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SubtractOperation);
        
    }

     /**
     * Test of createMultiplyOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateMultiplyOperation() {
        System.out.println("createMultiplyOperation");
        String s = "*"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof MultiplyOperation);
        
    }
  
     /**
     * Test of createDivideOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDivideOperation() {
        System.out.println("createDivideOperation");
        String s = "/"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof DivideOperation);
    }
   
    
     /**
     * Test of createSqrtOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSqrtOperation() {
        System.out.println("createSqrtOperation");
        String s = "sqrt"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SqrtOperation);
    }
 
    
     /**
     * Test of createInvertSignOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateInvertSignOperation() {
        System.out.println("createInvertSignOperation");
        String s = "+-"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof InvertSignOperation);
    }
 
     /**
     * Test of createNullOperation method, of class OperationFactory.
     */
    @Test(expected=NumberFormatException.class)
    public void testCreateNullOperation() {
        System.out.println("createNullOperation");
        String s = "any"; 
        
        opFac.createOperation(s);
    }
    
    /**
     * Test of createCustomOperation method, of class ConcreteOperationFactory.
     */
    @Test
    public void testCreateCustomOperation() {
        System.out.println("createCustomOperation");
        
        CustomOperation result = opFac.createCustomOperation("op1", "1 2 3 + +");
        
        result.execute();
        
        assertEquals(numMem.pop(), new ComplexNumber(6,0));
    }
    
    
}
