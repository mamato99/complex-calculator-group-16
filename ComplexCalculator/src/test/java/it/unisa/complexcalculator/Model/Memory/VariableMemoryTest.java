package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class VariableMemoryTest {
    VariableMemory stack;
    ComplexNumber c;
    
    @Before
    public void setUp() {
        stack = VariableMemory.getVariableMemory();
        stack.clear();
        c = new ComplexNumber (1, 2);
    }
    
    
    /**
     * Test of getVariableMemory method, of class VariableMemory.
     */
    @Test
    public void testGetVariableMemory() {
        System.out.println("getVariableMemory");
        VariableMemory expResult = null;
        VariableMemory result = VariableMemory.getVariableMemory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVars method, of class VariableMemory.
     */
    @Test
    public void testGetVars() {
        System.out.println("getVars");
        VariableMemory instance = null;
        ObservableList<Variable> expResult = null;
        ObservableList<Variable> result = instance.getVars();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateVariable method, of class VariableMemory.
     */
    @Test
    public void testUpdateVariable() {
        System.out.println("updateVariable");
        Character c = null;
        ComplexNumber n = null;
        VariableMemory instance = null;
        instance.updateVariable(c, n);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class VariableMemory.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        VariableMemory instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addVariable method, of class VariableMemory.
     */
    @Test
    public void testAddVariable() {
        System.out.println("addVariable");
        Variable var = null;
        VariableMemory instance = null;
        instance.addVariable(var);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVariable method, of class VariableMemory.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
        Character c = null;
        VariableMemory instance = null;
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getVariable(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveVariableState method, of class VariableMemory.
     */
    @Test
    public void testSaveVariableState() {
        System.out.println("saveVariableState");
        VariableMemory instance = null;
        instance.saveVariableState();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadVariableState method, of class VariableMemory.
     */
    @Test
    public void testLoadVariableState() {
        System.out.println("loadVariableState");
        VariableMemory instance = null;
        instance.loadVariableState();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
