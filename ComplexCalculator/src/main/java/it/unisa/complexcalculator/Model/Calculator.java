package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;

/**
 *
 * @author Amministratore
 */
public class Calculator {
    private final NumberMemory storedNumbers;
    
    public Calculator(){
        storedNumbers = new NumberMemory();
    }

    public NumberMemory getStoredNumbers() {
        return storedNumbers;
    }
    
    public void pushNumber(double real, double img){
        storedNumbers.push(new ComplexNumber(real,img));
    }
    
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
    
    public void devide(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.divide(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    public void multiply(){
        try{
            ComplexNumber c1 = storedNumbers.pop();
            ComplexNumber c2 = storedNumbers.pop();   
            ComplexNumber result = ComplexOperations.multiply(c1, c2);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
    public void invertSign(){
        try{
            ComplexNumber c1 = storedNumbers.pop(); 
            ComplexNumber result = ComplexOperations.signInversion(c1);
            storedNumbers.push(result);
        } catch (EmptyStackException ex){
            System.err.println("Empty stack.");
        }
    }
    
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
