/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.AddOperation;
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
public class AddOperationTest {
    private Calculator c;
    
    public AddOperationTest() {
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
        System.out.println("add execute");
        AddOperation instance = new AddOperation(c);
        
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(1,1);
        
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        
        instance.execute();
        
        assertEquals(c.getStoredNumbers().pop(), ComplexOperations.add(c1, c2));
        
    }
    
    /**
     * Test of execute method, of class AddOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("add execute");
        AddOperation instance = new AddOperation(c);
        
        instance.execute();
        
    }
    
}
