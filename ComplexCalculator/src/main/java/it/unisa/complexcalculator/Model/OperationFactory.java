package it.unisa.complexcalculator.Model;

import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import it.unisa.complexcalculator.Model.Operation.Operation;

public interface OperationFactory {
    public Operation createOperation(String s);
    public CustomOperation createCustomOperation(String name, String sequence);
}
