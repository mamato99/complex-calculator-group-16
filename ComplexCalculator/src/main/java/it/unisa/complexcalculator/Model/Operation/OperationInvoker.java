package it.unisa.complexcalculator.Model.Operation;

public class OperationInvoker {

    /*
     * Method for the execution of the Operation passed 
     */
    public void execute(Operation op){
        op.execute();
    }
}
