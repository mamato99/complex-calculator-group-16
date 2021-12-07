package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.HashMap;

public class VariableMemory {
    private final HashMap<Character, ComplexNumber> var;

    public VariableMemory() {
        var = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            var.put(c, new ComplexNumber(0, 0));
        }
    }
    
    public void addVariable(Character c, ComplexNumber n){
        var.put(c, n);
    }
    
    public ComplexNumber getVariable(Character c){
        return var.get(c);
    }
}
