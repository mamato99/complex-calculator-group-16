package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Operation.VariableOperations.*;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.StackOperations.*;
import it.unisa.complexcalculator.Model.Memory.*;
import it.unisa.complexcalculator.Model.Operation.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayDeque;

public class Calculator {

    private NumberMemory numbers;
    private VariableMemory variables;
    private OperationMemory operations;
    private VariableStack varStack;

    public Calculator() {
        numbers = new NumberMemory();
        variables = new VariableMemory();
        operations = new OperationMemory();
        varStack = new VariableStack();
    }

    public NumberMemory getNumbers() {
        return numbers;
    }

    public void setNumbers(NumberMemory numbers) {
        this.numbers = numbers;
    }

    public VariableMemory getVariables() {
        return variables;
    }

    public void setVariables(VariableMemory variables) {
        this.variables = variables;
    }

    public OperationMemory getOperations() {
        return operations;
    }

    public void setOperations(OperationMemory operations) {
        this.operations = operations;
    }

    public void removeCustomOperation(CustomOperation op) {
        operations.removeCustomOperationFromMemory(op);
    }

    public Operation parseOperation(String s) {
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

        return new PushOperation(numbers, ComplexNumber.parse(s));
    }

    public CustomOperation sequenceToOperation(String name, String sequence) {
        String[] ops = sequence.split(" ");

        ArrayDeque<Operation> custom = new ArrayDeque<>();

        for (String s : ops) {
            Operation o = parseOperation(s);
            custom.add(o);
        }

        return new CustomOperation(name, sequence, custom);
    }

    public void addCustomOperation(String name, String sequence) {
        CustomOperation op = sequenceToOperation(name, sequence);
        operations.addCustomToOperationMemory(op);
    }

    public void save(String file) throws FileNotFoundException, IOException {
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        dout.writeInt(getOperations().getOps().size());

        for (CustomOperation op : getOperations().getOps()) {
            String toWrite = op.getName() + ":" + op.getSequence();
            dout.writeUTF(toWrite);
        }
        dout.flush();
        dout.close();
    }

    public void load(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int n = din.readInt();
        getOperations().getOps().clear();

        String token;

        for (int i = 0; i < n; i++) {
            token = din.readUTF();
            getOperations().getOps().add(new CustomOperation(token.split(":")[0], token.split(":")[1], null)); // Null because before invoking it, the calculator populates the arraydeque of operations
        }

    }

    public void refreshSequences(String oldName, String newName) {
        operations.refreshSequences(oldName, newName);
    }

    private Operation parseStackOperation(String s) {
        switch (s) {
            case "dup":
                return new DupOperation(numbers);
            case "clear":
                return new ClearOperation(numbers);
            case "swap":
                return new SwapOperation(numbers);
            case "drop":
                return new DropOperation(numbers);
            case "over":
                return new OverOperation(numbers);
            case "+":
                return new AddOperation(numbers);
            case "-":
                return new SubtractOperation(numbers);
            case "*":
                return new MultiplyOperation(numbers);
            case "/":
                return new DivideOperation(numbers);
            case "sqrt":
                return new SqrtOperation(numbers);
            case "+-":
                return new InvertSignOperation(numbers);
            default:
                return null;
        }
    }

    private Operation parseVariableOperation(String s) {
        switch (s) {
            case "save":
                return new SaveOperation(variables, varStack);
            case "restore":
                return new RestoreOperation(variables, varStack);
        }
        if (s.length() != 2 || !((s.startsWith(">") || s.startsWith("<") || s.startsWith("+") || s.startsWith("-")))) {
            return null;
        }

        //UPPERCASE TO AVOID "i" as imaginary part
        if (s.charAt(1) >= 'A' && s.charAt(1) <= 'Z') {
            switch (s.charAt(0)) {
                case '<':
                    return new VariableToStackOperation(numbers, variables, s.charAt(1));
                case '>':
                    return new StackToVariableOperation(numbers, variables, s.charAt(1));
                case '+':
                    return new AddToVariableOperation(numbers, variables, s.charAt(1));
                case '-':
                    return new SubtractToVariableOperation(numbers, variables, s.charAt(1));
                default:
                    return null;
            }
        }

        return null;
    }

    private CustomOperation parseCustomOperation(String s) {
        CustomOperation op = operations.getCustomOperation(s);
        if (op != null) {
            op = sequenceToOperation(op.getName(), op.getSequence()); // UPDATE SEQUENCE OF OPERATIONS
            return op;
        }
        return null;
    }

}
