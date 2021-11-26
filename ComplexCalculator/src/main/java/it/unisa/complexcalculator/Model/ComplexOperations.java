package it.unisa.complexcalculator.Model;


import it.unisa.complexcalculator.Exception.OutOfBoundException;
import static java.lang.Math.sqrt;

/**
 *
 * @author mdr
 */
public final class ComplexOperations {

    /**
     *
     * @param c1
     * @param c2
     * @return
     * @throws OutOfBoundException
     */
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) throws OutOfBoundException{
        Double real = c1.getReal() + c2.getReal();
        Double imaginary = c1.getImaginary() + c2.getImaginary();
        if(real.isInfinite() || imaginary.isInfinite())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);
    }
    
    /**
     *
     * @param c1
     * @param c2
     * @return
     * @throws OutOfBoundException
     */
    public static ComplexNumber difference(ComplexNumber c1, ComplexNumber c2) throws OutOfBoundException{
        Double real = c1.getReal() - c2.getReal();
        Double imaginary = c1.getImaginary() - c2.getImaginary();
        if(real.isInfinite() || imaginary.isInfinite())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);    
    }

    /**
     *
     * @param c
     * @return
     * @throws OutOfBoundException
     */
    public static double abs(ComplexNumber c) throws OutOfBoundException{
        Double var = c.getReal() * c.getReal() + c.getImaginary() * c.getImaginary();
        if (var.isNaN() || var.isInfinite())
            throw new OutOfBoundException();
        return sqrt(var);
    }

    /**
     *
     * @param c
     * @return
     * @throws OutOfBoundException
     */
    public static ComplexNumber squareRoot(ComplexNumber c) throws OutOfBoundException{
        Double real;
        Double imaginary;
        if (c.getImaginary() >= 0){
            real = sqrt( (abs(c) + c.getReal()) /2);
            imaginary = sqrt( (abs(c) - c.getReal()) /2);
        }
        else{
            real = - sqrt( (abs(c) + c.getReal()) /2);
            imaginary = sqrt( (abs(c) - c.getReal()) /2);
        }
        if(real.isInfinite() || imaginary.isInfinite())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);
    }
     
    //quali sono i casi limite?

    /**
     * <p> Invert the sign of the specified Complex Numbers values </p>
     * @param c the complex number to which the sign will be changed
     * @return a new Complex Number that is the result of the signInversion method on the Complex Number given
     */
    public static ComplexNumber signInversion(ComplexNumber c) {
        //Double real = c.getReal();
        //Double imaginary = c.getImaginary();
        return new ComplexNumber(-c.getReal(), -c.getImaginary());
    }

    /**
     * <p> Multiply the two specified Complex Numbers values </p>
     * @param c1 the first complex number to multiply
     * @param c2 the second complex number to multiply
     * @return a new complex number which is the result of multiplication between the two Complex Numbers given 
     * @throws OutOfBoundException if the value of any operand goes beyond the double threshold
     */
    public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) throws OutOfBoundException {
        Double real = c1.getReal() * c2.getReal() - (c1.getImaginary() * c2.getImaginary());
        Double imaginary = c1.getImaginary() * c2.getReal() + (c1.getReal() * c2.getImaginary());
        if(real.isNaN() || imaginary.isNaN())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * <p> Multiply the two specified Complex Numbers values </p>
     * @param @param c1 the first complex number to divide
     * @param c2 the second complex number to divide
     * @return a new complex number which is the result of division between the two Complex Numbers given 
     * @throws ArithmeticException if you are dividing by zero
     * @throws OutOfBoundException if the value of any operand goes beyond the double threshold
     */
    public static ComplexNumber division(ComplexNumber c1, ComplexNumber c2) throws ArithmeticException,OutOfBoundException {
        if (c2.getReal() == 0 && c2.getImaginary() == 0) {
            throw new ArithmeticException();
        }
        
        Double numeratorReal = c1.getReal() * c2.getReal() + c1.getImaginary() * c2.getImaginary();
        Double denominatorReal = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        Double numeratorImaginary = c1.getImaginary() * c2.getReal() - (c1.getReal() * c2.getImaginary());
        Double denominatorImaginary = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        
        if (numeratorReal.isNaN() || denominatorReal.isNaN() || numeratorImaginary.isNaN() || denominatorImaginary.isNaN()) 
            throw new OutOfBoundException();
       
        return new ComplexNumber(numeratorReal / denominatorReal, numeratorImaginary / denominatorImaginary);
    }

}
