/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model;

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
        double var = c.getReal()*c.getReal() + c.getImaginary()*c.getImaginary();
        double modulo = sqrt(var);
        return modulo;
    }
    
    public static ComplexNumber sqrtComplex(ComplexNumber c) {
        double a1;
        double b1;
        if (c.getImaginary() > 0){
            a1 = sqrt( (abs(c) + c.getReal()) /2);
            b1 = sqrt( (abs(c) - c.getReal()) /2);
        }
        else{
            a1 = - sqrt( (abs(c) + c.getReal()) /2);
            b1 = sqrt( (abs(c) - c.getReal()) /2);
        }
        return new ComplexNumber(a1, b1);
    }
        
    public static ComplexNumber invertSign(ComplexNumber c) {
        return new ComplexNumber(-c.getReal(), -c.getImaginary());
    }

    public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
        double real = 0;
        double imaginary = 0;
        real = c1.getReal() * c2.getReal() - (c1.getImaginary() * c2.getImaginary());
        imaginary = c1.getImaginary() * c2.getReal() + (c1.getReal() * c2.getImaginary());
        return new ComplexNumber(real, imaginary);
    }

    public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) throws RuntimeException {
        if (c2.getReal() == 0 && c2.getImaginary() == 0) {
            return new ComplexNumber(0,0) ;
        }
        double numeratorReal = 0;
        double denominatorReal = 0;
        double numeratorImaginary = 0;
        double denominatorImaginary = 0;
        numeratorReal = c1.getReal() * c2.getReal() + c1.getImaginary() * c2.getImaginary();
        denominatorReal = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        numeratorImaginary = c1.getImaginary() * c2.getReal() - (c1.getReal() * c2.getImaginary());
        denominatorImaginary = c2.getReal() * c2.getReal() + c2.getImaginary() * c2.getImaginary();
        return new ComplexNumber(numeratorReal / denominatorReal, numeratorImaginary / denominatorImaginary);
    }
    
}
