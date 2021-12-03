/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.DivideOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class DivideOperationTest {
    private Calculator c;
    
    public DivideOperationTest() {
    }
    
    @Before
    public void setUp() {
        c = new Calculator();
    }
    
    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("divide execute");
        DivideOperation instance = new DivideOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().pop(), ComplexOperations.division(c1, c2));
        
    }
    
    /**
     * Test of execute method, of class DivideOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("divide execute");
        DivideOperation instance = new DivideOperation(c);
        
        instance.execute();
        
    }
    
}
