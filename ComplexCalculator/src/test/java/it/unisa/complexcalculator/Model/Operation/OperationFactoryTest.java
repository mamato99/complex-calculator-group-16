/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class OperationFactoryTest {
       private  Calculator c;
    public OperationFactoryTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parseDupOperation method, of class OperationFactory.
     */
    @Test
    public void testParseDupOperation() {
        System.out.println("parseDupOperation");
        String s = "dup"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof DupOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseClearOperation method, of class OperationFactory.
     */
    @Test
    public void testParseClearOperation() {
        System.out.println("parseClearOperation");
        String s = "clear"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof ClearOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseSwapOperation method, of class OperationFactory.
     */
    @Test
    public void testParseSwapOperation() {
        System.out.println("parseSwapOperation");
        String s = "swap"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof SwapOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseDropOperation method, of class OperationFactory.
     */
    @Test
    public void testParseDropOperation() {
        System.out.println("parseSwapOperation");
        String s = "drop"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof DropOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseOverOperation method, of class OperationFactory.
     */
    @Test
    public void testParseOverOperation() {
        System.out.println("parseOverOperation");
        String s = "over"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof OverOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseAddOperation method, of class OperationFactory.
     */
    @Test
    public void testParseAddOperation() {
        System.out.println("parseAddOperation");
        String s = "+"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof AddOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     /**
     * Test of parseSubtractOperation method, of class OperationFactory.
     */
    @Test
    public void testParseSubtractOperation() {
        System.out.println("parseSubtractOperation");
        String s = "-"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof SubtractOperation);
        // TODO review the generated test code and remove the default call to fail.
    }

     /**
     * Test of parseMultiplyOperation method, of class OperationFactory.
     */
    @Test
    public void testParseMultiplyOperation() {
        System.out.println("parseMultiplyOperation");
        String s = "*"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof MultiplyOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
  
     /**
     * Test of parseDivideOperation method, of class OperationFactory.
     */
    @Test
    public void testParseDivideOperation() {
        System.out.println("parseDivideOperation");
        String s = "/"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof DivideOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
   
    
     /**
     * Test of parseSqrtOperation method, of class OperationFactory.
     */
    @Test
    public void testParseSqrtOperation() {
        System.out.println("parseSqrtOperation");
        String s = "sqrt"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof SqrtOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
 
    
     /**
     * Test of parseInvertSignOperation method, of class OperationFactory.
     */
    @Test
    public void testParseInvertSignOperation() {
        System.out.println("parseInvertSignOperation");
        String s = "+-"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assert(result instanceof InvertSignOperation);
        // TODO review the generated test code and remove the default call to fail.
    }
 
     /**
     * Test of parseNullOperation method, of class OperationFactory.
     */
    @Test
    public void testParseNullOperation() {
        System.out.println("parseNullOperation");
        String s = "any"; 
        Operation result = OperationFactory.parseOperation(s, c); 
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }  
}
