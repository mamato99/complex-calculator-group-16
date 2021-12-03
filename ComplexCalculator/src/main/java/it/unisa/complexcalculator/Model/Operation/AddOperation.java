/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;

public class AddOperation implements Operation{
    private final Calculator c;

    public AddOperation(Calculator c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        c.add();
    }
    
}
