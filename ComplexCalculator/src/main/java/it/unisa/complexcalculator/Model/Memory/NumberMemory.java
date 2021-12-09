package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.EmptyStackException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * <p>The istance of a <code>NumberMemory</code> class represent the memory of a calculator. This memory contains a
 * stack abstraction in which it is possible to store instances of <code>ComplexNumbers</code> class representing 
 * complex numbers in cartesian notation. It allows to manipulate the stored numbers the following operations:
 * <ul>
 * <li><b>push</b> to insert a <code>ComplexNumber</code> at the top of the stack.</li>
 * <li><b>pop</b> to remove a <code>ComplexNumber</code> from the top of the stack.</li>
 * <li><b>top</b> to return the <code>ComplexNumber</code> at the top of the stack.</li>
 * </ul>
 * </p>
 */
public class NumberMemory{
    
    private static NumberMemory instance = null;
    private ObservableList<ComplexNumber> stack;

    public static NumberMemory getNumberMemory(){
        if(instance == null)
            instance = new NumberMemory();
        return instance;
    }
    
    /**
     * <p>Constructor of the NumberMemory class.</p>
     * <p>It initializes the stored numbers stack assigning to it an instance of an empty 
     * <code>ObservableArrayList</code> class and sets the lenght of the stored numbers to zero.</p>
     */
    private NumberMemory() {
        stack = FXCollections.observableArrayList();
    }
    
    /**
     * <p>Adds a complex number in cartesian notation in the stack and increases the size of
     * stored numbers by one.</p>
     * @param n The <code>ComplexNumber</code> in cartesian notation.
     */
    public void push(ComplexNumber n){
        stack.add(0, n);
    }
    
    /**
     * <p>Removes the complex number in cartesian notation at the top of the stack of stored numbers if the stack is not empty
     * and decreases the size of the stored numbers by one.</p>
     * @return the <code>ComplexNumber</code> at the top of the stack.
     */
    public ComplexNumber pop(){
        if (stack.size() > 0){
            return stack.remove(0);
        }
        throw new EmptyStackException();      
    }
    
    /**
     * <p>Returns the complex numebr in cartesian notation at the top of the stack if the stack is not empty.</p>
     * @return the <code>ComplexNumber</code> at the top of the stack in cartesia notation.
     */
    public ComplexNumber top(){
        if (stack.size() > 0)
            return stack.get(0);
        throw new EmptyStackException();
    }
    
    public void clear(){
        stack.clear();
    }
    
    /**
     * <p>Returns the size of the stored numbers.</p>
     * @return the number of complex numbers (as an <code>int</code>) in cartesian notation contained in the stack.
     */
    public int len(){
        return stack.size();
    }
    
    /**
     * <p>Returns the stack data structure containing the stored complex numbers in cartesia notation.</p>
     * @return a stack of <code>ObservableList&#60;ComplexNumber&#62;</code> containing complex numbers in cartesian notation.
     */
    public ObservableList<ComplexNumber> getStack() {
        return stack;
    }
    
    public void setStack(ObservableList<ComplexNumber> numbers){
        stack = numbers;
    }

}
