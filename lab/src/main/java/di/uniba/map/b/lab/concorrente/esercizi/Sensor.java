
package di.uniba.map.b.lab.concorrente.esercizi;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author pierpaolo
 */
public class Sensor extends Thread {

    private final Random rnd = new Random();

    private final int NUM_RILEVAZIONI = 50;

    private final Centrale centrale;

    public Sensor(Centrale centrale, String name) {
        super(name);
        this.centrale = centrale;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < NUM_RILEVAZIONI) {
            try {
                double temp = rnd.nextDouble() * (30 - 18) + 18;
                try {
                    centrale.registraDato(temp);
                } catch (IOException ex) {
                    System.err.println("Errore nel registrare la temperatura.");
                }
                long ms = rnd.nextInt(1501) + 500;
                this.sleep(ms);
            } catch (InterruptedException ex) {
                System.err.println("Thread interrotto: "+ex.getMessage());
            }
            i++;
        }
    }

}
