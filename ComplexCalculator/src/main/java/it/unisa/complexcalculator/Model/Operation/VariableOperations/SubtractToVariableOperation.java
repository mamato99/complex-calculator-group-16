package it.unisa.complexcalculator.Model.Operation.VariableOperations;

import it.unisa.complexcalculator.Model.ComplexOperations;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;

/**
 * This class represent the "subtract to variable" operation of the calculator. 
 * <p>
 * It contains an <code>execute()</code>
 * method that takes the complex number at the top of the <code>NumberMemory</code> stack of complex numbers and
 * pushes it into the variable identified by the key stored in the <code>Caracter</code> instance variable.
 * </p>
 */
public class SubtractToVariableOperation implements Operation {

    private final Character c;

    /**
     * The <code>SubtractToVariableOperation</code> constructor.
     * @param c the Character which identifies the variable that this instance of a subtract to variable operation
     * will manipulate.
    */
    public SubtractToVariableOperation(Character c) {
        this.c = c;
    }
    
    /**
     * Takes the complex number at the top of the stored numbers and subtract it from the variable
     * identified by the character of the instance variable of this object.
     * <p>
     * Can throw OutOfBoundException.
     * </p>
     */
    @Override
    public void execute() {
        NumberMemory num = NumberMemory.getNumberMemory();
        VariableMemory var = VariableMemory.getVariableMemory();
        var.updateVariable(c, ComplexOperations.difference(var.getVariable(c), num.pop()));
    }
    
}
