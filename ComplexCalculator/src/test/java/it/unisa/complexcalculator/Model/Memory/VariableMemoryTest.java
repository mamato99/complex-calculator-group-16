package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.NoSuchElementException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 

public class VariableMemoryTest {
    private VariableMemory stack;
    private ComplexNumber c0;
    private ComplexNumber c1;
    private ComplexNumber c2;
    private Variable v0;
    
    @Before
    public void setUp() {
        c0 = new ComplexNumber(0, 0);
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(2, 2);
        stack = VariableMemory.getVariableMemory();
        
        for(char c = 'a'; c < 'z'; c++) {
            stack.updateVariable(c, new ComplexNumber(0,0));
        }
    }
    
    @After
    public void tearDown(){
        stack.clear();
        for(char c='a'; c<'z'; c++){
            stack.addVariable(new Variable(c,new ComplexNumber(0,0)));
        }
    }
    
    /**
     * Test of getVars method, of class VariableMemory.
     */
    @Test
    public void testGetVars() {
        System.out.println("getVars");
        
        stack.updateVariable('a', c0);
        stack.updateVariable('b', c1);
        stack.updateVariable('c', c2);

        ObservableList<Variable> list = stack.getVars();
        
        assertEquals(list.get(0).getValue(), c0);
        assertEquals(list.get(1).getValue(), c1);
        assertEquals(list.get(2).getValue(), c2);
    }

    /**
     * Test of updateVariable method, of class VariableMemory.
     */
    @Test
    public void testUpdateVariable() {
        System.out.println("updateVariable");
        
        stack.updateVariable('a', c0);
        
        ComplexNumber expected = c0;
        
        assertEquals(expected, stack.getVariable('a'));
    }

    /**
     * Test of getVariable method, of class VariableMemory.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
        
        stack.updateVariable('a', c0);
        
        ComplexNumber expected = c0;

        assertEquals(expected, stack.getVariable('a'));
    }

    /**
     * Test of saveVariableState method, of class VariableMemory.
     */
    @Test
    public void testSaveVariableState() {
        System.out.println("saveVariableState");
        stack.updateVariable('a', c0);
        stack.updateVariable('b', c1);
        stack.updateVariable('c', c2);
        stack.saveVariableState();
        
        stack.updateVariable('a', new ComplexNumber(5,5));
        stack.updateVariable('b', new ComplexNumber(5,5));
        stack.updateVariable('c', new ComplexNumber(5,5));
        
        assertNotEquals(c0,stack.getVariable('a'));
        assertNotEquals(c1,stack.getVariable('b'));
        assertNotEquals(c2,stack.getVariable('c'));
        
        stack.loadVariableState();
        assertEquals(c0,stack.getVariable('a'));
        assertEquals(c1,stack.getVariable('b'));
        assertEquals(c2,stack.getVariable('c'));
    }

    /**
     * Test of loadVariableState method, of class VariableMemory.
     */
    @Test
    public void testLoadVariableState() {
        System.out.println("loadVariableState");
        stack.updateVariable('a', c0);
        stack.updateVariable('b', c1);
        stack.updateVariable('c', c2);
        stack.saveVariableState();
        
        stack.updateVariable('a', new ComplexNumber(5,5));
        stack.updateVariable('b', new ComplexNumber(5,5));
        stack.updateVariable('c', new ComplexNumber(5,5));
        
        assertNotEquals(c0,stack.getVariable('a'));
        assertNotEquals(c1,stack.getVariable('b'));
        assertNotEquals(c2,stack.getVariable('c'));
        
        stack.loadVariableState();
        assertEquals(c0,stack.getVariable('a'));
        assertEquals(c1,stack.getVariable('b'));
        assertEquals(c2,stack.getVariable('c'));
    }
    
    /**
     * Test of loadVariableState method, of class VariableMemory.
     */
    @Test (expected = NoSuchElementException.class)
    public void testLoadVariableStateException() {
        System.out.println("loadVariableState");

        stack.loadVariableState();
    }
   
    
    /**
     * Test of addVariable method, of class VariableMemory.
     */
    @Test
    public void testAddVariable() {
        stack.clear();
        
        stack.addVariable(v0);
        
        ObservableList<Variable> expectedList = FXCollections.observableArrayList(v0);

        assertEquals(expectedList, stack.getVars());
    }
    
    /**
     * Test of clear method, of class VariableMemory.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        
        stack.addVariable(v0);

        stack.clear();        
        
        assertEquals(stack.getVars().size(), 0);
    }
}
