package generic;

/**
 * Ein Objekt dieser Klasse speichert ein String Objekt im Sinne eines Zwischenspeichers (Cache).
 * Es handelt sich hierbei um eine rudimentäre Umsetzung, um den Einsatz von generischen Klassen
 * vorzustellen.
 */

@SuppressWarnings("ALL")
public class StringCache {

    private String message = "";

    /**
     * Speichert eine Meldung in unserem Zwischenspeicher (Cache)
     *
     * @param message Zu speichernde Zeichenkette
     */
    public void add(String message) {
        this.message = message;
    }

    /**
     * Liefert die Zeichenkette, welche sich aktuell in unserem Zwischenspeicher (Cache) befindet.
     *
     * @return Gespeicherte Zeichenkette
     */
    public String get() {
        return this.message;
    }

}
