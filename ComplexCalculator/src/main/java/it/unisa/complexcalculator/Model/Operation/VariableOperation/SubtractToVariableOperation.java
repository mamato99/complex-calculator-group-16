/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;

/**
 *
 * @author mdr
 */
public class SubtractToVariableOperation implements Operation {
    Calculator c;
    Character var;

    public SubtractToVariableOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    @Override
    public void execute() {
        c.subtractToVariable(var);
    }
    
}
