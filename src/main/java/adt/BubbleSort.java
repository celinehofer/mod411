package adt;

/**
 * Die Idee des BubbleSort ist es, dass zwei benachbarte Elemente (vom Typ E) vertauscht werden,
 * wenn das grössere vorne liegt. Durch die geschachtelte Schleife ist es einleuchtend, dass in
 * einer Reihung der Länge n die Anzahl der Vergleiche n^2 beträgt.
 *
 * @param <E> Zu vergleichender Datentyp
 */
public class BubbleSort<E extends Comparable<E>> implements Sort<E> {

    public void sort(E[] collection) {
        for (int i = 0; i < collection.length; i++) {
            for (int j = 0; j < collection.length - 1; j++) {
                if (collection[j + 1].compareTo(collection[j]) < 0) {
                    final E temp = collection[j + 1]; // Austauschen der Elemente
                    collection[j + 1] = collection[j];
                    collection[j] = temp;
                }
            }
        }
    }

}
