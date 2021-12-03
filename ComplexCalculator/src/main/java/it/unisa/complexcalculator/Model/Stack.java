/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.complexcalculator.Model;

/**
 *
 * @author Amministratore
 * @param <E>
 */
public interface Stack<E> {
    
    public void push(E n);
    public E pop();
    public E top();
}
