package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amministratore
 */
public class NumberMemory{
    
    private final ObservableList<ComplexNumber> stack;
    private int len;

    /**
     *
     */
    public NumberMemory() {
        stack = FXCollections.observableArrayList();
        len = 0;
    }
    
    /**
     *
     * @param n
     */
    public void push(ComplexNumber n){
        stack.add(0, n);
        len++;
    }
    
    /**
     *
     * @return
     */
    public ComplexNumber pop(){
        if (len > 0){
            len--;
            return stack.remove(0);
        }
        throw new EmptyStackException();
        
    }
    
    /**
     *
     * @return
     */
    public ComplexNumber top(){
        if (len > 0)
            return stack.get(0);
        throw new EmptyStackException();
    }
    
    /**
     *
     * @return
     */
    public int len(){
        return len;
    }
    
    /**
     *
     * @return
     */
    public ObservableList<ComplexNumber> getStack() {
        return stack;
    }
    
}
