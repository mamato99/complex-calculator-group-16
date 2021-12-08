package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.ComplexNumber;
import it.unisa.complexcalculator.Model.Memory.Variable;
import java.util.*;

public class OperationInvoker {
    
    private List<ComplexNumber> oldMem;
    private List<Variable> oldVars;

    public void execute(Operation op, Calculator c){

        oldMem = c.getNumbers().getStackAsList();
        oldVars = c.getVariables().getVarsAsList();
        
        try{
            op.execute();
        }catch(Exception ex){
            c.getNumbers().setStackFromList(oldMem);
            c.getVariables().setVarsFromList(oldVars);  
            throw ex;
        }
    }

}