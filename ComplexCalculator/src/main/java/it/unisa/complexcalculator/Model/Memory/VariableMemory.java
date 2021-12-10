package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VariableMemory {
    private ObservableList<Variable> vars;
    private final ArrayDeque<ObservableList<Variable>> varStack;
    private static VariableMemory instance = null;

    public static VariableMemory getVariableMemory() {
        if(instance == null)
            instance = new VariableMemory();
        return instance;
    }
    
    private VariableMemory() {
        vars = FXCollections.observableArrayList();
        for (char c = 'A'; c <= 'Z'; c++) {
            vars.add(new Variable(c, new ComplexNumber(0, 0)));
        }
        varStack = new ArrayDeque<>();
    }

    public ObservableList<Variable> getVars() {
        return vars;
    }
    
    public void updateVariable(Character c, ComplexNumber n){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                v.setValue(n);       
        }
    }
    
    public void clear(){
        vars.clear();
    }
    
    public void addVariable(Variable var){
        vars.add(var);
    }
    
    public ComplexNumber getVariable(Character c){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                return v.getValue();
            
        }
        return null;
    }

    public void saveVariableState(){
        ObservableList<Variable> toSave = FXCollections.observableArrayList();
        for(Variable var : vars)
            toSave.add(new Variable(var.getVar(), var.getValue()));
        varStack.push(toSave);
    }
    
    public void loadVariableState(){
        for(Variable v : varStack.pop()){
            updateVariable(v.getVar(), v.getValue());
        }
    }
}
