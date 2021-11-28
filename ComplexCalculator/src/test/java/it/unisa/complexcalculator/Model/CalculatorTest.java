/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class CalculatorTest {
    private Calculator calc;
    private ComplexNumber c1,c2;
    
    public CalculatorTest() {
    }
    
    @Before
    public void setUp() {
        calc = new Calculator();
        c1=null;
        c2=null;
    }

    /**
     * Test of getStoredNumbers method, of class Calculator.
     */
    @Test
    public void testGetStoredNumbers() {
        System.out.println("getStoredNumbers");
        
        NumberMemory result = calc.getStoredNumbers();
        
        assertNotNull(result);
       
    }
    
    
    //-----------------------pushNumber_double_double - Boundary analysis-----------------------------------------
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberDoubleDoubleMinValues() {
        System.out.println("pushNumber - Min values");
        
        // Test 1 - Min Values for real and img part
        double real = -Double.MAX_VALUE;
        double img = -Double.MAX_VALUE;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberDoubleDoubleMaxValues() {
        System.out.println("pushNumber - Max values");
        
        // Test 2 - Max Values for real and img part
        double real = Double.MAX_VALUE;
        double img = Double.MAX_VALUE;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberDoubleDoubleZeroValues() {
        System.out.println("pushNumber - Zero values");
        
        // Test 3 - Zero values for real and img part
        double real = 0.0;
        double img = 0.0;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }

   
    //-----------------------pushNumber_String_String - Whitebox testing (path coverage)-----------------------------------------
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberStringStringZeroZero() {
        System.out.println("pushNumber");
        String re = "+";
        String im = "+";
        
        calc.pushNumber(re, im);
        ComplexNumber expResult = new ComplexNumber(0, 0);
        
        ComplexNumber result = calc.getStoredNumbers().pop();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberStringStringNonZeroNonZero() {
        System.out.println("pushNumber");
        String re = "+1.0";
        String im = "+1.0";
        
        calc.pushNumber(re, im);
        ComplexNumber expResult = new ComplexNumber(1, 1);
        
        ComplexNumber result = calc.getStoredNumbers().pop();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberStringStringZeroNonZero() {
        System.out.println("pushNumber");
        String re = "+0.0";
        String im = "+1.0";
        
        calc.pushNumber(re, im);
        ComplexNumber expResult = new ComplexNumber(0, 1);
        
        ComplexNumber result = calc.getStoredNumbers().pop();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberStringStringNonZeroZero() {
        System.out.println("pushNumber");
        String re = "+1.0";
        String im = "+0.0";
        
        calc.pushNumber(re, im);
        ComplexNumber expResult = new ComplexNumber(1, 0);
        
        ComplexNumber result = calc.getStoredNumbers().pop();
        
        assertEquals(expResult, result);
    }
    //-----------------------add-----------------------------------------
    
    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Calculator instance = new Calculator();
        instance.add();
    }
    
    
    //-----------------------subtract-----------------------------------------
    
    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Calculator instance = new Calculator();
        instance.subtract();
    }
    
    
    
    //-----------------------subtract-----------------------------------------
    
    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Calculator instance = new Calculator();
        instance.divide();
    }
    
    
    
    //-----------------------multiply-----------------------------------------
    
    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Calculator instance = new Calculator();
        instance.multiply();
    }
    
    
    
    //-----------------------invertSign-----------------------------------------
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        Calculator instance = new Calculator();
        instance.invertSign();
    }
    
    
    
    //-----------------------squareRoot-----------------------------------------
    
    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRoot() {
        System.out.println("squareRoot");
        Calculator instance = new Calculator();
        instance.squareRoot();
    }
    
}
