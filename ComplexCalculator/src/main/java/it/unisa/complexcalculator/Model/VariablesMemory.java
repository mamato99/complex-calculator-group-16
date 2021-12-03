
package it.unisa.complexcalculator.Model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Map;

/**
 *
 * @author Amministratore
 */
public class VariablesMemory implements Stack<Map<String, ComplexNumber>> {
    
    java.util.Stack<Map<String, ComplexNumber>> stack;
    int len;

    public VariablesMemory(){
        stack = new java.util.Stack<>();
        len = 0;
    }

    @Override
    public void push(Map<String, ComplexNumber> var) {
        stack.push(var);
        len++;
    }

    @Override
    public Map<String, ComplexNumber> pop() {
        if (len > 0){
            len--;
            return stack.pop();
        }
        else
            throw new EmptyStackException();
    }

    @Override
    public Map<String, ComplexNumber> top() {
        return stack.lastElement();
    }

}
