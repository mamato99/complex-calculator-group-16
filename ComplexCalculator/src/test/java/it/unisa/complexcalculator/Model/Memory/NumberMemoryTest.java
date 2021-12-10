package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.EmptyStackException;
import javafx.collections.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NumberMemoryTest {

    NumberMemory stack;
    ComplexNumber c0;
    ComplexNumber c1;
    ComplexNumber c2;

    @Before
    public void setUp() {
        c0 = new ComplexNumber(0, 0);
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(2, 2);
        stack = NumberMemory.getNumberMemory();
        stack.clear();
    }

    //-----------------------------push-----------------------------------------
    /**
     * Test of push method, of class NumberMemory.
     */
    @Test
    public void testPush() {
        System.out.println("push");

        ComplexNumber toIns = new ComplexNumber(1, 1);
        stack.push(toIns);

        assertEquals(stack.len(), 1);
        ComplexNumber popItem = stack.pop();

        assertEquals(popItem, toIns);

        assertEquals(stack.len(), 0);
    }

    //------------------------------pop-----------------------------------------
    /**
     * Test of EmptyStackException in pop method, of class NumberMemory.
     */
    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStackException() {
        System.out.println("EmptyStackException in push");
        stack.pop();
    }

    /**
     * Test of pop method, of class NumberMemory.
     */
    @Test
    public void testPop() {
        System.out.println("pop");

        stack.push(c0);
        assertEquals(stack.pop(), c0);
        assertEquals(stack.len(), 0);
    }

    //------------------------------top-----------------------------------------
    /**
     * Test of top method, of class NumberMemory.
     */
    @Test
    public void testTop() {
        System.out.println("top");

        stack.push(c0);
        assertEquals(stack.top(), c0);

    }

    /**
     * Test of EmptyStackException in top method, of class NumberMemory.
     */
    @Test(expected = EmptyStackException.class)
    public void testTopEmptyStackException() {
        System.out.println("EmptyStackException in top");

        stack.top();
    }

    //------------------------------len-----------------------------------------
    /**
     * Test of len method, of class NumberMemory.
     */
    @Test
    public void testLen() {
        System.out.println("len");

        assertEquals(stack.len(), 0);
        stack.push(c0);
        assertEquals(stack.len(), 1);
        stack.pop();
        assertEquals(stack.len(), 0);
    }

    //----------------------------getStack--------------------------------------
    /**
     * Test of getStack method, of class NumberMemory. Test if the method
     * returns a non-empty stack.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack");

        ObservableList<ComplexNumber> expectedList = FXCollections.observableArrayList(c0, c1, c2);

        stack.push(c2);
        stack.push(c1);
        stack.push(c0);

        ObservableList<ComplexNumber> list = stack.getStack();
        assertEquals(expectedList, list);

    }

    /**
     * Test of getStack method, of class NumberMemory. Test if the method
     * returns an empty stack.
     */
    @Test
    public void testGetStackEmpty() {
        System.out.println("getStack");

        ObservableList<ComplexNumber> expectedList = FXCollections.observableArrayList();

        ObservableList<ComplexNumber> list = stack.getStack();
        assertEquals(expectedList, list);

    }

    //--------------------------getNumberMemory---------------------------------
    /**
     * Test of getNumberMemory method, of class NumberMemory.
     */
    @Test
    public void testGetNumberMemory() {
        System.out.println("getNumberMemory");

        stack.push(c0);
        stack.push(c1);

        NumberMemory result = NumberMemory.getNumberMemory();
        
        assertEquals(stack.len(), result.len());
        assertEquals(c1, result.pop());
        assertEquals(c0, result.pop());

    }

    //------------------------------clear---------------------------------------
    /**
     * Test of clear method, of class NumberMemory.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        stack.push(c0);
        stack.push(c1);
        int before = stack.len();

        stack.clear();

        assertEquals(stack.len(), 0);

    }

}
