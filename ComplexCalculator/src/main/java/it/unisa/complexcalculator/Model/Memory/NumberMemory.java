package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.EmptyStackException;
import javafx.collections.*;

/**
 * The istance of a <code>NumberMemory</code> class represent the memory of a
 * calculator. This memory contains a stack abstraction in which it is possible
 * to store instances of <code>ComplexNumbers</code> class representing complex
 * numbers in cartesian notation. It allows to manipulate the stored numbers
 * with the following operations:
 * <ul>
 * <li><b>push</b> to insert a <code>ComplexNumber</code> at the top of the
 * stack.</li>
 * <li><b>pop</b> to remove a <code>ComplexNumber</code> from the top of the
 * stack.</li>
 * <li><b>top</b> to return the <code>ComplexNumber</code> at the top of the
 * stack.</li>
 * <li><b>len</b> to return the <code>size</code> of the stack.</li>
 * <li><b>getStack</b> to return the entire stack of
 * <code>ComplexNumber</code>.</li>
 * </ul>
 *
 */
public class NumberMemory {

    private static NumberMemory instance = null;
    private final ObservableList<ComplexNumber> stack;

    /**
     * Returns the reference to the unique instance of <code>NumberMemory</code>
     * class, in particular if this has already been instantiated (and therefore
     * used), it returns its reference, otherwise it creates and returns it
     *
     * @return the unique instance of <code>NumberMemory</code>
     */
    public static NumberMemory getNumberMemory() {
        if (instance == null) {
            instance = new NumberMemory();
        }
        return instance;
    }

    /**
     * Constructor of the NumberMemory class.
     * <p>
     * It initializes the stored numbers stack assigning to it an instance of an
     * empty <code>ObservableArrayList</code> class and sets the lenght of the
     * stored numbers to zero.</p>
     */
    private NumberMemory() {
        stack = FXCollections.observableArrayList();
    }

    /**
     * Adds a complex number in cartesian notation in the stack and increases
     * the size of stored numbers by one.
     *
     * @param n The <code>ComplexNumber</code> in cartesian notation.
     */
    public void push(ComplexNumber n) {
        stack.add(0, n);
    }

    /**
     * Removes the complex number in cartesian notation at the top of the stack
     * of stored numbers if the stack is not empty and decreases the size of the
     * stored numbers by one.
     * * <p>
     * Can throw EmptyStackException</p>
     *
     * @return the <code>ComplexNumber</code> at the top of the stack.
     */
    public ComplexNumber pop() {
        if (stack.size() > 0) {
            return stack.remove(0);
        }
        throw new EmptyStackException();
    }

    /**
     * Returns the complex number in cartesian notation at the top of the stack
     * if the stack is not empty.
     *
     * @return the <code>ComplexNumber</code> at the top of the stack in
     * cartesia notation.
     * <p>
     * Can throw EmptyStackException</p>
     */
    public ComplexNumber top() {
        if (stack.size() > 0) {
            return stack.get(0);
        }
        throw new EmptyStackException();
    }

    /**
     * Clears all the elements stored in the stack
     */
    public void clear() {
        stack.clear();
    }

    /**
     * Returns the size of the stored numbers.
     *
     * @return the number of complex numbers (as an <code>int</code>) in
     * cartesian notation contained in the stack.
     */
    public int len() {
        return stack.size();
    }

    /**
     * Returns the stack data structure containing the stored complex numbers in
     * cartesia notation.
     *
     * @return a stack of <code>ComplexNumber</code> as an
     * <code>ObservableList</code> containing complex numbers in cartesian
     * notation.
     */
    public ObservableList<ComplexNumber> getStack() {
        return stack;
    }

}
