/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amministratore
 * @param <ComplexNumber>
 */
public class NumberMemory<ComplexNumber>{
    
    private final ObservableList<ComplexNumber> stack;
    private int len;

    public NumberMemory() {
        stack = FXCollections.observableArrayList();
        len = 0;
    }
    
    public void push(ComplexNumber n){
        stack.add(0, n);
        len++;
    }
    
    public ComplexNumber pop(){
        if (len > 0)
            return stack.remove(0);
        return null;
    }
    
    public ComplexNumber top(){
        if (len > 0)
            return stack.get(0);
        return null;
    }
    
    public int len(){
        return len;
    }
    
    public ObservableList<ComplexNumber> getStack() {
        return stack;
    }
    
}
