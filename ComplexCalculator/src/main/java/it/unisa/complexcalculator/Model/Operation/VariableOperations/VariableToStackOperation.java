package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

/**
 * This class represent the "variable to stack" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code>
 * method that takes the value of the variable identified by the instance variable key <code>c</code>
 * and pushes it at the top of the <code>NumberMemory</code> stack of complex numbers.
 * </p>
 */
public class VariableToStackOperation implements Operation {

    private final Character c;

    /**
     * The <code>VariableToStackOperation</code> constructor.
     * @param c the Character which identifies the variable that this instance of a variable to stack operation
     * will manipulate.
    */
    public VariableToStackOperation(Character c) {
        this.c = c;
    }
    
    /**
     * Takes the value of the variable identified by the instance variable <code>c</code>
     * and pushes it at the top of the stored numbers stack.
     */
    @Override
    public void execute() {       
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        num.push(var.getVariable(c));
    }
    
}
