/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Operation.StackOperation.OverOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.SqrtOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.SubtractOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.SwapOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.MultiplyOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DivideOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DropOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.ClearOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.DupOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.InvertSignOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.AddOperation;
import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.OperationFactory;

/**
 *
 * @author mdr
 */
public class StackOperationFactory implements OperationFactory{
    
    @Override
    public Operation parseOperation(String s, Calculator c){
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
