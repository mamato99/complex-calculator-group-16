package it.unisa.complexcalculator.Model.Operation.CustomOperations;

import it.unisa.complexcalculator.Model.Operation.Operation;
import java.util.ArrayDeque;

public class CustomOperation extends Operation{
    private ArrayDeque<Operation> ops;
    private String name;
    private String sequence;

    public CustomOperation(String name, String sequence, ArrayDeque<Operation> ops) {
        this.name = name;
        this.sequence = sequence;
        this.ops = ops;
    }
    
    public void setOperations(ArrayDeque<Operation> ops){
        this.ops = ops;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    
    @Override
    public void execute() {
        for(Operation op : ops){
            op.execute();
        }
    }
}
