
package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;

public class Variable {
    private Character var;
    private ComplexNumber value;

    public Variable(Character var, ComplexNumber value) {
        this.var = var;
        this.value = value;
    }

    public Character getVar() {
        return var;
    }

    public void setVar(Character var) {
        this.var = var;
    }

    public ComplexNumber getValue() {
        return value;
    }

    public void setValue(ComplexNumber value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Variable{" + "var=" + var + ", value=" + value + '}';
    }
    
    
}
