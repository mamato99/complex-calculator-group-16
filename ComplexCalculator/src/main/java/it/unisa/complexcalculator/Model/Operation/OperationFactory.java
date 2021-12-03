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
public class OperationFactory {
    
    public static Operation parseOperation(String s, Calculator c){
        switch(s){
            case "dup": return new DupOperation(c);
            case "clear": return new ClearOperation(c);
            case "swap": return new SwapOperation(c);
            case "drop": return new DropOperation(c);
            case "over": return new OverOperation(c);
            case "+": return new AddOperation(c);
            case "-": return new SubtractOperation(c);
            case "*": return new MultiplyOperation(c);
            case "/": return new DivideOperation(c);
            case "sqrt": return new SqrtOperation(c);
            case "+-": return new InvertSignOperation(c);
            default: return null;
        }
    }
    
}
