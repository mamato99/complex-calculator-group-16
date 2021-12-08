package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VariableMemory {
    private ObservableList<Variable> vars;

    public VariableMemory() {
        vars = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'Z'; c++) {
            vars.add(new Variable(c, new ComplexNumber(0, 0)));
        }
    }
    
    public void addVariable(Character c, ComplexNumber n){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                v.setValue(n);       
        }
    }
    
    public void pushVariable(Variable var){
        vars.add(var);
    }
    
    public ComplexNumber getVariable(Character c){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                return v.getValue();
            
        }
        return null;
    }

    public ObservableList<Variable> getVars() {
        return vars;
    }

    public void setVars(ObservableList<Variable> vars) {
        this.vars = vars;
    }
    
    public List<Variable> getVarsAsList(){
        List<Variable> retVal = new ArrayList<>();
        for (Variable var : vars){
            retVal.add(new Variable(var.getVar(), var.getValue()));
        }
        return retVal;
    }
    
    public void setVarsFromList(List<Variable> numbers){
        vars.clear();
        for (Variable var : numbers){
            pushVariable(new Variable(var.getVar(), var.getValue()));
            
        }
    }
    
}
