/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Exception.OutOfBoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class CalculatorTest {

    private Calculator calc;
    private ComplexNumber c1, c2;

    public CalculatorTest() {
    }

    @Before
    public void setUp() {
        calc = new Calculator();
        c1 = null;
        c2 = null;
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

    //-----------------------pushNumber_double_double-----------------------------------------
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumber_double_doubleMinValues() {
        System.out.println("pushNumber - Min values");

        // Test 1 - Min Values for real and img part
        double real = -Double.MAX_VALUE;
        double img = -Double.MAX_VALUE;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real, img), calc.getStoredNumbers().pop());

    }

    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumber_double_doubleMaxValues() {
        System.out.println("pushNumber - Max values");

        // Test 2 - Max Values for real and img part
        double real = Double.MAX_VALUE;
        double img = Double.MAX_VALUE;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real, img), calc.getStoredNumbers().pop());

    }

    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumber_double_doubleZeroValues() {
        System.out.println("pushNumber - Zero values");

        // Test 3 - Zero values for real and img part
        double real = 0.0;
        double img = 0.0;
        calc.pushNumber(real, img);
        assertEquals(new ComplexNumber(real, img), calc.getStoredNumbers().pop());

    }

    //-----------------------pushNumber_String_String-----------------------------------------
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumber_String_String() {
        System.out.println("pushNumber");
        String re = "";
        String im = "";
        Calculator instance = new Calculator();
        instance.pushNumber(re, im);
    }

    //-----------------------add-----------------------------------------
    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAddMaxValues() {
        System.out.println("add");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.add();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAddMinValues() {
        System.out.println("add");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.add();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAddZeroValues() {
        System.out.println("add");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.add(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.add();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddOutOfBoundExceptionMax() {
        System.out.println("add");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.add();
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddOutOfBoundExceptionMin() {
        System.out.println("add");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.add();
    }

    //-----------------------subtract-----------------------------------------
    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtractMaxValues() {
        System.out.println("Subtract");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        calc.getStoredNumbers().push(c2);
        calc.getStoredNumbers().push(c1);
        calc.subtract();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtractMinValues() {
        System.out.println("Subtract");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        calc.getStoredNumbers().push(c2);
        calc.getStoredNumbers().push(c1);
        calc.subtract();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtractZeroValues() {
        System.out.println("Subtract");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.difference(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.subtract();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMax() {
        System.out.println("Subtract");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.subtract();
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testSubtractOutOfBoundExceptionMin() {
        System.out.println("Subtract");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.subtract();
    }

    //-----------------------divide-----------------------------------------
    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDividetMaxValues() {
        System.out.println("divide");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1, 0);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        calc.getStoredNumbers().push(c2);
        calc.getStoredNumbers().push(c1);
        calc.divide();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivideMinValues() {
        System.out.println("divide");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1, 0);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        calc.getStoredNumbers().push(c2);
        calc.getStoredNumbers().push(c1);
        calc.divide();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivideWithDividendZero() {
        System.out.println("divide");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        calc.getStoredNumbers().push(c2);
        calc.getStoredNumbers().push(c1);
        calc.divide();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test(expected = ArithmeticException.class)
    public void testDivideForZero() {
        System.out.println("divide");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.division(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.divide();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDivideOutOfBoundExceptionMax() {
        System.out.println("divide");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0/Double.MAX_VALUE, 1.0/Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.divide();
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDivideOutOfBoundExceptionMin() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0/Double.MAX_VALUE, 1.0/Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.divide();
    }

    //-----------------------multiply-----------------------------------------
    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiplytMaxValues() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(1.0, 0);
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.multiply();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiplyMinValues() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(1, 0);
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.multiply();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiplyZeroValues() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(0, 0);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.multiplication(c1, c2);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.multiply();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMultiplyOutOfBoundExceptionMax() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.multiply();
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMultiplyOutOfBoundExceptionMin() {
        System.out.println("Multiply");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        c2 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.multiply();
    }

    //-----------------------invertSign-----------------------------------------
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignMaxValue() {
        System.out.println("invertSign");
        c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        ComplexNumber expResult = ComplexOperations.signInversion(c1);
        calc.getStoredNumbers().push(c1);
        calc.invertSign();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignMinValue() {
        System.out.println("invertSign");
        c1 = new ComplexNumber(-Double.MAX_VALUE, -Double.MAX_VALUE);
        ComplexNumber expResult = ComplexOperations.signInversion(c1);
        calc.getStoredNumbers().push(c1);
        calc.invertSign();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignZeroValue() {
        System.out.println("invertSign");
        c1 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.signInversion(c1);
        calc.getStoredNumbers().push(c1);
        calc.invertSign();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    //-----------------------squareRoot-----------------------------------------
    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootPosNeg() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(1,-1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        calc.getStoredNumbers().push(c1);
        calc.squareRoot();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNegPos() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(-1, 1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        calc.getStoredNumbers().push(c1);
        calc.squareRoot();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

        /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootPosPos() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        calc.getStoredNumbers().push(c1);
        calc.squareRoot();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

        /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNegNeg() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(-1, -1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        calc.getStoredNumbers().push(c1);
        calc.squareRoot();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootZeroValues() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        calc.getStoredNumbers().push(c1);
        calc.squareRoot();
        assertEquals(expResult, calc.getStoredNumbers().pop());
    }
}

