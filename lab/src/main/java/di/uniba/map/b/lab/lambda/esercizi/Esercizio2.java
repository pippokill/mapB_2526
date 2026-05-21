/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.lambda.esercizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author pierpaolo
 */
public class Esercizio2 {

    private static final Random rnd = new Random();

    private static final String[] specializzazioni = new String[]{"Pilota", "Meccanico", "Diplomatico", "Soldato"};

    private static final int[] counter = new int[specializzazioni.length];

    private static final int NUM_CANDIDATI = 1000;

    /**
     *
     * @return
     */
    public static Candidato generaCandidato() {
        Candidato c = new Candidato();
        c.setLivelloForza(rnd.nextInt(100) + 1);
        c.setCostoIngaggio(rnd.nextDouble() % (1000 - 100 + 1) + 100);
        int s = rnd.nextInt(specializzazioni.length);
        counter[s]++;
        c.setNome(specializzazioni[s] + "-" + counter[s]);
        c.setSpecializzazione(specializzazioni[s]);
        c.setPossiedeNeve(rnd.nextBoolean());
        return c;
    }

    // Task 1

    /**
     *
     * @param candidati
     * @param predicate
     * @return
     */
    public static List<Candidato> filterBy(List<Candidato> candidati, Predicate<Candidato> predicate) {
        List<Candidato> r = new ArrayList<>();
        for (Candidato c : candidati) {
            if (predicate.test(c)) {
                r.add(c);
            }
        }
        return r;
    }

    // Task 2

    /**
     *
     * @param candidati
     * @param function
     * @return
     */
    public static double costoIngaggio(List<Candidato> candidati, Function<Candidato, Double> function) {
        double costo = 0;
        for (Candidato c : candidati) {
            costo += function.apply(c);
        }
        return costo;
    }

    // Task 3

    /**
     *
     * @param candidati
     * @param consumer
     */
    public static void gridoDiBattaglia(List<Candidato> candidati, Consumer<Candidato> consumer) {
        for (Candidato c : candidati) {
            consumer.accept(c);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Candidato> candidati = new ArrayList();
        for (int i = 0; i < NUM_CANDIDATI; i++) {
            candidati.add(generaCandidato());
        }
        // Task 1
        filterBy(candidati, c -> c.getLivelloForza() > 70);
        // Task 2
        costoIngaggio(candidati, c -> {
            if (c.getSpecializzazione().equals("Soldato")) {
                return c.getCostoIngaggio() * 1.10;
            } else {
                return c.getCostoIngaggio();
            }
        });
        // Task 3
        gridoDiBattaglia(candidati, c -> {
            if (c.getLivelloForza() > 80) {
                System.out.println(c.getNome() + ": SONO PRONTO PER SERVIRE L'IMPERO!");
            } else {
                System.out.println(c.getNome() + ": sono pronto per servire l'Impero!");
            }
        });
        // Task 4
        candidati.sort((a, b) -> {
            int c = Integer.compare(a.getLivelloForza(), b.getLivelloForza());
            if (c == 0) {
                return Double.compare(a.getCostoIngaggio(), b.getCostoIngaggio());
            } else {
                return -c;
            }
        });
        // Task 5
        candidati.stream().
                filter(c -> c.isPossiedeNeve()).
                sorted((a, b) -> Double.compare(a.getCostoIngaggio(), b.getCostoIngaggio())).
                map(c -> c.getNome()).limit(3).forEach(s -> System.out.println(s));
        // Task 6
        List<String> collect1 = candidati.stream().
                filter(c -> c.getLivelloForza() > 80).
                map(c -> c.getNome()).
                collect(Collectors.toList());
        // Task 7
        double costoIngaggioTotole = candidati.stream().
                mapToDouble(c -> c.getCostoIngaggio()).
                sum();
        System.out.println(candidati.stream()
                .max((a, b) -> Integer.compare(a.getLivelloForza(), b.getLivelloForza())));
        double avgForza = candidati.stream().
                mapToInt(c -> c.getLivelloForza()).
                average().getAsDouble();
        // Task 8
        Map<String, List<Candidato>> group1 = candidati.stream().
                collect(Collectors.groupingBy(c -> c.getSpecializzazione()));
        Map<String, Long> group2 = candidati.stream().
                collect(Collectors.groupingBy(c -> c.getSpecializzazione(), Collectors.counting()));
        Map<String, Optional<Candidato>> group3 = candidati.stream().
                collect(Collectors.groupingBy(c -> c.getSpecializzazione(), Collectors.minBy((a, b) -> Double.compare(a.getCostoIngaggio(), b.getCostoIngaggio()))));
        System.out.println(group3);
    }

}
