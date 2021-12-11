package it.unisa.complexcalculator.Model.Stream;

import it.unisa.complexcalculator.Model.ConcreteOperationFactory;
import it.unisa.complexcalculator.Model.Memory.OperationMemory;
import it.unisa.complexcalculator.Model.Operation.CustomOperations.CustomOperation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The istance of a <code>Stream</code> class represent represents an object
 * that allows the flow of data on file, both in input and in output. 
 */
public abstract class Stream {

    public abstract File save();

    public abstract File load();

    /**
     * Takes the name of a file and save on this the items stored in the
     * <code>OperationMemory</code>.
     *
     * @param file name of the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveData(String file) throws FileNotFoundException, IOException {
        OperationMemory opMem = OperationMemory.getOperationMemory();
        try (DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            dout.writeInt(opMem.opLen());
            
            for (CustomOperation op : opMem.getOps()) {
                String toWrite = op.getName() + ":" + op.getSequence();
                dout.writeUTF(toWrite);
            }
            dout.flush();
        }
    }

    /**
     * Takes the name of a file and load from this, and store items in the
     * <code>OperationMemory</code>.
     *
     * @param file name of the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadData(String file) throws FileNotFoundException, IOException {
        ConcreteOperationFactory opFac = new ConcreteOperationFactory();
        OperationMemory opMem = OperationMemory.getOperationMemory();
        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        int n = din.readInt();
        opMem.clear();

        String token;

        for (int i = 0; i < n; i++) {
            token = din.readUTF();

            opMem.addCustomOperation(opFac.createCustomOperation(token.split(":")[0], token.split(":")[1])); // Null because before invoking it, the calculator populates the arraydeque of operations
        }
    }

}
