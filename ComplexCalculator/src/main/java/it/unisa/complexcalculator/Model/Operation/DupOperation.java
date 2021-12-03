/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;

/**
 *
 * @author mdr
 */
public class DupOperation implements Operation{
    private Calculator c;

    public DupOperation(Calculator c) {
        this.c = c;
    }
    
    
    @Override
    public void execute() {
        c.dup();
    }
}
