package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Exception.MinimumBoundException;
import it.unisa.complexcalculator.Exception.UpperBoundException;
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

    public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) throws UpperBoundException,MinimumBoundException {
        if ((c1.getReal() == Double.MAX_VALUE || c1.getImaginary() == Double.MAX_VALUE || c2.getReal() == Double.MAX_VALUE || c2.getImaginary() == Double.MAX_VALUE && c1.getReal() > 1) && c1.getReal()!= Double.MAX_VALUE)  {
            throw new UpperBoundException();
        }
        if ((c1.getReal() == Double.MAX_VALUE || c1.getImaginary() == Double.MAX_VALUE || c2.getReal() == Double.MAX_VALUE || c2.getImaginary() == Double.MAX_VALUE) && c1.getImaginary() > 1 && c1.getImaginary()!= Double.MAX_VALUE)  {
            throw new UpperBoundException();
        }
        if ((c1.getReal() == Double.MAX_VALUE || c1.getImaginary() == Double.MAX_VALUE || c2.getReal() == Double.MAX_VALUE || c2.getImaginary() == Double.MAX_VALUE) && c2.getReal() > 1 && c2.getReal() != Double.MAX_VALUE)  {
            throw new UpperBoundException();
        }
        if ((c1.getReal() == Double.MAX_VALUE || c1.getImaginary() == Double.MAX_VALUE || c2.getReal() == Double.MAX_VALUE || c2.getImaginary() == Double.MAX_VALUE) && c2.getImaginary() > 1 && c2.getImaginary() != Double.MAX_VALUE)  {
            throw new UpperBoundException();
        }
         if (c1.getReal() == Double.MIN_VALUE || c1.getImaginary() == Double.MIN_VALUE || c2.getReal() == Double.MIN_VALUE || c2.getImaginary() == Double.MIN_VALUE) {
            throw new MinimumBoundException();
        }
        double real = c1.getReal() * c2.getReal() - (c1.getImaginary() * c2.getImaginary());
        double imaginary = c1.getImaginary() * c2.getReal() + (c1.getReal() * c2.getImaginary());
        return new ComplexNumber(real, imaginary);
    }

    public static ComplexNumber division(ComplexNumber c1, ComplexNumber c2) throws ArithmeticException {
        if (c2.getReal() == 0 && c2.getImaginary() == 0) {
            throw new ArithmeticException();
        }
        double numeratorReal;
        double denominatorReal;
        double numeratorImaginary;
        double denominatorImaginary;
        
        numeratorReal = c1.getReal() * c2.getReal() + c1.getImaginary() * c2.getImaginary();
        denominatorReal = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        numeratorImaginary = c1.getImaginary() * c2.getReal() - (c1.getReal() * c2.getImaginary());
        denominatorImaginary = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        return new ComplexNumber(numeratorReal / denominatorReal, numeratorImaginary / denominatorImaginary);
    }

}
