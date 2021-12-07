
package it.unisa.complexcalculator.Model.Operation.StackOperations;

import it.unisa.complexcalculator.Model.Operation.StackOperations.SqrtOperation;
import it.unisa.complexcalculator.Exception.*;
import it.unisa.complexcalculator.Model.*;
import it.unisa.complexcalculator.Model.Memory.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtOperationTest {

    private NumberMemory storedNumbers;
    private ComplexNumber c1,c2;
    private SqrtOperation instance;

    @Before
    public void setUp() {
        storedNumbers = new NumberMemory();
        c1=null;
        c2=null;
        instance = new SqrtOperation(storedNumbers);
    }

    /**
     * Test of execute method, of class SqrtOperation.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
         
        ComplexNumber c1 = new ComplexNumber(1, 1);

        storedNumbers.push(c1);

        instance.execute();

        assertEquals(storedNumbers.pop(), ComplexOperations.squareRoot(c1));

    }

    /**
     * Test of execute method, of class SqrtOperation.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteNotEnoughOperandsExeption() {
        System.out.println("execute");
        
        SqrtOperation instance = new SqrtOperation(storedNumbers);

        instance.execute();

    }
    
    /**
     * Test of squareRoot method, of class SqrtOperation.
     */
    @Test
    public void testSquareRootPosNeg() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(1,-1);
        
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        
        storedNumbers.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of squareRoot method, of class SqrtOperation.
     */
    @Test
    public void testSquareRootNegPos() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(-1, 1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        
        storedNumbers.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, storedNumbers.pop());
    }

        /**
     * Test of squareRoot method, of class SqrtOperation.
     */
    @Test
    public void testSquareRootPosPos() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(1, 1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        
        storedNumbers.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, storedNumbers.pop());
    }

        /**
     * Test of squareRoot method, of class SqrtOperation.
     */
    @Test
    public void testSquareRootNegNeg() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(-1, -1);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        
        storedNumbers.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, storedNumbers.pop());
    }

    /**
     * Test of squareRoot method, of class SqrtOperation.
     */
    @Test
    public void testSquareRootZeroValues() {
        System.out.println("squareRoot");
        c1 = new ComplexNumber(0, 0);
        ComplexNumber expResult = ComplexOperations.squareRoot(c1);
        
        storedNumbers.push(c1);
        
        instance.execute();
        
        assertEquals(expResult, storedNumbers.pop());
    }
    
}
