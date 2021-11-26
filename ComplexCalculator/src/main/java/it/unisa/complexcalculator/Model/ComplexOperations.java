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
     *
     * @param c
     * @return
     */
    public static ComplexNumber signInversion(ComplexNumber c) {
        //Double real = c.getReal();
        //Double imaginary = c.getImaginary();
        return new ComplexNumber(-c.getReal(), -c.getImaginary());
    }

    /**
     *
     * @param c1
     * @param c2
     * @return
     * @throws OutOfBoundException
     */
    public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) throws OutOfBoundException {
        Double real = c1.getReal() * c2.getReal() - (c1.getImaginary() * c2.getImaginary());
        Double imaginary = c1.getImaginary() * c2.getReal() + (c1.getReal() * c2.getImaginary());
        if(real.isNaN() || imaginary.isNaN())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);
    }

    /**
     *
     * @param c1
     * @param c2
     * @return
     * @throws ArithmeticException
     * @throws OutOfBoundException
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
