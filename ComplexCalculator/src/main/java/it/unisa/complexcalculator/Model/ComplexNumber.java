package it.unisa.complexcalculator.Model;

/**
 * The istance of a <code>ComplexNumber</code> class represent a complex number
 * in cartesian notation. Provides all methods for working with complex numbers.
 * <ul>
 * <li><b>getReal</b> to get a <code>Double</code> that represent the real part
 * of a <code>ComplexNumber.</code></li>
 * <li><b>setReal</b> to set the real part of a <code>ComplexNumber</code>
 * passing a <code>Double</code>.</li>
 * <li><b>getImaginary</b> to get a <code>Double</code> that represent the
 * imaginary part of a <code>ComplexNumber.</code></li>
 * <li><b>setImaginary</b> to set the imaginary part of a
 * <code>ComplexNumber</code> passing a <code>Double</code>.</li>
 * <li><b>toString</b> to return the entire <code>ComplexNumber</code> as a
 * <code>String</code>.</li>
 * <li><b>parse</b> to parse a <code>String</code> and understand if it
 * represents a <code>ComplexNumber</code>.</li>
 * <li><b>equals</b> to verify the equality of two
 * <code>ComplexNumber</code>.</li>
 * </ul>
 *
 */
public class ComplexNumber {

    private double real;
    private double imaginary;

    /**
     * Constructor of the ComplexNumber class, it assigns the real part and the
     * imaginary part with the two double given as input
     *
     * @param real the double representing the real part of the complex
     * number
     * @param imaginary the double representing the imaginary part of the
     * complex number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;

    }

    /**
     * Returns the real part of the Complex Number
     *
     * @return the real part of the Complex Number
     */
    public double getReal() {

        return real;
    }

    /**
     * Sets the real part of the Complex Number with the new double given as
     * param
     *
     * @param real the double that will be replaced in place of the current one
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Returns the imaginary part of the Complex Number
     *
     * @return the imaginary part of the Complex Number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Sets the imaginary part of the Complex Number with the new double given
     * as param
     *
     * @param imaginary the double that will be replaced in place of the current
     * one
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * <p>
     * Returns a string that represent the Complex Number</p>
     *
     * @return a string representing the Complex Number
     */
    @Override
    public String toString() {
        if (imaginary >= 0.0) {
            return String.format("%.6f", real) + " + " + String.format("%.6f", imaginary) + "i";
        } else {
            return String.format("%.6f", real) + " - " + String.format("%.6f", -imaginary) + "i";
        }
    }

    /**
     * Takes a string as input and parses it, returns the corresponding Complex
     * Number, if it exists.
     *
     * <p>
     * Can throws NumberFormatException</p>
     *
     * @param input the string to parse
     * @return
     */
    public static ComplexNumber parse(String input) {
        double real = 0;
        double img = 0;

        String toAnalyze = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                if (i != 0) {
                    toAnalyze += ",";
                }
                toAnalyze += input.charAt(i);
            } else {
                toAnalyze += input.charAt(i);
            }
        }

        String[] splitted = toAnalyze.split(",");

        for (String s : splitted) {

            if (s.contains("i")) {
                img += Double.parseDouble(s.substring(0, s.length() - 1));
            } else {
                real += Double.parseDouble(s.substring(0, s.length()));
            }

        }
        return new ComplexNumber(real, img);
    }

    /**
     * Indicates whether the current object is "equal to" the one passed as
     * param.
     *
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
        return Double.doubleToLongBits(this.imaginary) == Double.doubleToLongBits(other.imaginary);

    }

}
