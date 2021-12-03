/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.SqrtOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SqrtOperationTest {
    private Calculator c;
    
    public SqrtOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class SqrtOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        SqrtOperation instance = new SqrtOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        
        c.getStoredNumbers().push(c1);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().pop(), ComplexOperations.squareRoot(c1));
        
    }
    
    /**
     * Test of execute method, of class SqrtOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("execute");
        SqrtOperation instance = new SqrtOperation(c);
        
        instance.execute();
        
    }
}
