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
public class StackToVariableOperation implements Operation {
    private Calculator c;
    private Character var;

    public StackToVariableOperation(Character var, Calculator c) {
        this.c = c;
        this.var = var;
    }
    
    @Override
    public void execute() {
        c.stackToVariable(var);
    }
    
}
