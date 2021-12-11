package it.unisa.complexcalculator.Exception;

public class NotExistentVariableException extends RuntimeException{

    /**
     * Creates a new instance of <code>NotExistentVariableException</code> without detail
     * message.
     */
    public NotExistentVariableException() {
    }

    /**
     * Constructs an instance of <code>NotExistentVariableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistentVariableException(String msg) {
        super(msg);
    }
}
