package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mdr
 */
public class NumberMemoryTest {
    NumberMemory stack;
    
    public NumberMemoryTest() {
    }
    
    @Before
    public void setUp() {
        stack = new NumberMemory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class NumberMemory.
     */
    @Test
    public void testPush() {
        System.out.println("push method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);
        stack.push(toIns);
        
        assertEquals(stack.len(), 1);
        assertEquals(stack.pop(), toIns);
        assertEquals(stack.len(), 0);
    }
    
    /**
     * Test of exception in pop method, of class NumberMemory.
     */
    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStackException() {
        System.out.println("EmptyStackException in pop method");
        
        stack.pop();        
    }
    
    /**
     * Test of pop method, of class NumberMemory.
     */
    @Test
    public void testPop() {
        System.out.println("pop method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);

        stack.push(toIns);
        assertEquals(stack.len(), 1);
        assertEquals(stack.pop(), toIns);
        assertEquals(stack.len(), 0);
    }

    /**
     * Test of top method, of class NumberMemory.
     */
    @Test
    public void testTop() {
        System.out.println("top method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);
        
        stack.push(toIns);        
        assertEquals(stack.top(), toIns);
        
    }
    
    /**
     * Test of EmptyStackException in top method, of class NumberMemory.
     */
    @Test(expected = EmptyStackException.class)
    public void testTopEmptyStackException() {
        System.out.println("top method");
        
        stack.top();
    }

    /**
     * Test of len method, of class NumberMemory.
     */
    @Test
    public void testLen() {
        System.out.println("len method");
        
        assertEquals(stack.len(), 0);
        stack.push(new ComplexNumber(1,1));
        assertEquals(stack.len(), 1);
        stack.pop();
        assertEquals(stack.len(), 0);
    }

    /**
     * Test of getStack method, of class NumberMemory.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack");
        
        ComplexNumber c0 = new ComplexNumber(0,0);
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(2,2);
        
        ObservableList<ComplexNumber> expectedList_2 = FXCollections.observableArrayList();
        ObservableList<ComplexNumber> expectedList_1 = FXCollections.observableArrayList(c0, c1, c2);
        
        ObservableList<ComplexNumber>  list1 =  stack.getStack();
        assertEquals(expectedList_2, list1);
        
        stack.push(c2);
        stack.push(c1);
        stack.push(c0);
        
        ObservableList<ComplexNumber>  list2 =  stack.getStack();
        assertEquals(expectedList_1, list2);
    }
    
}
