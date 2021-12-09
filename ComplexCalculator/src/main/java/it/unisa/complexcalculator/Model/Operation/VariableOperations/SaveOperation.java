package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import it.unisa.complexcalculator.Model.Memory.VariableStack;
import it.unisa.complexcalculator.Model.Operation.Operation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SaveOperation extends Operation {

    private final VariableMemory varMem;
    private ObservableList<Variable> toSave;
    private final VariableStack varStack;

    public SaveOperation(VariableMemory varMem, VariableStack varStack) {
        this.varMem = varMem;
        this.varStack = varStack;
        toSave = FXCollections.observableArrayList();
    }

    @Override
    public void execute() {
        toSave.clear();
        for(Variable var : varMem.getVars())
            toSave.add(new Variable(var.getVar(), var.getValue()));
        varStack.push(toSave); 
    }

}
