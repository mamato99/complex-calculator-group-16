package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VariableMemory {
    private ObservableList<Variables> vars;

    public VariableMemory() {
        vars = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'Z'; c++) {
            vars.add(new Variables(c, new ComplexNumber(0, 0)));
        }
    }
    
    public void addVariable(Character c, ComplexNumber n){
        for (Variables v : vars){
            if (v.getVar().equals(c))
                v.setValue(n);       
        }
    }
    
    public ComplexNumber getVariable(Character c){
        for (Variables v : vars){
            if (v.getVar().equals(c))
                return v.getValue();
            
        }
        return null;
    }

    public ObservableList<Variables> getVars() {
        return vars;
    }

    public void setVars(ObservableList<Variables> vars) {
        this.vars = vars;
    }
    
    
    
}
