package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Exception.ReferencedOperationException;
import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperationMemoryTest {

    OperationMemory ops;
    ConcreteOperationFactory factory;
    CustomOperation op1, op2;

    @Before
    public void setUp() {
        ops = OperationMemory.getOperationMemory();
        factory = new ConcreteOperationFactory();
        op1 = factory.createCustomOperation("op1", "2 3 +");
        op2 = factory.createCustomOperation("op2", "2 3 -");
        ops.clear();
    }

    /**
     * Test of getOperationMemory method, of class OperationMemory.
     */
    @Test
    public void testGetOperationMemory() {
        System.out.println("getOperationMemory");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        OperationMemory expResult = OperationMemory.getOperationMemory();
        assertEquals(expResult.opLen(), ops.opLen());
        assertEquals(expResult.getCustomOperation("op1"), ops.getCustomOperation("op1"));
        assertEquals(expResult.getCustomOperation("op2"), ops.getCustomOperation("op2"));
    }

    /**
     * Test of removeCustomOperation method, of class OperationMemory.
     */
    @Test
    public void testRemoveCustomOperation() {
        System.out.println("removeCustomOperation");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        OperationMemory expResult = OperationMemory.getOperationMemory();
        ops.removeCustomOperation(op1);
        assertEquals(expResult.opLen(), ops.opLen());
    }

    /**
     * Test of removeCustomOperation method, of class OperationMemory.
     */
    @Test(expected = ReferencedOperationException.class)
    public void testRemoveCustomOperationReferencedOperationException() {
        System.out.println("removeCustomOperation");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        CustomOperation op3 = factory.createCustomOperation("op3", "op1");
        ops.addCustomOperation(op3);
        ops.removeCustomOperation(op1);
    }

    /**
     * Test of addCustomOperation method, of class OperationMemory.
     */
    @Test
    public void testAddCustomOperation() {
        System.out.println("addCustomOperationReferencedOperationException");
        ops.addCustomOperation(op1);
        assert (ops.opLen() == 1);
    }

    /**
     * Test of addCustomOperation method, of class OperationMemory.
     */
    @Test(expected = AlreadyExistentOperationException.class)
    public void testAddCustomOperationAlreadyExistentOperationException() {
        System.out.println("addCustomOperationAlreadyExistentOperationException");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op1);
    }

    /**
     * Test of getCustomOperation method, of class OperationMemory.
     */
    @Test
    public void testGetCustomOperation() {
        System.out.println("getCustomOperation");
        ops.addCustomOperation(op1);
        assertEquals(op1, ops.getCustomOperation("op1"));
    }

    /**
     * Test of getCustomOperation method, of class OperationMemory.
     */
    @Test
    public void testGetCustomOperationNullValue() {
        System.out.println("getCustomOperationNullValue");
        assertEquals(null, ops.getCustomOperation("op1"));
    }

    /**
     * Test of refreshName method, of class OperationMemory.
     */
    @Test
    public void testRefreshName() {
        System.out.println("refreshName");
        ops.addCustomOperation(op1);
        ops.refreshName("op1", "op3");
        assertEquals(op1, ops.getCustomOperation("op3"));
    }

    /**
     * Test of refreshName method, of class OperationMemory.
     */
    @Test(expected = AlreadyExistentOperationException.class)
    public void testRefreshNameAlreadyExistentOperationException() {
        System.out.println("refreshNameAlreadyExistentOperationException");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        ops.refreshName("op1", "op2");
    }

    /**
     * Test of refreshName method, of class OperationMemory.
     */
    @Test(expected = AlreadyExistentOperationException.class)
    public void testRefreshNameReferencedOperationException() {
        System.out.println("refreshNameReferencedOperationException");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        CustomOperation op3 = factory.createCustomOperation("op3", "op1");
        ops.refreshName("op1", "op2");
    }

    /**
     * Test of refreshSequence method, of class OperationMemory.
     */
    @Test
    public void testRefreshSequence() {
        System.out.println("refreshSequence");
        ops.addCustomOperation(op1);
        ops.refreshSequence("+", "op1");
        assert(ops.getCustomOperation("op1").getSequence().equals("+"));
    }

    /**
     * Test of clear method, of class OperationMemory.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ops.addCustomOperation(op1);
        ops.clear();
        assert (ops.opLen() == 0);
    }

    /**
     * Test of opLen method, of class OperationMemory.
     */
    @Test
    public void testOpLen() {
        System.out.println("opLen");
        ops.addCustomOperation(op1);
        assert (ops.opLen() == 1);
    }

    /**
     * Test of getOps method, of class OperationMemory.
     */
    @Test
    public void testGetOps() {
        System.out.println("getOps");
        ops.addCustomOperation(op1);
        ops.addCustomOperation(op2);
        OperationMemory expResult = OperationMemory.getOperationMemory();
        assertEquals(ops.getOps(), expResult.getOps());
    }

}
