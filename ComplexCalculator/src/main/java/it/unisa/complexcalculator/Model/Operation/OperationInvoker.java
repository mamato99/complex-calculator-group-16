package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.NumberMemory;
import it.unisa.complexcalculator.Model.Memory.Variable;
import it.unisa.complexcalculator.Model.Memory.VariableMemory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OperationInvoker {
    
    private final ObservableList<ComplexNumber> oldMem;
    private final ObservableList<Variable> oldVars;

    public OperationInvoker(){      
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
        NumberMemory numMem = NumberMemory.getNumberMemory();
        VariableMemory varMem = VariableMemory.getVariableMemory();
        oldMem.clear();
        for(ComplexNumber cmpx : numMem.getStack()){
            oldMem.add(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }
        
        oldVars.clear();
        for(Variable var : varMem.getVars()){
            oldVars.add(new Variable(var.getVar(), var.getValue()));
        }
        
    }
    
    private void restore(){
        NumberMemory numMem = NumberMemory.getNumberMemory();
        VariableMemory varMem = VariableMemory.getVariableMemory();
        numMem.clear();
        for(ComplexNumber cmpx : oldMem){
            numMem.push(new ComplexNumber(cmpx.getReal(), cmpx.getImaginary()));
        }
        
        varMem.clear();
        for(Variable var : oldVars){
            varMem.addVariable(new Variable(var.getVar(), var.getValue()));
        }
    }
}