/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 *
 * @author mdr
 */
public class InvertSignOperation implements Operation{
    private Calculator c;

    public InvertSignOperation(Calculator c) {
        this.c = c;
    }
    
    @Override
    public void execute() {
        c.invertSign();
    }
}
