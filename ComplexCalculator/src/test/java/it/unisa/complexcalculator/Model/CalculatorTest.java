package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
    /**
     * Test of add method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testAddNotEnoughOperandsException() {
        System.out.println("add");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
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
    
    /**
     * Test of subtract method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSubtractNotEnoughOperandsException() {
        System.out.println("subtract");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
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
    
    /**
     * Test of divide method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testDivideNotEnoughOperandsException() {
        System.out.println("divide");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
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
    
    /**
     * Test of multiply method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testMultiplyNotEnoughOperandsException() {
        System.out.println("multiply");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
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
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testInvertSignNotEnoughOperandsException() {
        System.out.println("invertSign");
        calc.invertSign();
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
    
    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSquareRootNotEnoughOperandsException() {
        System.out.println("squareRoot");
        calc.squareRoot();
    }
    
    
    //-----------------------swap-----------------------------------------
    
    /**
     * Test of swap method, of class Calculator.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(-1, -1);
        
        ComplexNumber[] expResult = {c1,c2};
        ComplexNumber[] result;
        result = new ComplexNumber[2];
        
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        
        calc.swap();
        
        result[0] = calc.getStoredNumbers().pop();
        result[1] = calc.getStoredNumbers().pop();
        
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }
    
     /**
     * Test of swap method, of class Calculator.
     */
    @Test(expected = Exception.class)
    public void testSwapException() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);
        
        calc.getStoredNumbers().push(c1);
        
        calc.swap();
    }
    
    /**
     * Test of swap method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testSwapNotEnoughOperandsException() {
        System.out.println("swap");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
        calc.swap();
    }
}

