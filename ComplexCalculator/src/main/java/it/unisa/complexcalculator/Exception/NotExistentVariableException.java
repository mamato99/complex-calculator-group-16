/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Exception;

/**
 *
 * @author mdr
 */
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
