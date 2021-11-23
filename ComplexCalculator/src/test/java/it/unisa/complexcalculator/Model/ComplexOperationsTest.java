package it.unisa.complexcalculator.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author super
 */
public class ComplexOperationsTest {

    public ComplexOperationsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of multiply method, of class ComplexOperations.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber c1 = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(3, 4);
        ComplexNumber expResult1 = new ComplexNumber(-5, 10);

        ComplexNumber c3 = new ComplexNumber(-1, 2);
        ComplexNumber c4 = new ComplexNumber(-3, 4);
        ComplexNumber expResult2 = new ComplexNumber(-5, -10);

        ComplexNumber c5 = new ComplexNumber(1, -2);
        ComplexNumber c6 = new ComplexNumber(3, -4);

        ComplexNumber expResult3 = new ComplexNumber(-5, -10);

        ComplexNumber c7 = new ComplexNumber(-1, -2);
        ComplexNumber c8 = new ComplexNumber(-3, -4);
        ComplexNumber expResult4 = new ComplexNumber(-5, 10);

        ComplexNumber result1 = ComplexOperations.multiply(c1, c2);
        ComplexNumber result2 = ComplexOperations.multiply(c3, c4);
        ComplexNumber result3 = ComplexOperations.multiply(c5, c6);
        ComplexNumber result4 = ComplexOperations.multiply(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);

    }

    /**
     * Test of divide method, of class ComplexOperations.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        ComplexNumber c1 = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(3, 4);
        double res1 = (double) 11 / 25;
        double res2 = (double) 2 / 25;
        ComplexNumber expResult1 = new ComplexNumber(res1, res2);

        ComplexNumber c3 = new ComplexNumber(-1, 2);
        ComplexNumber c4 = new ComplexNumber(-3, 4);
        double res3 = (double) 11 / 25;
        double res4 = (double) -2 / 25;
        ComplexNumber expResult2 = new ComplexNumber(res3, res4);

        ComplexNumber c5 = new ComplexNumber(1, -2);
        ComplexNumber c6 = new ComplexNumber(3, -4);
        double res5 = (double) 11 / 25;
        double res6 = (double) -2 / 25;
        ComplexNumber expResult3 = new ComplexNumber(res5, res6);

        ComplexNumber c7 = new ComplexNumber(-1, -2);
        ComplexNumber c8 = new ComplexNumber(-3, -4);
        double res7 = (double) 11 / 25;
        double res8 = (double) 2 / 25;
        ComplexNumber expResult4 = new ComplexNumber(res7, res8);

        ComplexNumber result1 = ComplexOperations.divide(c1, c2);
        ComplexNumber result2 = ComplexOperations.divide(c3, c4);
        ComplexNumber result3 = ComplexOperations.divide(c5, c6);
        ComplexNumber result4 = ComplexOperations.divide(c7, c8);

        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        
    }

    @Test
    public void testDivideForZero() {
        System.out.println("divide for zero");
        ComplexNumber c1 = new ComplexNumber(1, 2);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        ComplexNumber expResult1 = new ComplexNumber(0, 0);

        ComplexNumber result1 = ComplexOperations.divide(c1, c2);
        
            assertEquals(expResult1, result1);
        }

    }

