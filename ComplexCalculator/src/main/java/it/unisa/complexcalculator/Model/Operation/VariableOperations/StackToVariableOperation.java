package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

/**
 * This class represent the ">" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code> method that performs the operation manipulating the <code>NumberMemory</code> 
 * stack of complex numbers.
 * </p>
 */
public class StackToVariableOperation implements Operation {
    
    private final Character c;

    public StackToVariableOperation (Character c) {
        this.c = c;
    }

    /**
     * Takes the top element from the stack and saves it into the variable.
     */
    @Override
    public void execute() {
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        var.updateVariable(c, num.pop());
    }

}