package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Exception.NotEnoughOperandsException;

public class Calculator {

    private final NumberMemory storedNumbers;

    /**
     * <p>
     * Constructor of the Calculator class</p>
     */
    public Calculator() {
        storedNumbers = new NumberMemory();
    }

    /**
     * <p>
     * This method returns the numbers saved.</p>
     *
     * @return
     * <p>
     * the complex numbers in cartesian notation saved.</p>
     */
    public NumberMemory getStoredNumbers() {
        return storedNumbers;
    }

    /**
     * <p>
     * This method saves the number <code>real</code> and <code>img</code> into the data structure containing the stored complex numbers.</p>
     *
     * @param real represents the real number to be entered
     * @param img represents the imaginary number to be entered
     */
    public void pushNumber(double real, double img) {
        storedNumbers.push(new ComplexNumber(real, img));
    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and adds them together </p>
     */
    public void add() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.add(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and subtracts them together </p>
     */
    public void subtract() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.difference(c1, c2);
        storedNumbers.push(result);
    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and divides them together </p>
     */
    public void divide() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.division(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last two numbers saved on the stack and multiplies them together </p>
     */
    public void multiply() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.multiplication(c1, c2);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last number saved on the stack and reverses its sign </p>
     */
    public void invertSign() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.signInversion(c1);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last number saved on the stack and calculates the square root</p>
     */
    public void squareRoot() {
        if (storedNumbers.len() < 1) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber result = ComplexOperations.squareRoot(c1);
        storedNumbers.push(result);

    }

    /**
     * <p>
     * This method takes the last two numbers saved in the stack and swaps them.</p>
     */
    public void swap() {
        if (storedNumbers.len() < 2) {
            throw new NotEnoughOperandsException();
        }
        ComplexNumber c1 = storedNumbers.pop();
        ComplexNumber c2 = storedNumbers.pop();

        storedNumbers.push(c1);
        storedNumbers.push(c2);

    }
}
