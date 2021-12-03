/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.DropOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class DropOperationTest {
    private Calculator c;
    
    public DropOperationTest() {
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
        System.out.println("drop execute");
        DropOperation instance = new DropOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(2,2);
        ComplexNumber c2 = new ComplexNumber(1,1);
        
        c.pushNumber(c1);
        c.pushNumber(c2);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().top(), c1);
        assertEquals(c.getStoredNumbers().len(), 1);
        
    }
    
    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("drop execute");
        DropOperation instance = new DropOperation(c);
        
        instance.execute();
        
    }
    
}
