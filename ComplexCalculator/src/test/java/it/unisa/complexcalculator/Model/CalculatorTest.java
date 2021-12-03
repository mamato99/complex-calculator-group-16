package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Exception.NotExistentVariableException;
import it.unisa.complexcalculator.Exception.OutOfBoundException;
import java.util.EmptyStackException;
import java.util.HashMap;
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
    
    
    //-----------------------pushNumber - Boundary analysis-----------------------------------------
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberMinValues() {
        System.out.println("pushNumber - Min values");
        
        // Test 1 - Min Values for real and img part
        double real = -Double.MAX_VALUE;
        double img = -Double.MAX_VALUE;
        calc.pushNumber(new ComplexNumber(real, img));
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberMaxValues() {
        System.out.println("pushNumber - Max values");
        
        // Test 2 - Max Values for real and img part
        double real = Double.MAX_VALUE;
        double img = Double.MAX_VALUE;
        calc.pushNumber(new ComplexNumber(real, img));
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }
    
    /**
     * Test of pushNumber method, of class Calculator.
     */
    @Test
    public void testPushNumberZeroValues() {
        System.out.println("pushNumber - Zero values");
        
        // Test 3 - Zero values for real and img part
        double real = 0.0;
        double img = 0.0;
        calc.pushNumber(new ComplexNumber(real, img));
        assertEquals(new ComplexNumber(real,img), calc.getStoredNumbers().pop());
        
    }
    
    
    //-----------------------pushVariable-----------------------------------------
    
    /**
     * Test of pushVariable method, of class Calculator. Must throw an exception.
     */
    @Test(expected=NotExistentVariableException.class)
    public void testPushVariableWrongChar() {
        System.out.println("pushVariable");
        
        char v = 'a';
        
        calc.variableToStack(v);
    }
    
    /**
     * Test of pushVariable method, of class Calculator.
     */
    @Test
    public void testPushVariable() {
        System.out.println("pushVariable");
        char v = 'A';
        c1 = new ComplexNumber(1,1);
        
        calc.getVariables().put(v, c1);
        calc.variableToStack(v);
        assertEquals(calc.getStoredNumbers().pop(), c1);
    }
   
    
    //-----------------------addToVariable-----------------------------------------
    
    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("add to variable");
        Character v = 'C'; 
        c1 = new ComplexNumber(1,1);
        c2 = new ComplexNumber(-1,-1);


        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);

        calc.addToVariable(v);

        assertEquals(calc.getVariables().get(v), c2);

        calc.addToVariable(v);

        c2 = new ComplexNumber(0,0);
        assertEquals(calc.getVariables().get(v), c2);

    }
    
    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test(expected=EmptyStackException.class)
    public void testAddToVariableEmptyStackException() {
        System.out.println("add to variable");
        Character v = 'C'; 
        calc.addToVariable(v);

    }

    /**
     * Test of addToVariable method, of class Calculator.
     */
    @Test(expected=NotExistentVariableException.class)
    public void testAddToVariableNotExistentVariableException() {
        System.out.println("add to variable");
        Character v = '5'; 
        c1 = new ComplexNumber(1,1);
        calc.getStoredNumbers().push(c1);
        calc.addToVariable(v);

    }
    
    
    //-----------------------addToVariable-----------------------------------------
    
     /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test
    public void testSubtractToVariable() {
        System.out.println("SubtractToVariable");
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(1, 1);

        HashMap<Character, ComplexNumber> m = calc.getVariables();
        m.put('a', c1);
        calc.getStoredNumbers().push(c2);
        calc.subtractToVariable('a');
        assertEquals(m.get('a'), ComplexOperations.difference(c1, c2));
    }

    /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test(expected = EmptyStackException.class)
    public void testSubtractToVariableNotEnoughOperandsException() {
        System.out.println("SubtractToVariableNotEnoughOperandsException");
        HashMap<Character, ComplexNumber> m = calc.getVariables();
        m.put('a', c1);
        calc.subtractToVariable('a');
    }

    /**
     * Test of subtractToVariable method, of class Calculator.
     */
    @Test(expected = NotExistentVariableException.class)
    public void testSubtractToVariableNotExsistentVariableException() {
        System.out.println("SubtractToVariableNotExsistentVariableException");
        c1 = new ComplexNumber(1, 1);
        calc.getStoredNumbers().push(c1);
        HashMap<Character, ComplexNumber> m = calc.getVariables();
        calc.subtractToVariable('a');
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
    
    
    //-----------------------dup-----------------------------------------
    
    /*
     * Test of dup method, of class Calculator.
     */
    @Test
    public void testDup(){
        System.out.println("dup");
        c1 = new ComplexNumber(123,456);
        calc.getStoredNumbers().getStack().clear();
        calc.pushNumber(c1);

        calc.dup();

        assertEquals(c1, calc.getStoredNumbers().top());
    }

    /*
     * Test of dup method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testDupNotEnoughOperandsException(){
        System.out.println("dup exception");
        calc.dup();
    }
    
    
    //-----------------------clear-----------------------------------------
    
    /**
     * Test of clear method, of class Calculator.
     */
    @Test
    public void testClear(){
        System.out.println("clear");
        c1 = new ComplexNumber(1,1);
        calc.getStoredNumbers().push(c1);
        calc.clear();
        assert(calc.getStoredNumbers().len() == 0);
    }
    
    
    //-----------------------drop-----------------------------------------
    
    /**
     * Test of drop method, of class Calculator.
     */
    @Test(expected = EmptyStackException.class)
    public void testDropEmptyStackException() {
        System.out.println("drop");
        calc.drop();
    }

     /**
     * Test of drop method, of class Calculator.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        c1 = new ComplexNumber(1,1);
        calc.getStoredNumbers().push(c1);
        calc.drop();
        assert(calc.getStoredNumbers().len() == 0);
    }
    
    
    //-----------------------over-----------------------------------------
    
    /**
     * Test of over method, of class Calculator.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testOverNotEnoughOperandsException() {
        System.out.println("over");
        c1 = new ComplexNumber(1,1);
        calc.over();
    }
    
    /**
     * Test of over method, of class Calculator.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        c1 = new ComplexNumber(1,1);
        c2 = new ComplexNumber(-1,-1);
        
        calc.getStoredNumbers().push(c1);
        calc.getStoredNumbers().push(c2);
        calc.over();
        
        assertEquals(calc.getStoredNumbers().top(), c1);
    }
}

