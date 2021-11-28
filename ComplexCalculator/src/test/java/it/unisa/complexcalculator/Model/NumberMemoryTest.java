package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.*;
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
    
    
    //-----------------------push-----------------------------------------
    
    /**
     * Test of push method, of class NumberMemory. This method pushes a non-null item in the stack.
     */
    @Test
    public void testPush() {
        System.out.println("push of non-null item method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);
        stack.push(toIns);
        
        assertEquals(stack.len(), 1);
        ComplexNumber popItem = stack.pop();
        
        assertEquals(popItem, toIns);
        
        assertEquals(stack.len(), 0);
    }
    
    /**
     * Test of push method, of class NumberMemory. This method pushes a null item in the stack.
     */
    @Test
    public void testPushNull() {
        System.out.println("push of null item method");
        
        ComplexNumber toIns = null;
        stack.push(toIns);
        
        assertEquals(stack.len(), 1);
        
        ComplexNumber popItem = stack.pop();
        assertNull(popItem);
        
        assertEquals(stack.len(), 0);
    }
    
    
    //-----------------------pop-----------------------------------------
    
    /**
     * Test of exception in pop method, of class NumberMemory.
     */
    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStackException() {
        System.out.println("EmptyStackException in pop method");
        
        stack.pop();        
    }
    
    /**
     * Test of pop method, of class NumberMemory. Removing a non-null item.
     */
    @Test
    public void testPop() {
        System.out.println("non-null item in pop method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);

        stack.push(toIns);
        assertEquals(stack.len(), 1);
        assertEquals(stack.pop(), toIns);
        assertEquals(stack.len(), 0);
    }
    
    
    /**
     * Test of pop method, of class NumberMemory. Removing a null item.
     */
    @Test
    public void testPopNull(){
        System.out.println("null item in pop method");
        
        ComplexNumber toIns = null;

        stack.push(toIns);
        assertEquals(stack.len(), 1);
        
        ComplexNumber popItem = stack.pop();
        assertNull(popItem);
        
        assertEquals(stack.len(), 0);
    }
    
    
    //-----------------------top-----------------------------------------
    
    /**
     * Test of top method, of class NumberMemory.
     */
    @Test
    public void testTop() {
        System.out.println("non-null item in top method");
        
        ComplexNumber toIns = new ComplexNumber(1,1);
        
        stack.push(toIns);        
        assertEquals(stack.top(), toIns);
        
    }
    
    /**
     * Test of EmptyStackException in top method, of class NumberMemory. Returning a non-null item.
     */
    @Test(expected = EmptyStackException.class)
    public void testTopEmptyStackException() {
        System.out.println("EmptyStackException in top method");
        
        stack.top();
    }

    /**
     * Test of top method, of class NumberMemory. Returning a null item.
     */
    @Test
    public void testTopNull(){
        System.out.println("null item in top method");
        
        ComplexNumber toIns = null;

        stack.push(toIns);
        assertEquals(stack.len(), 1);
        
        assertNull(stack.top());
                
    }
    
    //-----------------------len-----------------------------------------
    
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
    
    
    //-----------------------getStack-----------------------------------------
    
    /**
     * Test of getStack method, of class NumberMemory. Test if the method returns a non-empty stack.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack");

        ComplexNumber c0 = new ComplexNumber(0,0);
        ComplexNumber c1 = new ComplexNumber(1,1);
        ComplexNumber c2 = new ComplexNumber(2,2);

        ObservableList<ComplexNumber> expectedList = FXCollections.observableArrayList(c0, c1, c2);

        stack.push(c2);
        stack.push(c1);
        stack.push(c0);
        
        ObservableList<ComplexNumber>  list =  stack.getStack();
        assertEquals(expectedList, list);

    }
    
    /**
     * Test of getStack method, of class NumberMemory. Test if the method returns an empty stack.
     */
    @Test
    public void testGetStackEmpty() {
        System.out.println("getStack empty");

        ObservableList<ComplexNumber> expectedList = FXCollections.observableArrayList();

        ObservableList<ComplexNumber>  list =  stack.getStack();
        assertEquals(expectedList, list);

    }
    
    

}
