/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Exception;

/**
 *
 * @author mdr
 */
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
