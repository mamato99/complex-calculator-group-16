/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.SqrtOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.SubtractOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.OverOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.SwapOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.InvertSignOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.MultiplyOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DupOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DropOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.ClearOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DivideOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.AddOperation;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.ComplexOperations;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class OperationInvokerTest {

    private Calculator c;

    public OperationInvokerTest() {
    }

    @Before
    public void setUp() {
        c = new Calculator();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteAddOperation() {
        System.out.println("executeAddOperation");
        AddOperation op = new AddOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.add(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteAddOperationNotEnoughOperandsException() {
        System.out.println("executeAddOperation");
        AddOperation op = new AddOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSubtractOperation() {
        System.out.println("executeSubtractOperation");
        SubtractOperation op = new SubtractOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.difference(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSubtractOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        SubtractOperation op = new SubtractOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteMultiplyOperation() {
        System.out.println("executeMultiplicationOperation");
        MultiplyOperation op = new MultiplyOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.multiplication(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteMultiplyOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        MultiplyOperation op = new MultiplyOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDivideOperation() {
        System.out.println("executeDivideOperation");
        DivideOperation op = new DivideOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.division(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteDivideOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        DivideOperation op = new DivideOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = ArithmeticException.class)
    public void testExecuteDivideOperationArithmeticException() {
        System.out.println("executeSubtractOperation");
        DivideOperation op = new DivideOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        c.getStoredNumbers().push(c2);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSqrtOperation() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.squareRoot(c1));
    }

    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSqrtOperationNotEnoughOperandsException() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c);
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteInvertSignOperation() {
        System.out.println("executeInvertSignOperation");
        InvertSignOperation op = new InvertSignOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), ComplexOperations.signInversion(c1));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteInvertSignOperationNotEnoughOperandsException() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c);
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDupOperation() {
        System.out.println("executeDupOperation");
        DupOperation op = new DupOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().len(), 2);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteDupOperationNotEnoughOperandsException() {
        System.out.println("executeDupOperation");
        DupOperation op = new DupOperation(c);
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSwapOperation() {
        System.out.println("executeSwapOperation");
        SwapOperation op = new SwapOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().pop(), c1);
        assertEquals(c.getStoredNumbers().pop(), c2);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSwapOperationNotEnoughOperandsException() {
        System.out.println("executeSwapOperation");
        SwapOperation op = new SwapOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteOverOperation() {
        System.out.println("executeOverOperation");
        OverOperation op = new OverOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().pop(), c1);
        assertEquals(c.getStoredNumbers().pop(), c2);
        assertEquals(c.getStoredNumbers().pop(), c1);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteOverOperationNotEnoughOperandsException() {
        System.out.println("executeOverOperation");
        OverOperation op = new OverOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getStoredNumbers().push(c1);
        instance.execute(op);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteClearOperation() {
        System.out.println("executeClearOperation");
        ClearOperation op = new ClearOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().len(), 0);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDropOperation() {
        System.out.println("executeDropOperation");
        DropOperation op = new DropOperation(c);
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getStoredNumbers().push(c1);
        c.getStoredNumbers().push(c2);
        instance.execute(op);
        assertEquals(c.getStoredNumbers().top(), c1);
        assertEquals(c.getStoredNumbers().len(), 1);

    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteDropOperationEmptyStackException() {
        System.out.println("executeDropOperation");
        DropOperation op = new DropOperation(c);
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op);
    }
}
