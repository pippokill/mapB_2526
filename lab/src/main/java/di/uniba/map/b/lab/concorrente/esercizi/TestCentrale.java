
package di.uniba.map.b.lab.concorrente.esercizi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class TestCentrale {

    private static final int NUM_SENS = 10;

    public static void main(String[] args) {
        try {
            Centrale centrale = new Centrale("./resources/temperature.log");
            List<Sensor> sensors = new ArrayList<>();
            for (int i = 0; i < NUM_SENS; i++) {
                sensors.add(new Sensor(centrale, "Sensore-" + i));
            }
            for (Sensor sensor : sensors) {
                sensor.start();
            }
            for (Sensor sensor : sensors) {
                sensor.join();
            }
            centrale.close();
        } catch (IOException ex) {
            System.err.println("Errore di I/O: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.err.println("Thread interrotto: " + ex.getMessage());
        }
    }

}
