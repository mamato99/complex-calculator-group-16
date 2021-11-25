package it.unisa.complexcalculator.Exception;

/**
 *
 * @author super
 */
public class MinimumBoundException  extends RuntimeException{

    /**
     * Creates a new instance of <code>MinimumBoundException</code> without
     * detail message.
     */
    public MinimumBoundException() {
    }

    /**
     * Constructs an instance of <code>MinimumBoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MinimumBoundException(String msg) {
        super(msg);
    }
}
