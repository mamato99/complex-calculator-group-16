package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Operation.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.StackOperation.*;
import it.unisa.complexcalculator.Model.Operation.VariableOperation.*;
import java.util.ArrayDeque;
import java.util.HashMap;

public class OperationMemory {

    private NumberMemory num;
    private VariableMemory var;
    private HashMap<String, Operation> ops;

    public OperationMemory(NumberMemory num, VariableMemory var) {
        ops = new HashMap<>();
        this.num = num;
        this.var = var;
    }

    public Operation createOperation(String s) {
        Operation op;

        op = parseStackOperation(s);
        if (op != null) 
            return op;

        op = parseVariableOperation(s);
        if (op != null)
            return op;
        
        op = parseCustomOperation(s);
        if (op != null)
            return op;
        
        return new PushOperation(num, ComplexNumber.parse(s));
    }
    
    public void addOperation(String name, String sequence){
        String[] op = sequence.split(" ");

        ArrayDeque<Operation> custom = new ArrayDeque<>();

        for (String s : op) {
            Operation o = createOperation(s);
            if (o == null) {
                return;
            }
            custom.add(o);
        }

        ops.put(name, new CustomOperation(custom));
    }
    
    private Operation parseStackOperation(String s) {
        switch (s) {
            case "dup":
                return new DupOperation(num);
            case "clear":
                return new ClearOperation(num);
            case "swap":
                return new SwapOperation(num);
            case "drop":
                return new DropOperation(num);
            case "over":
                return new OverOperation(num);
            case "+":
                return new AddOperation(num);
            case "-":
                return new SubtractOperation(num);
            case "*":
                return new MultiplyOperation(num);
            case "/":
                return new DivideOperation(num);
            case "sqrt":
                return new SqrtOperation(num);
            case "+-":
                return new InvertSignOperation(num);
            default:
                return null;
        }
    }

    private Operation parseVariableOperation(String s) {
        if (s.length() != 2 || !((s.startsWith(">") || s.startsWith("<") || s.startsWith("+") || s.startsWith("-"))))
            return null;

        //UPPERCASE TO AVOID "i" as imaginary part
        if (s.charAt(1) >= 'A' && s.charAt(1) <= 'Z') {
            switch (s.charAt(0)) {
                case '<':
                    return new VariableToStackOperation(num, var, s.charAt(1));
                case '>':
                    return new StackToVariableOperation(num, var, s.charAt(1));
                case '+':
                    return new AddToVariableOperation(num, var, s.charAt(1));
                case '-':
                    return new SubtractToVariableOperation(num, var, s.charAt(1));
                default: 
                    return null;
            }
        }
        
        return null;
    }
    
    private Operation parseCustomOperation(String s) {
        if (ops.get(s) != null)
            return ops.get(s);
        return null;
    }
}
