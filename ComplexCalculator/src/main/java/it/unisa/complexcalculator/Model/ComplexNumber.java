package it.unisa.complexcalculator.Model;

/**
 *
 * @author mdr
 */
public class ComplexNumber {
    
    private double real;
    private double imaginary;

    /**
     *
     * @param real
     * @param imaginary
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     *
     * @param real
     */
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    /**
     *
     * @return
     */
    public double getReal() {
        return real;
    }

    /**
     *
     * @param real
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     *
     * @return
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     *
     * @param imaginary
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (this.imaginary >= new Double(0))
            return String.format("%.2f", real) + " + " + String.format("%.2f", imaginary) + "i";
        else
            return String.format("%.2f", real) + " - " + String.format("%.2f", -imaginary) + "i";
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.imaginary) ^ (Double.doubleToLongBits(this.imaginary) >>> 32));
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginary) != Double.doubleToLongBits(other.imaginary)) {
            return false;
        }
        return true;
    }
    
    
    
}
