package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OperationInvoker {
    
    private ObservableList<ComplexNumber> oldMem;
    private ObservableList<Variable> oldVars;
    private final Calculator c;

    public OperationInvoker(Calculator c){
        this.c = c;
        oldMem = FXCollections.observableArrayList();
        oldVars = FXCollections.observableArrayList();
    }
    
    public void execute(Operation op){
        
        save();
        try{
            op.execute();
        }catch(Exception ex){
            restore();
            throw ex;
        }
    }
    
    private void save(){
        oldMem.clear();
        for(ComplexNumber cmpx : c.getNumberList()){
            oldMem.add(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }
        
        oldVars.clear();
        for(Variable var : c.getVariableList()){
            oldVars.add(new Variable(var.getVar(), var.getValue()));
        }
        
    }
    
    private void restore(){
        c.getNumberList().clear();
        for(ComplexNumber cmpx : oldMem){
            c.getNumberList().add(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }
        
        c.getVariableList().clear();
        for(Variable var : oldVars){
            c.getVariableList().add(new Variable(var.getVar(), var.getValue()));
        }
    }
}