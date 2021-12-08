package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.Variable;
import java.util.*;

public class OperationInvoker {
    private List<ComplexNumber> oldMem;
    private List<Variable> oldVars;

    public void execute(Operation op, Calculator c){

        save(c);
        try{
            op.execute();
        }catch(Exception ex){
            restore(c);
            throw ex;
        }
    }

    private void save(Calculator c){
        oldMem = new ArrayList<>();
        oldVars = new ArrayList<>();

        for (ComplexNumber num : c.getNumbers().getStack()){
            oldMem.add(0,num);
        }
        for (Variable var : c.getVariables().getVars()){
            oldVars.add(var);
        }

    }

    private void restore(Calculator c){
        c.getNumbers().getStack().clear();
        for (ComplexNumber num : oldMem){
            c.getNumbers().push(num);
        }
        c.getVariables().getVars().clear();
        for (Variable var : oldVars){
            c.getVariables().pushVariable(var);
        }

    }
}