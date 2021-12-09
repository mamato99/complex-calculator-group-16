package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.OperationMemory;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.*;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.*;
import it.unisa.complexcalculator.Model.Operation.*;
import java.util.ArrayDeque;

public class Calculator implements OperationFactory {

    @Override
    public CustomOperation createCustomOperation(String name, String sequence) {
        String[] ops = sequence.split(" ");

        ArrayDeque<Operation> custom = new ArrayDeque<>();

        for (String s : ops) {
            Operation o = createOperation(s);
            custom.add(o);
        }

        return new CustomOperation(name, sequence, custom);
    }
    
    @Override
    public Operation createOperation(String s) {
        Operation op;

        op = parseStackOperation(s);
        if (op != null) {
            return op;
        }

        op = parseVariableOperation(s);
        if (op != null) {
            return op;
        }

        op = parseCustomOperation(s);
        if (op != null) {
            return op;
        }

        try {
            op = new PushOperation(ComplexNumber.parse(s));
            return op;
        } catch (NumberFormatException ex) {
            return null;
        }

    }

    
    //--------------------------------------PRIVATE METHODS------------------------------------------------
    private Operation parseStackOperation(String s) {
        switch (s) {
            case "dup":
                return new DupOperation();
            case "clear":
                return new ClearOperation();
            case "swap":
                return new SwapOperation();
            case "drop":
                return new DropOperation();
            case "over":
                return new OverOperation();
            case "+":
                return new AddOperation();
            case "-":
                return new SubtractOperation();
            case "*":
                return new MultiplyOperation();
            case "/":
                return new DivideOperation();
            case "sqrt":
                return new SqrtOperation();
            case "+-":
                return new InvertSignOperation();
            default:
                return null;
        }
    }
    
    private Operation parseVariableOperation(String s) {
        switch (s) {
            case "save":
                return new SaveOperation();
            case "restore":
                return new RestoreOperation();
        }
        if (s.length() != 2 || !((s.startsWith(">") || s.startsWith("<") || s.startsWith("+") || s.startsWith("-")))) {
            return null;
        }

        //UPPERCASE TO AVOID "i" as imaginary part
        if (s.charAt(1) >= 'A' && s.charAt(1) <= 'Z') {
            switch (s.charAt(0)) {
                case '<':
                    return new VariableToStackOperation(s.charAt(1));
                case '>':
                    return new StackToVariableOperation(s.charAt(1));
                case '+':
                    return new AddToVariableOperation(s.charAt(1));
                case '-':
                    return new SubtractToVariableOperation(s.charAt(1));
                default:
                    return null;
            }
        }

        return null;
    }

    private CustomOperation parseCustomOperation(String s) {
        OperationMemory opMem = OperationMemory.getOperationMemory();
        CustomOperation op = opMem.getCustomOperation(s);
        if (op != null) {
            op = createCustomOperation(op.getName(), op.getSequence()); 
            return op;
        }
        return null;
    }
}
