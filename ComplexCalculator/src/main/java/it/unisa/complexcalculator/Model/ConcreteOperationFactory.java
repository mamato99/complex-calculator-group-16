package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Memory.OperationMemory;
import it.unisa.complexcalculator.Model.Operation.VariableOperations.*;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.*;
import it.unisa.complexcalculator.Model.Operation.*;
import java.util.ArrayDeque;

/**
 * The istance of a <code>ConcreteOperationFactory</code> class represent the 
 * memory of a calculator. This memory contains a
 * stack abstraction in which it is possible to store instances of <code>ComplexNumbers</code> class representing 
 * complex numbers in cartesian notation. It allows to manipulate the stored numbers the following operations:
 * <ul>
 * <li><b>createCustomOperation</b> to identify and instantiate a series of operations indicated in the string.</li>
 * <li><b>createOperation</b> to identify and instantiate the operation indicated in the string.</li>
 * </ul>
 */

public class ConcreteOperationFactory implements OperationFactory {

    /**
     * Identifies and instantiates the operations indicated in the string.
     * @param name string that identifies the sequence of operations entered
     * @param sequence string of sequence of operations entered
     * @return new instance of <code>CustomOperation </code>
     */
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
    
    /**
     * Identifies and instantiates the operation indicated in the string.
     * @param s string that identifies the operation entered
     * @return the identified operation
     */
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

        return new PushOperation(ComplexNumber.parse(s));
           
    }
    
    
    //--------------------------------------PRIVATE METHODS------------------------------------------------
    /**
     * Identifies the operation indicated in the string. The operation is defined on a stack of <code>ComplexNumber</code>
     * @param s string that identifies the operation entered
     * @return the new instance of the respective extended <code>Operation</code>class
     */
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
    
    /**
     * Identifies the operation indicated in the string. The operation is defined on a stack of <code>Variable</code>.
     * @param s string that identifies the operation entered
     * @return the new instance of the respective extended <code>Operation</code>class
     */
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
        if (s.charAt(1) >= 'a' && s.charAt(1) <= 'z') {
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

    /**
     * Overwrites the operation with the same name if any and returns it, else return null.
     * @param s string that identifies the operations entered
     * @return the modified operation, else return null.
     */
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
