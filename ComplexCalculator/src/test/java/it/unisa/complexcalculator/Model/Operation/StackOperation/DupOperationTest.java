/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.DupOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class DupOperationTest {
    private Calculator c;
    
    public DupOperationTest() {
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
        System.out.println("dup execute");
        DupOperation instance = new DupOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(2,2);
        
        c.pushNumber(c1);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().top(), c1);
        assertEquals(c.getStoredNumbers().len(), 2);
        
    }
    
    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("dup execute");
        DupOperation instance = new DupOperation(c);
        
        instance.execute();
        
    }
    
}
