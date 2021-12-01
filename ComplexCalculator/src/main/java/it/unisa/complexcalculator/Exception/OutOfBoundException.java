package it.unisa.complexcalculator.Exception;

public class OutOfBoundException extends RuntimeException{

    /**
     * Creates a new instance of <code>OutOfBoundException</code> without detail
     * message.
     */
    public OutOfBoundException() {
    }

    /**
     * Constructs an instance of <code>OutOfBoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OutOfBoundException(String msg) {
        super(msg);
    }
}
