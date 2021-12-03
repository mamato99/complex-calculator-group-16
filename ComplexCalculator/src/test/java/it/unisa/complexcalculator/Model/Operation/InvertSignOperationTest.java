/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.InvertSignOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class InvertSignOperationTest {
    private Calculator c;
    
    public InvertSignOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    /**
     * Test of execute method, of class AddOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("invert sign execute");
        InvertSignOperation instance = new InvertSignOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(2,2);
        
        c.pushNumber(c1);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.signInversion(c1));
        assertEquals(c.getStoredNumbers().len(), 1);
        
    }
    
    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("invert sign execute");
        InvertSignOperation instance = new InvertSignOperation(c);
        
        instance.execute();
        
    }
}
