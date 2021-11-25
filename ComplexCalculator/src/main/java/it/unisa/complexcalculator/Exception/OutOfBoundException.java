/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.complexcalculator.Exception;

/**
 *
 * @author super
 */
public class OutOfBoundException extends RuntimeException{

    /**
     * Creates a new instance of <code>UpperBoundException</code> without detail
     * message.
     */
    public OutOfBoundException() {
    }

    /**
     * Constructs an instance of <code>UpperBoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OutOfBoundException(String msg) {
        super(msg);
    }
}
