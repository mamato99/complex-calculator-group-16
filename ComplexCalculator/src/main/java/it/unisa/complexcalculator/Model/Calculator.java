package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;
import java.util.*;

public class Calculator {

    private final NumberMemory storedNumbers;
    private final HashMap<Character, ComplexNumber> variables;

    /**
     * <p>
     * Constructor of the Calculator class</p>
     */
    public Calculator() {
        storedNumbers = new NumberMemory();
        variables = new HashMap<>();
        for (char c='A'; c<='Z'; c++){
            variables.put(c, new ComplexNumber(0,0));
        }
    }

    /**
     * <p>
     * This method returns the numbers saved.</p>
     *
     * @return
     * <p>
     * the complex numbers in cartesian notation saved.</p>
     */
    public NumberMemory getStoredNumbers() {
        return storedNumbers;
    }

    /**
     * <p>
     * This method saves the number <code>real</code> and <code>img</code> into the data structure containing the stored complex numbers.</p>
     * @param c The complex number being inserted.
     */
    public void pushNumber(ComplexNumber c) {
        storedNumbers.push(c);
    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and adds them together </p>
     */
    public void add() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.add(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and subtracts them together </p>
     */
    public void subtract() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.difference(c1, c2);
        storedNumbers.push(result);
    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and divides them together </p>
     */
    public void divide() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.division(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and multiplies them together </p>
     */
    public void multiply() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.multiplication(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last number saved on the stack and reverses its sign </p>
     */
    public void invertSign() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.signInversion(c1);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last number saved on the stack and calculates the square root</p>
     */
    public void squareRoot() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.squareRoot(c1);
        storedNumbers.push(result);

    }

    /**
     * <p>This method takes the last two numbers saved in the stack and swaps them.</p>
     */
    public void swap() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();

        storedNumbers.push(c1);
        storedNumbers.push(c2);

    }
    
    /**
     * <p>This function store a new number on the stack that is a copy of the last</p>
     */
    public void dup(){
        if(storedNumbers.len() < 1)
            throw new NotEnoughOperandsException();
        ComplexNumber dup = storedNumbers.top();
        storedNumbers.push(dup);
    }
    
    /**
     * <p>This function takes the list of saved numbers and empties it</p>
     */
    public void clear(){
        while(storedNumbers.len()>0){
            storedNumbers.pop();
        }
    }
    
    /**
     * <p>This function takes the last stored element and deletes it</p>
     */
    public void drop() {
        storedNumbers.pop();
    }

    /**
     * <p>This function takes the second last stored element and push it to the top of the stack</p>
     */
    public void over() {
        if(storedNumbers.len() < 2)
            throw new NotEnoughOperandsException();
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber over = storedNumbers.top();
        
        storedNumbers.push(c1);
        storedNumbers.push(over);
    }
    
   
}
