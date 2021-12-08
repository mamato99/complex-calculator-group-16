
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Operation.StackOperations.SwapOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.SqrtOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.InvertSignOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.SubtractOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.OverOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DropOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.MultiplyOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.AddOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DupOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.DivideOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.ClearOperation;
import it.unisa.complexcalculator.Exception.*;
import it.unisa.complexcalculator.Model.*;
import java.util.EmptyStackException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        AddOperation op = new AddOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.add(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteAddOperationNotEnoughOperandsException() {
        System.out.println("executeAddOperation");
        AddOperation op = new AddOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSubtractOperation() {
        System.out.println("executeSubtractOperation");
        SubtractOperation op = new SubtractOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.difference(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSubtractOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        SubtractOperation op = new SubtractOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteMultiplyOperation() {
        System.out.println("executeMultiplicationOperation");
        MultiplyOperation op = new MultiplyOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.multiplication(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteMultiplyOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        MultiplyOperation op = new MultiplyOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDivideOperation() {
        System.out.println("executeDivideOperation");
        DivideOperation op = new DivideOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.division(c1, c2));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteDivideOperationNotEnoughOperandsException() {
        System.out.println("executeSubtractOperation");
        DivideOperation op = new DivideOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = ArithmeticException.class)
    public void testExecuteDivideOperationArithmeticException() {
        System.out.println("executeSubtractOperation");
        DivideOperation op = new DivideOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        c.getNumbers().push(c2);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSqrtOperation() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.squareRoot(c1));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSqrtOperationNotEnoughOperandsException() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteInvertSignOperation() {
        System.out.println("executeInvertSignOperation");
        InvertSignOperation op = new InvertSignOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), ComplexOperations.signInversion(c1));
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteInvertSignOperationNotEnoughOperandsException() {
        System.out.println("executeSqrtOperation");
        SqrtOperation op = new SqrtOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDupOperation() {
        System.out.println("executeDupOperation");
        DupOperation op = new DupOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
        assertEquals(c.getNumbers().len(), 2);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteDupOperationNotEnoughOperandsException() {
        System.out.println("executeDupOperation");
        DupOperation op = new DupOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteSwapOperation() {
        System.out.println("executeSwapOperation");
        SwapOperation op = new SwapOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().pop(), c1);
        assertEquals(c.getNumbers().pop(), c2);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteSwapOperationNotEnoughOperandsException() {
        System.out.println("executeSwapOperation");
        SwapOperation op = new SwapOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteOverOperation() {
        System.out.println("executeOverOperation");
        OverOperation op = new OverOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().pop(), c1);
        assertEquals(c.getNumbers().pop(), c2);
        assertEquals(c.getNumbers().pop(), c1);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = NotEnoughOperandsException.class)
    public void testExecuteOverOperationNotEnoughOperandsException() {
        System.out.println("executeOverOperation");
        OverOperation op = new OverOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        c.getNumbers().push(c1);
        instance.execute(op, c);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteClearOperation() {
        System.out.println("executeClearOperation");
        ClearOperation op = new ClearOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().len(), 0);
    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test
    public void testExecuteDropOperation() {
        System.out.println("executeDropOperation");
        DropOperation op = new DropOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        ComplexNumber c1 = new ComplexNumber(1, 1);
        ComplexNumber c2 = new ComplexNumber(2, 1);

        c.getNumbers().push(c1);
        c.getNumbers().push(c2);
        instance.execute(op, c);
        assertEquals(c.getNumbers().top(), c1);
        assertEquals(c.getNumbers().len(), 1);

    }

    /**
     * Test of execute method, of class OperationInvoker.
     */
    @Test(expected = EmptyStackException.class)
    public void testExecuteDropOperationEmptyStackException() {
        System.out.println("executeDropOperation");
        DropOperation op = new DropOperation(c.getNumbers());
        OperationInvoker instance = new OperationInvoker();
        instance.execute(op, c);
    }
}
