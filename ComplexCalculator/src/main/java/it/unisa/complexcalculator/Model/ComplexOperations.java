package it.unisa.complexcalculator.Model;


import it.unisa.complexcalculator.Exception.OutOfBoundException;
import static java.lang.Math.sqrt;

/**
 *
 * @author mdr
 */
public final class ComplexOperations {

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
    }

    public static ComplexNumber difference(ComplexNumber c1, ComplexNumber c2) {
        return new ComplexNumber(c1.getReal() - c2.getReal(), c1.getImaginary() - c2.getImaginary());
    }

    public static double abs(ComplexNumber c) {
        double var = c.getReal() * c.getReal() + c.getImaginary() * c.getImaginary();
        double modulo = sqrt(var);
        return modulo;
    }

    public static ComplexNumber squareRoot(ComplexNumber c) {
        double a1;
        double b1;
        if (c.getImaginary() > 0) {
            a1 = sqrt((abs(c) + c.getReal()) / 2);
            b1 = sqrt((abs(c) - c.getReal()) / 2);
        } else {
            a1 = -sqrt((abs(c) + c.getReal()) / 2);
            b1 = sqrt((abs(c) - c.getReal()) / 2);
        }
        return new ComplexNumber(a1, b1);
    }

    public static ComplexNumber signInversion(ComplexNumber c) {
        return new ComplexNumber(-c.getReal(), -c.getImaginary());
    }

    public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) throws OutOfBoundException {
        Double real = c1.getReal() * c2.getReal() - (c1.getImaginary() * c2.getImaginary());
        Double imaginary = c1.getImaginary() * c2.getReal() + (c1.getReal() * c2.getImaginary());
        if(real.isNaN() || imaginary.isNaN())
            throw new OutOfBoundException();
        return new ComplexNumber(real, imaginary);
    }

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
