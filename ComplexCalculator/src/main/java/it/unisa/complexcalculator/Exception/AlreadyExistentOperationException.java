/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Exception;

/**
 *
 * @author mdr
 */
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
