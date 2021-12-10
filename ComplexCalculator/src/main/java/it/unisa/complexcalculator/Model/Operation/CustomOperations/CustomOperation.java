package it.unisa.complexcalculator.Model.Operation.CustomOperations;

import it.unisa.complexcalculator.Model.Operation.Operation;
import java.util.ArrayDeque;

/**
 * The istance of a <code>CustomOperation</code> class represents an object that
 * contains a sequence of Operations, and gives the possibility to run these in
 * queue.
 * <ul>
 * <li><b>getName</b> to get the name of an <code>Operation</code>.</li>
 * <li><b>setName</b> to set the name of an <code>Operation</code>.</li>
 * <li><b>getSequence</b> to get the sequence of an <code>Operation</code>.</li>
 * <li><b>setSequence</b> to set the sequence of an <code>Operation</code>.</li>
 * <li><b>execute</b> that execute a set of <code>Operation</code>.</li>
 * </ul>
 *
 */
public class CustomOperation implements Operation {

    private final ArrayDeque<Operation> ops;
    private String name;
    private String sequence;

    /**
     * Constructor of the CustomOperation class, it assigns a name, a sequence and 
     * a set of Operations to the Custom Operation created.
     * 
     * @param name name of the Custom Operation
     * @param sequence sequence of the Custom Operation
     * @param ops set of Operations to be executed by the Custom Operation
     */
    public CustomOperation(String name, String sequence, ArrayDeque<Operation> ops) {
        this.name = name;
        this.sequence = sequence;
        this.ops = ops;
    }

    
    /**
     * Returns the name of the Custom Operation
     * 
     * @return a String that is the name of the Custom Operation
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * Sets the name of the Custom Operation
     * 
     * @param name a String that is the name of the Custom Operation
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the sequence of the Custom Operation
     * 
     * @return a String that is the sequence of the Custom Operation
     */
    public String getSequence() {
        return sequence;
    }

    /**
     * Sets the sequence of the Custom Operation
     * 
     * @param sequence a String that is the sequence of the Custom Operation
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    /**
     * Executes all the Operations of the Custom Operation
     */
    @Override
    public void execute() {
        for (Operation op : ops) {
            op.execute();
        }
    }
}
