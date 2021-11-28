package it.unisa.complexcalculator.Model;

import java.util.EmptyStackException;

public class Calculator {
    private final NumberMemory storedNumbers;
    
    /**
     * <p>Constructor of the Calculator class</p> 
     */
    public Calculator(){
        storedNumbers = new NumberMemory();
    }

    /**
     * <p>This function returns the numbers saved.</p>
     * @return <p>the complex numbers in cartesian notation saved.</p>
     */
    public NumberMemory getStoredNumbers() {
        return storedNumbers;
    }
    
    /**
     * <p>This function saves the number <code>real</code> and <code>img</code> into the data structure 
     * containing the stored complex numbers.</p>
     * @param real represents the real number to be entered
     * @param img represents the imaginary number to be entered
     */
    public void pushNumber(double real, double img){
        storedNumbers.push(new ComplexNumber(real,img));
    }
    
    /**
     * <p>This function converts the input strings into double numbers and passes them to another function</p>
     * @param re represents the real number to be entered
     * @param im represents the imaginary number to be entered
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
     * <p>This function takes the last two numbers saved on the stack and adds them together </p>
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
     * <p>This function takes the last two numbers saved on the stack and subtracts them together </p>
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
     * <p>This function takes the last two numbers saved on the stack and divides them together </p>
     */
    public void divide(){
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
     * <p>This function takes the last two numbers saved on the stack and multiplies them together </p>
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
     * <p>This function takes the last number saved on the stack and reverses its sign </p>
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
     * <p>This function takes the last number saved on the stack and calculates the square root</p>
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
