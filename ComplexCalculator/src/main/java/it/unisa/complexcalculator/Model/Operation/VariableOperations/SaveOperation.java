package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;

public class SaveOperation extends Operation {

    private final VariableMemory varMem;

    public SaveOperation() {
        this.varMem = VariableMemory.getVariableMemory();
    }

    @Override
    public void execute() {
        varMem.saveVariableState();
    }

}
