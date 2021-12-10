package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The istance of a <code>OperationInvoker</code> class represent the object
 * responsible for executing the Operations, and also have the duty of keeping a
 * record of the memories before the execution of an operation, in order to be
 * able to restore them in case of error during execution, thus preserving the
 * state of the memories.
 * <ul>
 * <li><b>execute</b> that execute an <code>Operation</code>.</li>
 * </ul>
 *
 */
public class OperationInvoker {

    private final ObservableList<ComplexNumber> oldMem;
    private final ObservableList<Variable> oldVars;

    /**
     * Constructor of the OperationInvoker class, it creates the support lists
     * to save and restore the state of the memories
     *
     */
    public OperationInvoker() {
        oldMem = FXCollections.observableArrayList();
        oldVars = FXCollections.observableArrayList();
    }

    /**
     * Executes the passed operation, taking care of saving the state of the
     * memories before the execution, and in case of error, restore them.
     *
     * @param op the <code>Operation</code> to execute
     */
    public void execute(Operation op) {
        save();
        try {
            op.execute();
        } catch (Exception ex) {
            restore();
            throw ex;
        }
    }

    /**
     * Saves the state of the memories
     */
    private void save() {
        NumberMemory numMem = NumberMemory.getNumberMemory();
        VariableMemory varMem = VariableMemory.getVariableMemory();
        oldMem.clear();
        for (ComplexNumber cmpx : numMem.getStack()) {
            oldMem.add(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }

        oldVars.clear();
        for (Variable var : varMem.getVars()) {
            oldVars.add(new Variable(var.getVar(), var.getValue()));
        }

    }

    /**
     * Restores the state of the memories
     */
    private void restore() {
        NumberMemory numMem = NumberMemory.getNumberMemory();
        VariableMemory varMem = VariableMemory.getVariableMemory();
        numMem.clear();
        for (ComplexNumber cmpx : oldMem) {
            numMem.push(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }

        varMem.clear();
        for (Variable var : oldVars) {
            varMem.addVariable(new Variable(var.getVar(), var.getValue()));
        }
    }
}
