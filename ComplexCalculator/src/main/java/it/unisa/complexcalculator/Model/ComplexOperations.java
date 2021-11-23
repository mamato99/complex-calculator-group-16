/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model;

/**
 *
 * @author mdr
 */
public final class ComplexOperations {

   

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
