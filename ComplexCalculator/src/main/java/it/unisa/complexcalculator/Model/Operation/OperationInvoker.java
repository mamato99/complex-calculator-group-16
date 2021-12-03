package it.unisa.complexcalculator.Model.Operation;

import it.unisa.complexcalculator.Model.Operation.Operation;

public class OperationInvoker {

    public void execute(Operation op){
        op.execute();
    }
}
