package measurement;

import java.util.Random;
import java.util.function.Consumer;

public class PerformanceMeasurement {

    // Anzahl Iterationen für eine Messung
    private static final int COUNT = 10_000_000;

    // Zufallszahlengenerator für unsere Tests
    private static Random random = new Random();


    public static void main(String[] args) {

        System.out.println("StaticArray insert: "
                + measurePerformance(Operations::insertStaticArray, COUNT));

        System.out.println("LinkedList insert:  "
                + measurePerformance(Operations::insertLinkedList, COUNT));

    }


    private static <T> String measurePerformance(Consumer<T> function, T input) {
        long start = System.nanoTime();
        function.accept(input);

        return String.format("%6d ms", (System.nanoTime() - start) / 1_000_000);
    }

}
