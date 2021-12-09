package it.unisa.complexcalculator.Exception;

public class ReferencedOperationException extends RuntimeException{

    /**
     * Creates a new instance of <code>ReferencedOperationException</code> without detail
     * message.
     */
    public ReferencedOperationException() {
    }

    /**
     * Constructs an instance of <code>ReferencedOperationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ReferencedOperationException(String msg) {
        super(msg);
    }
}