package it.unisa.complexcalculator.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ComplexNumberTest {
    ComplexNumber c;
    
    public ComplexNumberTest() {
    }
    
    @Before
    public void setUp(){
        c = new ComplexNumber(0,0);
    }
    
    
    //--------------------------getter and setter----------------------------
    
    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        
        double expResult = 1.0;
        
        c.setReal(expResult);
        
        double result = c.getReal();
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of setReal method, of class ComplexNumber.
     */
    @Test
    public void testSetReal() {
        System.out.println("setReal");
        
        double expResult = 1.0;
        
        c.setReal(expResult);
        
        double result = c.getReal();
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        
        double expResult = 1.0;
        
        c.setImaginary(expResult);
        
        double result = c.getImaginary();
        
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of setImaginary method, of class ComplexNumber.
     */
    @Test
    public void testSetImaginary() {
        System.out.println("setImaginary");
        
        double expResult = 1.0;
        
        c.setImaginary(expResult);
        
        double result = c.getImaginary();
        
        assertEquals(expResult, result, 0.001);
    }

    
    //--------------------------parse----------------------------
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseEmptyString() {
        System.out.println("parse");
        
        ComplexNumber.parse("");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseOnlyLetters() {
        System.out.println("parse");
        
        ComplexNumber.parse("abc");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParseOnlyNumbersOneDot() {
        System.out.println("parse");
 
        assertEquals(ComplexNumber.parse("123.456"),new ComplexNumber(123.456, 0));
        
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParseOnlyNumbersZeroDots() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("123456"),new ComplexNumber(123456, 0));
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseOnlyNumbersTwoDots() {
        System.out.println("parse");
        
        ComplexNumber.parse("12.34.56");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseAlphanumericNoImg() {
        System.out.println("parse");
        
        ComplexNumber.parse("123abc");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseAlphanumericWithImg() {
        System.out.println("parse");
        
        ComplexNumber.parse("123abci");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParseAlphanumericOnlyImg() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("123i"),new ComplexNumber(0, 123));
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseAlphanumericOnlyImgException() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("i123"),new ComplexNumber(0, 123));
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParsePlusSign() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("+1+i"),new ComplexNumber(1, 1));
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParseMinusSign() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("-1-i"),new ComplexNumber(-1, -1));
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseDoubleMinusSignExeption() {
        System.out.println("parse");
        
        ComplexNumber.parse("--1");
    }
    
     /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseDoublePlusSignExeption() {
        System.out.println("parse");
        
        ComplexNumber.parse("+-i");
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test
    public void testParseAlphanumericOneDot() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("1.0 + 2.0i"),new ComplexNumber(1, 0));
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NumberFormatException.class)
    public void testParseAlphanumericTwoDots() {
        System.out.println("parse");
        
        assertEquals(ComplexNumber.parse("1..0 + 2.0i"),new ComplexNumber(1, 0));
    }
    
    /**
     * Test of parse method, of class ComplexNumber.
     */
    @Test(expected= NullPointerException.class)
    public void testParseNullString() {
        System.out.println("parse");
        
        ComplexNumber.parse(null);
    }
    
}
