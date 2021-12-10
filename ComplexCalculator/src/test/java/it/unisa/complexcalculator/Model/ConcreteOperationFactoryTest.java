package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.*;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.AddToVariableOperation;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.StackToVariableOperation;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.SubtractToVariableOperation;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.VariableToStackOperation;
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
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDupOperation() {
        System.out.println("createDupOperation");
        String s = "dup"; 
        Operation result = opFac.createOperation(s);
        assert(result instanceof DupOperation);
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateClearOperation() {
        System.out.println("createClearOperation");
        String s = "clear"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof ClearOperation);
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSwapOperation() {
        System.out.println("createSwapOperation");
        String s = "swap"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SwapOperation);
        
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDropOperation() {
        System.out.println("createSwapOperation");
        String s = "drop"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof DropOperation);
        
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateOverOperation() {
        System.out.println("createOverOperation");
        String s = "over"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof OverOperation);
        
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateAddOperation() {
        System.out.println("createAddOperation");
        String s = "+"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof AddOperation);
        
    }
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSubtractOperation() {
        System.out.println("createSubtractOperation");
        String s = "-"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SubtractOperation);
        
    }

     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateMultiplyOperation() {
        System.out.println("createMultiplyOperation");
        String s = "*"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof MultiplyOperation);
        
    }
  
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDivideOperation() {
        System.out.println("createDivideOperation");
        String s = "/"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof DivideOperation);
    }
   
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSqrtOperation() {
        System.out.println("createSqrtOperation");
        String s = "sqrt"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SqrtOperation);
    }
 
    
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateInvertSignOperation() {
        System.out.println("createInvertSignOperation");
        String s = "+-"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof InvertSignOperation);
    }
 
     /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test(expected=NumberFormatException.class)
    public void testCreateNullOperation() {
        System.out.println("createNullOperation");
        String s = "any"; 
        
        opFac.createOperation(s);
    }
    
    /**
     * Test of createOperation method, of class ConcreteOperationFactory.
     */
    @Test
    public void testCreateCustomOperation() {
        System.out.println("createCustomOperation");
        
        CustomOperation result = opFac.createCustomOperation("op1", "1 2 3 + +");
        
        result.execute();
        
        assertEquals(numMem.pop(), new ComplexNumber(6,0));
    }
    
    /**
     * Test of createOperation method's NumberFormatException, of class ConcreteOperationFactory.
     */
    @Test(expected = NumberFormatException.class)
    public void testCreateCustomOperationNumberFormatException() {
        System.out.println("createCustomOperation");
        
        opFac.createCustomOperation("op1", "any string");
        
    }
    
    /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateAddToVariableOperation() {
        System.out.println("createAddToVariableOperation");
        String s = "+a"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof AddToVariableOperation);
    }
    
    /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateStackToVariableOperation() {
        System.out.println("createStackToVariableOperation");
        String s = ">a"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof StackToVariableOperation);
    }
    
    /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateVariableToStackOperation() {
        System.out.println("createVariableToStackOperation");
        String s = "<a"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof VariableToStackOperation);
    }
    
    /**
     * Test of createOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSubtractToVariableOperation() {
        System.out.println("createSubtractToVariableOperation");
        String s = "-a"; 
        
        Operation result = opFac.createOperation(s);
        assert(result instanceof SubtractToVariableOperation);
    }
    
}
