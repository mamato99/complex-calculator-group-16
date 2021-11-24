/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
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
