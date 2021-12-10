package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Exception.AlreadyExistentOperationException;
import it.unisa.complexcalculator.Exception.ReferencedOperationException;
import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.OperationFactory;
import java.io.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The istance of a <code>OperationMemory</code> class represent the memory of a
 * calculator. This memory contains a list abstraction in which it is possible
 * to store instances of <code>CustomOperation</code> class representing the
 * custom operations defined by the user. It allows to manipulate the stored
 * numbers with the following operations:
 * <ul>
 * <li><b>addCustomOperation</b> to insert a <code>CustomOperation</code> into
 * the list.</li>
 * <li><b>removeCustomOperation</b> to remove a <code>CustomOperation</code>
 * from the list.</li>
 * <li><b>opLen</b> to return the <code>size</code> of the list.</li>
 * <li><b>getOps</b> to return the entire list of
 * <code>CustomOperation</code>.</li>
 * <li><b>getCustomOperation</b> to return a specific
 * <code>CustomOperation</code> into the list.</li>
 * <li><b>refreshName</b> to replace the current name of a
 * <code>CustomOperation</code> with a new name</li>
 * <li><b>refreshSequence</b> to replace the current sequence of a
 * <code>CustomOperation</code> with a new sequence</li>
 * <li><b>checkNameInSequence</b> to verify if a name already exists into a
 * sequence of the <code>CustomOperation</code> list.</li>
 * <li><b>checkDuplicate</b> to verify if a name already exists into another
 * operation of <code>CustomOperation</code> list</li>
 * </ul>
 *
 */
public class OperationMemory implements Serializable {

    private ObservableList<CustomOperation> ops;
    private static OperationMemory instance = null;

    /**
     * Returns the reference to the unique instance of
     * <code>OperationMemory</code> class, in particular if this has already
     * been instantiated (and therefore used), it returns its reference,
     * otherwise it creates and returns it.
     *
     * @return the unique instance of <code>OperationMemory</code>
     */
    public static OperationMemory getOperationMemory() {
        if (instance == null) {
            instance = new OperationMemory();
        }
        return instance;
    }

    /**
     * Instantiates the <code>CustomOperation</code> list
     */
    private OperationMemory() {
        ops = FXCollections.observableArrayList();
    }

    /**
     * Removes the custom operation passed as parameter from the list.
     * <p>
     * Can throw <code>ReferencedOperationException</code>
     * </p>
     *
     * @param op is the <code>CustomOperation</code> that will be deleted into
     * the list
     */
    public void removeCustomOperation(CustomOperation op) {
        if (checkNameInSequence(op.getName())) {
            throw new ReferencedOperationException();
        }
        ops.remove(op);
    }

    /**
     * Adds the custom operation passed as parameter into the list.
     * <p>
     * Can throw <code>AlreadyExistentOperationException</code>
     * </p>
     *
     * @param op is the <code>CustomOperation</code> that will be added into the
     * list
     */
    public void addCustomOperation(CustomOperation op) {
        if (checkDuplicate(op.getName())) {
            throw new AlreadyExistentOperationException();
        }
        ops.add(op);
    }

    /**
     * Returns the corresponding CustomOperation into the list that has as name
     * the parameter taken as input, if this exists, otherwise it returns
     * <code>null</code>.
     *
     * @param name is the name that is taken as input by the
     * <code>getCustomOperation</code> function
     * @return the <code>CustomOperation</code> with <code>name</code> as name
     * if it exists otherwise it returns <code>null</code>
     */
    public CustomOperation getCustomOperation(String name) {
        for (CustomOperation op : ops) {
            if (op.getName().equals(name)) {
                return op;
            }

        }
        return null;
    }

    /**
     * Replaces the current name of the <code>CustomOperation</code> that has
     * actually as name <code>oldName</code>, with <code>newName</code>.
     * <p>
     * Can throw <code>ReferencedOperationException</code>.
     * </p>
     * <p>
     * Can throw <code>AlreadyExistentOperationException</code>.
     * </p>
     *
     * @param oldName is the old name of the <code>CustomOperation</code>.
     * @param newName is the new name of the <code>CustomOperation</code> that
     * will be setted.
     */
    public void refreshName(String oldName, String newName) {
        if (checkNameInSequence(oldName)) {
            throw new ReferencedOperationException();
        }
        if (checkDuplicate(newName)) {
            throw new AlreadyExistentOperationException();
        }
        getCustomOperation(oldName).setName(newName);
    }

    /**
     * Replaces the current sequence of the <code>CustomOperation</code> that
     * has name <code>name</code>, with <code>newSequence</code>.
     *
     * @param newSequence is the new sequence that will be setted.
     * @param name is the name of the <code>CustomOperation</code>.
     */
    public void refreshSequence(String newSequence, String name) {
        getCustomOperation(name).setSequence(newSequence);
    }

    /**
     * Clears the list of <code>CustomOperation</code>.
     */
    public void clear() {
        ops.clear();
    }

    /**
     * @return the lenght of the list of <code>CustomOperation</code>.
     */
    public int opLen() {
        return ops.size();
    }

    /**
     *
     * @return the the entire list of <code>CustomOperation</code>.
     */
    public ObservableList<CustomOperation> getOps() {
        return ops;
    }

    /**
     * Checks if the name <code>name</code> already exists into a sequence of
     * the <code>CustomOperation</code> list.
     *
     * @param name is the name for which we wanna check if it exists or not.
     * @return <code>true</code> if the name exists in a sequence of the list of
     * <code>CustomOperation</code> otherwise it returns <code>false</code>.
     */
    private boolean checkNameInSequence(String name) {
        for (CustomOperation o : ops) {
            String[] tokens = o.getSequence().split(" ");
            for (String s : tokens) {
                if (s.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the name <code>name</code> already exists in another operation
     * of the <code>CustomOperation</code> list.
     *
     * @param name is the name for which we wanna check if it has a duplicate or
     * not.
     * @return <code>true</code> if the name already exists otherwise it returns
     * <code>false</code>.
     */
    private boolean checkDuplicate(String name) {
        for (CustomOperation o : ops) {
            if (o.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
