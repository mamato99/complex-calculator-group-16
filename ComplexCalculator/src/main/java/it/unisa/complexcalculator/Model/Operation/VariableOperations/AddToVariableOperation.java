package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

/**
 * This class represent the "add to variable" operation of the calculator.
 * <p>
 * It contains an <code>execute()</code> method that performs the operation
 * manipulating the <code>NumberMemory</code> stack of complex numbers and the
 * variables stored in the <code>VariableMemory</code>.
 * </p>
 */
public class AddToVariableOperation implements Operation {

    private final Character c;

    /**
     * Constructor of AddToVariableOperation class
     * 
     * @param c the variable on which operate 
     */
    public AddToVariableOperation(Character c) {
        this.c = c;
    }

    /**
     * Takes the last stored complex numbers from the calculator number memory
     * and push sum it with value of the variable named as the Character c
     * passed.
     * <p>
     * Can throw NotEnoughOperandsException.
     * </p>
     */
    @Override
    public void execute() {
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        var.updateVariable(c, ComplexOperations.add(var.getVariable(c), num.pop()));
    }

}
