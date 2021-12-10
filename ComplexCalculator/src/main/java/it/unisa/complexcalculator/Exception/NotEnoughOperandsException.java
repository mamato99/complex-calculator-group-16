package it.unisa.complexcalculator.Exception;

public class NotEnoughOperandsException extends RuntimeException{
    /**
     * Creates a new instance of <code>NotEnoughOperandsException</code> without detail
     * message.
     */
    public NotEnoughOperandsException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughOperandsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughOperandsException(String msg) {
        super(msg);
    }
}
