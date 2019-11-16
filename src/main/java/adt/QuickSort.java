package adt;

class QuickSort<E extends Comparable<E>> implements Sort<E> {

    public void sort(E[] collection) {
        sort(collection, 0, collection.length - 1); // die ganze Reihung sortieren
    }

    private void sort(E[] collection, int left, int right) {

        int up = left; // linke Grenze
        int down = right; // rechte Grenze
        final E pivot = collection[(left + right) / 2]; // ausgewähltes Element

        do {
            // Suche des grössten Elementes von link an
            while (collection[up].compareTo(pivot) < 0)
                up++;

            // Suchen des kleinsten Elementes von rechts an
            while (pivot.compareTo(collection[down]) < 0)
                down--;

            // Austauschen der Elemente
            if (up <= down) {
                final E temp = collection[up];
                collection[up] = collection[down];
                collection[down] = temp;
                up++;
                down--;
            }
        } while (up <= down); // Überschneidung

        if (left < down)
            sort(collection, left, down); // linke Hälfte sortieren
        if (up < right)
            sort(collection, up, right); // rechte Hälfte sortieren
    }

}
