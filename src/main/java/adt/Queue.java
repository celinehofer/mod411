package adt;

public interface Queue<T> {

    /**
     * Liefert den Wert true, wenn die Datenstruktur leer ist.
     *
     * @return true, wenn die Datenstruktur leer ist
     */
    boolean isEmpty();

    /**
     * Liefert das vorderes Element der Datenstruktur
     *
     * @return null, wenn die Queue leer ist
     */
    T getFrontElement();

    /**
     * Liefert das hinterste Element der Datenstruktur.
     *
     * @return null, wenn die Queue leer ist
     */
    T getRearElement();

    /**
     * Fügt ein neues Element hinten an.
     *
     * @param payload einzufügendes Objekt
     */
    void put(T payload);

    /**
     * Entfernt das vorderste Elemement aus der Queue.
     *
     * @return null, wenn die Queue leer ist
     */
    T remove();
}
