
package it.unisa.complexcalculator.Model.Operation.StackOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.OperationFactory;


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
