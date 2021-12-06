
package it.unisa.complexcalculator.Model.Operation.VariableOperation;

import it.unisa.complexcalculator.Model.Calculator;
import it.unisa.complexcalculator.Model.Operation.Operation;
import it.unisa.complexcalculator.Model.Operation.OperationFactory;


public class VariableOperationFactory implements OperationFactory{
    
    /*
     * Method for the parsing of a variable operation
     */
    @Override
    public Operation parseOperation(String s, Calculator c) {
        
        if(s.length() != 2 || !(s.startsWith(">") || s.startsWith("<") || s.startsWith("+") || s.startsWith("-")))
            return null;
        
         //UPPERCASE TO AVOID "i" as imaginary part
        if(s.charAt(1) >= 'A' && s.charAt(1) <= 'Z'){
            switch(s.charAt(0)){
                case '<': return new VariableToStackOperation(s.charAt(1),c);
                case '>': return new StackToVariableOperation(s.charAt(1),c);
                case '+': return new AddToVariableOperation(s.charAt(1),c);
                case '-': return new SubtractToVariableOperation(s.charAt(1),c);
                default: return null;
            }
        }
        
        return null;
    }
    
    
}
