package di.uniba.map.b.lab.concorrente.esercizi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author pierpaolo
 */
public class Centrale {

    private double sommaTemp = 0;

    private double rilevazioni = 0;

    private BufferedWriter writer;

    /**
     *
     * @param logfilepath
     * @throws IOException
     */
    public Centrale(String logfilepath) throws IOException {
        writer = new BufferedWriter(new FileWriter(logfilepath));
    }

    /**
     *
     * @param temp
     * @throws IOException
     */
    public synchronized void registraDato(double temp) throws IOException {
        sommaTemp += temp;
        rilevazioni++;
        if (rilevazioni % 10 == 0) {
            writer.write(String.valueOf(sommaTemp / rilevazioni));
            writer.newLine();
        }
    }

    /**
     *
     * @throws IOException
     */
    public void close() throws IOException {
        writer.write(String.valueOf(sommaTemp / rilevazioni));
        writer.newLine();
        writer.close();
    }
}
