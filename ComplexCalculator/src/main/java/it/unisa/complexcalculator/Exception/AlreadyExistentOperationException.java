package it.unisa.complexcalculator.Exception;

public class AlreadyExistentOperationException extends RuntimeException{
    /**
     * Creates a new instance of <code>AlreadyExistentOperationException</code> without detail
     * message.
     */
    public AlreadyExistentOperationException() {
    }

    /**
     * Constructs an instance of <code>AlreadyExistentOperationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyExistentOperationException(String msg) {
        super(msg);
    }
}
