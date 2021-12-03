/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;

/**
 *
 * @author mdr
 */
public interface OperationFactory {
    
    /**
     *
     * @param s
     * @param c
     * @return
     */
    public Operation parseOperation(String s, Calculator c);
}
