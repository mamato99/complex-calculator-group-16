package it.unisa.complexcalculator.Model.Memory;

import it.unisa.complexcalculator.Model.ComplexNumber;
import java.util.ArrayDeque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The istance of a <code>VariableMemory</code> class represent the 
 * memory of a calculator. This memory contains an ObservableList of variables  
 * in which it is possible to store instances of <code>ComplexNumbers</code> class representing 
 * complex numbers in cartesian notation. It allows to manipulate the stored varibles with the following operations:
 * <ul>
 * <li><b>getVariableMemory</b> to return the refrence to the instance of <code>VariableMemory</code> class.</li>
 * <li><b>getVars</b> to return an <code>ObservableList</code> of <code>Variable</code>.</li>
 * <li><b>updateVariable</b> to update the variable to a new value of <code>ComplexNumber</code>.</li>
 * <li><b>clear</b> to remove all of the elements from the <code>ObservableList</code> of <code>Variable</code>.</li>
 * <li><b>addVariable</b> to add the <code>Variable</code> at the end of the list.</li>
 * <li><b>getVariable</b> to return the requested <code>Variable</code>.</li>
 * <li><b>saveVariableState</b> to save a copy of the <code>ObservableList of Variable</code> in an <code>ArrayDeque</code>.</li>
 * <li><b>loadVariableState</b> to load a copy of all the variables from an <code>ArrayDeque</code> to the <code>observableArrayList</code>.</li>
 * </ul>
 */
public class VariableMemory {
    private final ObservableList<Variable> vars;
    private final ArrayDeque<ObservableList<Variable>> varStack;
    private static VariableMemory instance = null;

    /**
     * Returns the refrence to the unique instance of <code>VariableMemory</code> class, in particular if 
     * this has already been instantiated (and therefore used), it returns its reference, 
     * otherwise it creates and returns it
     * @return the unique instance of <code>VariableMemory</code>
     */
    public static VariableMemory getVariableMemory() {
        if(instance == null)
            instance = new VariableMemory();
        return instance;
    }
    
    /**
     * Constructor of the VariableMemory class.
     * <p>It initializes the stored variables stack assigning to it an instance of an empty 
     * <code>ArrayDeque</code> class and sets a list of variables to the value of complexnumber zero .</p>
     */
    private VariableMemory() {
        vars = FXCollections.observableArrayList();
        for (char c = 'a'; c <= 'z'; c++) {
            vars.add(new Variable(c, new ComplexNumber(0, 0)));
        }
        varStack = new ArrayDeque<>();
    }

    /**
     * Gets the list of variables of the Variable Memory
     * @return the list of variables of the Variable Memory
     */
    public ObservableList<Variable> getVars() {
        return vars;
    }
    
    /**
     * Looks for the character c passed to it and updates its ComplexNumber
     * @param c character that identifies the variable to be updated
     * @param n ComplexNumber which must replace the previous one
     */
    public void updateVariable(Character c, ComplexNumber n){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                v.setValue(n);       
        }
    }
    
    /**
     * Removes all of the elements from the list of variables. The list will be empty after this call returns.
     */
    public void clear(){
        vars.clear();
    }
    
    /**
     * Appends the specified element to the end of this list
     * @param var variable to add
     */
    public void addVariable(Variable var){
        vars.add(var);
    }
    
    /**
    * Gets the complex number assigned to the passed variable
    * @param c character that identifies the searched variable 
    * @return the complex number assigned to the passed variable
    */
    public ComplexNumber getVariable(Character c){
        for (Variable v : vars){
            if (v.getVar().equals(c))
                return v.getValue();
        }
        return null;
    }

    /**
    * Saves a copy of all the variables in an <code>ArrayDeque</code>.
    */
    public void saveVariableState(){
        ObservableList<Variable> toSave = FXCollections.observableArrayList();
        for(Variable var : vars)
            toSave.add(new Variable(var.getVar(), var.getValue()));
        varStack.push(toSave);
    }
    
    /**
    * Load a copy of all the variables from an <code>ArrayDeque</code> to the <code>observableArrayList</code>.
    */
    public void loadVariableState(){
        for(Variable v : varStack.pop()){
            updateVariable(v.getVar(), v.getValue());
        }
    }
}
