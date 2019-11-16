package generic;

/**
 * Ein Objekt dieser Klasse speichert ein Objekt eines bestimmtedn Datentyps
 * im Sinne eines Zwischenspeichers (Cache).
 */

@SuppressWarnings("all")
public class GenericCache<T> {

    private T object;

    /**
     * Speichert eine Objekt des Datentyp T in unserem Zwischenspeicher (Cache).
     *
     * @param object Zu speicherndes Objekt
     */
    public void add(T object) {
        this.object = object;
    }

    /**
     * Liefert das Objekt, welches sich aktuell in unserem Zwischenspeicher (Cache) befindet.
     *
     * @return Gespeichertes Objekt
     */
    public T get() {
        return this.object;
    }

}
