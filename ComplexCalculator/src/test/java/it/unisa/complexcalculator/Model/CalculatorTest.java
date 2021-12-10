package it.unisa.complexcalculator.Model;


import it.unisa.complexcalculator.Model.Operation.StackOperations.SqrtOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.SwapOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.InvertSignOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.SubtractOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.OverOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.MultiplyOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.AddOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DropOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DivideOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DupOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.ClearOperation;
import it.unisa.complexcalculator.Model.Operation.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private  ConcreteOperationFactory c;
    
    public CalculatorTest() {
    }
    
    @Before
    public void setUp() {
        c = new ConcreteOperationFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createDupOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDupOperation() {
        System.out.println("createDupOperation");
        String s = "dup"; 
        Operation result = c.parseOperation(s);
        assert(result instanceof DupOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createClearOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateClearOperation() {
        System.out.println("createClearOperation");
        String s = "clear"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof ClearOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createSwapOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSwapOperation() {
        System.out.println("createSwapOperation");
        String s = "swap"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof SwapOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createDropOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDropOperation() {
        System.out.println("createSwapOperation");
        String s = "drop"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof DropOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createOverOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateOverOperation() {
        System.out.println("createOverOperation");
        String s = "over"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof OverOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createAddOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateAddOperation() {
        System.out.println("createAddOperation");
        String s = "+"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof AddOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of createSubtractOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSubtractOperation() {
        System.out.println("createSubtractOperation");
        String s = "-"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof SubtractOperation);
        // TODO review the generated test code and remove the default call to fail.
    }

     /**
     * Test of createMultiplyOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateMultiplyOperation() {
        System.out.println("createMultiplyOperation");
        String s = "*"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof MultiplyOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
  
     /**
     * Test of createDivideOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateDivideOperation() {
        System.out.println("createDivideOperation");
        String s = "/"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof DivideOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
   
    
     /**
     * Test of createSqrtOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateSqrtOperation() {
        System.out.println("createSqrtOperation");
        String s = "sqrt"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof SqrtOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
 
    
     /**
     * Test of createInvertSignOperation method, of class OperationFactory.
     */
    @Test
    public void testCreateInvertSignOperation() {
        System.out.println("createInvertSignOperation");
        String s = "+-"; 
        
        Operation result = c.parseOperation(s);
        assert(result instanceof InvertSignOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
 
     /**
     * Test of createNullOperation method, of class OperationFactory.
     */
    @Test(expected=NumberFormatException.class)
    public void testCreateNullOperation() {
        System.out.println("createNullOperation");
        String s = "any"; 
        
        Operation result = c.parseOperation(s);
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
}

