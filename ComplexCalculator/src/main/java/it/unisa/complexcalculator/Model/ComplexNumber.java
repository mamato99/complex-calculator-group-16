package it.unisa.complexcalculator.Model;

public class ComplexNumber {
    
    private double real;
    private double imaginary;

    /**
     * <p> Constructor of the ComplexNumber class it assigns the real part and the imaginary part with the two double given as input </p>
     * @param real the first double representing the real part of the complex number
     * @param imaginary the second double representing the imaginary part of the complex number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        
    }

    /**
     * <p> Constructor of the ComplexNumber class it assigns the real part with the double given as input and sets the imaginary part to zero </p>
     * @param real the double representing the real part of the complex number
     */
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    /**
     * <p> This method gets the real part of the Complex Number </p>
     * @return the real part of the Complex Number
     */
    public double getReal() {
        
        return real;
    }

    /**
     * <p> This method sets the real part of the Complex Number with a new double given </p> 
     * @param real the double that will be replaced in place of the current one
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * <p> This method gets the imaginary part of the Complex Number </p>
     * @return the imaginary part of the Complex Number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * <p> This method sets the iamginary part of the Complex Number with a new double given </p>
     * @param imaginary the double that will be replaced in place of the current one
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * <p> This method return a string that represent the Complex Number</p>
     * @return a string that represent the Complex Number
     */
    @Override
    public String toString() {
        if (imaginary >= 0.0)
            return String.format("%.6f", real) + " + " + String.format("%.6f", imaginary) + "i";
        else
            return String.format("%.6f", real) + " - " +String.format("%.6f", -imaginary) + "i";
    }

    /**
     * <p> Returns a hash code value for the object.</p> 
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.imaginary) ^ (Double.doubleToLongBits(this.imaginary) >>> 32));
        return hash;
        
        
    }

    /**
     * <p> Indicates whether some other object is "equal to" this one. </p>
     * @param obj the Object that will be compared with the current one 
     * @return true if the Object is equal to the current one otherwise false
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
