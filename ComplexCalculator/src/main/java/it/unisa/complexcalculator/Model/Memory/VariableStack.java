package it.unisa.complexcalculator.Model.Memory;

import java.util.ArrayDeque;
import javafx.collections.ObservableList;

public class VariableStack extends ArrayDeque<ObservableList<Variable>> {

    private static VariableStack instance = null;

    public static VariableStack getVariableStack() {
        if (instance == null)
            instance = new VariableStack();
        return instance;
    }
    
    private VariableStack(){
        
    }
}
