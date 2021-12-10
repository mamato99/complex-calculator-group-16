package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Exception.OutOfBoundException;

import static java.lang.Math.sqrt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexOperationsTest {

    ComplexNumber c1, c2, c3, c4, c5, c6, c7, c8;

    @Before
    public void setUp() {
        c1 = null;
        c2 = null;
        c3 = null;
        c4 = null;
        c5 = null;
        c6 = null;
        c7 = null;
        c8 = null;
    }

    /**
     * Test of add method, of class ComplexOperations.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        c1 = new ComplexNumber(1, 2);
        c2 = new ComplexNumber(3, 4);
        ComplexNumber expResult1 = new ComplexNumber(4, 6);

        c3 = new ComplexNumber(-1, 2);
        c4 = new ComplexNumber(-3, 4);
        ComplexNumber expResult2 = new ComplexNumber(-4, 6);

        c5 = new ComplexNumber(1, -2);
        c6 = new ComplexNumber(3, -4);
        ComplexNumber expResult3 = new ComplexNumber(4, -6);

        c7 = new ComplexNumber(-1, -2);
        c8 = new ComplexNumber(-3, -4);
        ComplexNumber expResult4 = new ComplexNumber(-4, -6);

        ComplexNumber result1 = ComplexOperations.add(c1, c2);
        ComplexNumber result2 = ComplexOperations.add(c3, c4);
        ComplexNumber result3 = ComplexOperations.add(c5, c6);
        ComplexNumber result4 = ComplexOperations.add(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    //-----------------------ADD------------------------------------------------
    /**
     * Test of add method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddMaximumBound() {
        ComplexNumber c3 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        ComplexNumber c4 = new ComplexNumber(-33, -30);
        ComplexNumber result2 = ComplexOperations.add(c3, c4);
    }

    /**
     * Test of add method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testAddMinimumBound() {
        ComplexNumber c3 = new ComplexNumber(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        ComplexNumber c4 = new ComplexNumber(-2, 30);
        ComplexNumber result2 = ComplexOperations.add(c3, c4);
    }

    //-----------------------DIFFERENCE-----------------------------------------
    /**
     * Test of difference method, of class ComplexOperations.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        c1 = new ComplexNumber(1, 2);
        c2 = new ComplexNumber(3, 4);
        ComplexNumber expResult1 = new ComplexNumber(-2, -2);

        c3 = new ComplexNumber(-1, 2);
        c4 = new ComplexNumber(-3, 4);
        ComplexNumber expResult2 = new ComplexNumber(2, -2);

        c5 = new ComplexNumber(1, -2);
        c6 = new ComplexNumber(3, -4);
        ComplexNumber expResult3 = new ComplexNumber(-2, 2);

        c7 = new ComplexNumber(-1, -2);
        c8 = new ComplexNumber(-3, -4);
        ComplexNumber expResult4 = new ComplexNumber(2, 2);

        ComplexNumber result1 = ComplexOperations.difference(c1, c2);
        ComplexNumber result2 = ComplexOperations.difference(c3, c4);
        ComplexNumber result3 = ComplexOperations.difference(c5, c6);
        ComplexNumber result4 = ComplexOperations.difference(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of difference method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDifferenceMaximumBound() {
        ComplexNumber c3 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        ComplexNumber c4 = new ComplexNumber(-2, 30);
        ComplexNumber result2 = ComplexOperations.add(c3, c4);
    }

    /**
     * Test of difference method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testDifferenceMinimunBound() {
        ComplexNumber c3 = new ComplexNumber(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        ComplexNumber c4 = new ComplexNumber(-2, 30);
        ComplexNumber result2 = ComplexOperations.add(c3, c4);
    }

    //-----------------------ABS------------------------------------------------
    /**
     * Test of abs method, of class ComplexOperations.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");

        c1 = new ComplexNumber(1, -2);
        double expResult1 = sqrt(5);

        c2 = new ComplexNumber(-1, 2);
        double expResult2 = sqrt(5);

        c3 = new ComplexNumber(-1, -2);
        double expResult3 = sqrt(5);

        c4 = new ComplexNumber(1, 2);
        double expResult4 = sqrt(5);

        double result1 = ComplexOperations.abs(c1);
        double result2 = ComplexOperations.abs(c2);
        double result3 = ComplexOperations.abs(c3);
        double result4 = ComplexOperations.abs(c4);

        assertEquals(expResult1, result1, 0.001);
        assertEquals(expResult2, result2, 0.001);
        assertEquals(expResult3, result3, 0.001);
        assertEquals(expResult4, result4, 0.001);
    }

    /**
     * Test of abs method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMaximumBoundAbs() {
        /*ComplexNumber c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        double result1 = ComplexOperations.abs(c1);*/

        c2 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        double result2 = ComplexOperations.abs(c2);
    }

    //-----------------------SQUAREROOT-----------------------------------------
    /**
     * Test of squareRoot method, of class ComplexOperations.
     */
    @Test
    public void testSquareRoot() {
        System.out.println("sqrtComplex");
        c1 = new ComplexNumber(1, -2);
        ComplexNumber expResult1 = new ComplexNumber(-1.272, 0.786);

        c2 = new ComplexNumber(-1, 2);
        ComplexNumber expResult2 = new ComplexNumber(0.786, 1.272);

        c3 = new ComplexNumber(-1, -2);
        ComplexNumber expResult3 = new ComplexNumber(-0.786, 1.272);

        c4 = new ComplexNumber(1, 2);
        ComplexNumber expResult4 = new ComplexNumber(1.272, 0.786);

        c5 = new ComplexNumber(-4, 0);
        ComplexNumber expResult5 = new ComplexNumber(0.000, 2.000);

        ComplexNumber result1 = ComplexOperations.squareRoot(c1);
        double real1 = result1.getReal();
        double imaginary1 = result1.getImaginary();
        BigDecimal bdr1 = new BigDecimal(real1).setScale(3, RoundingMode.HALF_UP);
        BigDecimal bdi1 = new BigDecimal(imaginary1).setScale(3, RoundingMode.HALF_UP);
        ComplexNumber res1 = new ComplexNumber(bdr1.doubleValue(), bdi1.doubleValue());

        ComplexNumber result2 = ComplexOperations.squareRoot(c2);
        double real2 = result2.getReal();
        double imaginary2 = result2.getImaginary();
        BigDecimal bdr2 = new BigDecimal(real2).setScale(3, RoundingMode.HALF_UP);
        BigDecimal bdi2 = new BigDecimal(imaginary2).setScale(3, RoundingMode.HALF_UP);
        ComplexNumber res2 = new ComplexNumber(bdr2.doubleValue(), bdi2.doubleValue());

        ComplexNumber result3 = ComplexOperations.squareRoot(c3);
        double real3 = result3.getReal();
        double imaginary3 = result3.getImaginary();
        BigDecimal bdr3 = new BigDecimal(real3).setScale(3, RoundingMode.HALF_UP);
        BigDecimal bdi3 = new BigDecimal(imaginary3).setScale(3, RoundingMode.HALF_UP);
        ComplexNumber res3 = new ComplexNumber(bdr3.doubleValue(), bdi3.doubleValue());

        ComplexNumber result4 = ComplexOperations.squareRoot(c4);
        double real4 = result4.getReal();
        double imaginary4 = result4.getImaginary();
        BigDecimal bdr4 = new BigDecimal(real4).setScale(3, RoundingMode.HALF_UP);
        BigDecimal bdi4 = new BigDecimal(imaginary4).setScale(3, RoundingMode.HALF_UP);
        ComplexNumber res4 = new ComplexNumber(bdr4.doubleValue(), bdi4.doubleValue());

        ComplexNumber result5 = ComplexOperations.squareRoot(c5);
        double real5 = result5.getReal();
        double imaginary5 = result5.getImaginary();
        BigDecimal bdr5 = new BigDecimal(real5).setScale(3, RoundingMode.HALF_UP);
        BigDecimal bdi5 = new BigDecimal(imaginary5).setScale(3, RoundingMode.HALF_UP);
        ComplexNumber res5 = new ComplexNumber(bdr5.doubleValue(), bdi5.doubleValue());

        assertEquals(expResult1, res1);
        assertEquals(expResult2, res2);
        assertEquals(expResult3, res3);
        assertEquals(expResult4, res4);
        assertEquals(expResult5, res5);
    }

    /**
     * Test of squareRoot method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMaximumBoundSquareRoots() {
        /*ComplexNumber c1 = new ComplexNumber(Double.MAX_VALUE, Double.MAX_VALUE);
        ComplexNumber result1 = ComplexOperations.squareRoot(c1);*/

        c2 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        ComplexNumber result2 = ComplexOperations.squareRoot(c2);
    }

    /**
     * Test of squareRoot method, of class ComplexOperations.
     */
    @Test(expected = OutOfBoundException.class)
    public void testMinimumBoundSquareRoots() {
        /*ComplexNumber c1 = new ComplexNumber(-Double.MAX_VALUE, Double.MAX_VALUE);
        ComplexNumber result5 = ComplexOperations.squareRoot(c1);*/

        c2 = new ComplexNumber(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        ComplexNumber result2 = ComplexOperations.squareRoot(c2);
    }

    //-----------------------INVERTSIGN-----------------------------------------
    /**
     * Test of invertSign method, of class ComplexOperations.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        c1 = new ComplexNumber(1, -2);
        ComplexNumber expResult1 = new ComplexNumber(-1, 2);

        c2 = new ComplexNumber(-1, 2);
        ComplexNumber expResult2 = new ComplexNumber(1, -2);

        c3 = new ComplexNumber(-1, -2);
        ComplexNumber expResult3 = new ComplexNumber(1, 2);

        c4 = new ComplexNumber(1, 2);
        ComplexNumber expResult4 = new ComplexNumber(-1, -2);

        ComplexNumber result1 = ComplexOperations.signInversion(c1);
        ComplexNumber result2 = ComplexOperations.signInversion(c2);
        ComplexNumber result3 = ComplexOperations.signInversion(c3);
        ComplexNumber result4 = ComplexOperations.signInversion(c4);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    //-----------------------MULTIPLICATION-----------------------------------------
    /**
     * Test of multiply method, of class ComplexOperations.
     */
    @Test
    public void testMultiplication() {
        System.out.println("multiply");
        c1 = new ComplexNumber(1, 2);
        c2 = new ComplexNumber(3, 4);
        ComplexNumber expResult1 = new ComplexNumber(-5, 10);

        c3 = new ComplexNumber(-1, 2);
        c4 = new ComplexNumber(-3, 4);
        ComplexNumber expResult2 = new ComplexNumber(-5, -10);

        c5 = new ComplexNumber(1, -2);
        c6 = new ComplexNumber(3, -4);

        ComplexNumber expResult3 = new ComplexNumber(-5, -10);

        c7 = new ComplexNumber(-1, -2);
        c8 = new ComplexNumber(-3, -4);
        ComplexNumber expResult4 = new ComplexNumber(-5, 10);

        ComplexNumber result1 = ComplexOperations.multiplication(c1, c2);
        ComplexNumber result2 = ComplexOperations.multiplication(c3, c4);
        ComplexNumber result3 = ComplexOperations.multiplication(c5, c6);
        ComplexNumber result4 = ComplexOperations.multiplication(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);

    }

    @Test(expected = OutOfBoundException.class)
    public void testMaximumBoundMultiplication() {
        c1 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        c2 = new ComplexNumber(2, 2);
        ComplexNumber result = ComplexOperations.multiplication(c1, c2);

    }

    @Test(expected = OutOfBoundException.class)
    public void testMinimumBoundMultiplication() {
        c1 = new ComplexNumber(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        c2 = new ComplexNumber(2, 2);
        ComplexNumber result = ComplexOperations.multiplication(c1, c2);

    }

    //-----------------------DIVISION-----------------------------------------
    /**
     * Test of divide method, of class ComplexOperations.
     */
    @Test
    public void testDivision() {
        System.out.println("divide");
        c1 = new ComplexNumber(1, 2);
        c2 = new ComplexNumber(3, 4);
        double res1 = (double) 11 / 25;
        double res2 = (double) 2 / 25;
        ComplexNumber expResult1 = new ComplexNumber(res1, res2);

        c3 = new ComplexNumber(-1, 2);
        c4 = new ComplexNumber(-3, 4);
        double res3 = (double) 11 / 25;
        double res4 = (double) -2 / 25;
        ComplexNumber expResult2 = new ComplexNumber(res3, res4);

        c5 = new ComplexNumber(1, -2);
        c6 = new ComplexNumber(3, -4);
        double res5 = (double) 11 / 25;
        double res6 = (double) -2 / 25;
        ComplexNumber expResult3 = new ComplexNumber(res5, res6);

        c7 = new ComplexNumber(-1, -2);
        c8 = new ComplexNumber(-3, -4);
        double res7 = (double) 11 / 25;
        double res8 = (double) 2 / 25;
        ComplexNumber expResult4 = new ComplexNumber(res7, res8);

        ComplexNumber result1 = ComplexOperations.division(c1, c2);
        ComplexNumber result2 = ComplexOperations.division(c3, c4);
        ComplexNumber result3 = ComplexOperations.division(c5, c6);
        ComplexNumber result4 = ComplexOperations.division(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);

    }

    @Test(expected = OutOfBoundException.class)
    public void testMinimumBuondDivision() {
        c1 = new ComplexNumber(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        c2 = new ComplexNumber(0.5, 0.5);
        ComplexNumber result = ComplexOperations.division(c1, c2);

    }

    @Test(expected = OutOfBoundException.class)
    public void testMaximumBuondDivision() {
        c1 = new ComplexNumber(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        c2 = new ComplexNumber(0.5, 0.5);

        ComplexNumber expResult = new ComplexNumber(0, 0);
        ComplexNumber result = ComplexOperations.division(c1, c2);
        assertEquals(expResult, result);

    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionForZero() {
        System.out.println("divide for zero");
        c1 = new ComplexNumber(1, 2);
        c2 = new ComplexNumber(0, 0);
        ComplexNumber result1 = ComplexOperations.division(c1, c2);
    }

}
