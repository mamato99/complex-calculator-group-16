package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;

/**
 *
 * @author Amministratore
 */
public class Calculator {
    private final NumberMemory storedNumbers;
    
    /**
     *
     */
    public Calculator(){
        storedNumbers = new NumberMemory();
    }

    /**
     *
     * @return
     */
    public NumberMemory getStoredNumbers() {
        return storedNumbers;
    }
    
    /**
     *
     * @param real
     * @param img
     */
    public void pushNumber(double real, double img){
        storedNumbers.push(new ComplexNumber(real,img));
    }
    
    /**
     *
     * @param re
     * @param im
     */
    public void pushNumber(String re, String im){
        double real;
        double img;
        
        if(re.equalsIgnoreCase("+") || re.equalsIgnoreCase("-"))
            real = 0;
        else
            real = Double.parseDouble(re);
        
        if(im.equalsIgnoreCase("+") || im.equalsIgnoreCase("-"))
            img = 0;
        else
            img = Double.parseDouble(im);
        
        pushNumber(real,img);
    }
    
    /**
     *
     */
    public void add(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.add(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    /**
     *
     */
    public void subtract(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.difference(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    /**
     *
     */
    public void devide(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.division(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    /**
     *
     */
    public void multiply(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.multiplication(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    /**
     *
     */
    public void invertSign(){
        try{
            ComplexNumber c1 = storedNumbers.pop(); 
            ComplexNumber result = ComplexOperations.signInversion(c1);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    /**
     *
     */
    public void squareRoot(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber result = ComplexOperations.squareRoot(c1);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
}
