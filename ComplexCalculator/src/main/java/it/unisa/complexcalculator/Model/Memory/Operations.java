package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.Operation.Operation;
import java.util.ArrayDeque;


public class Operations {
    private String name;
    private String sequence;
    private Operation op;

    public Operations(String name, String sequence, Operation op) {
        this.name = name;
        this.sequence = sequence;
        this.op = op;
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

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }
    
    
}
