package generic;

/**
 * Ein Objekt dieser Klasse speichert ein Integer Objekt im Sinne eines Zwischenspeichers (Cache).
 * Es handelt sich hierbei um eine rudimentäre Umsetzung, um den Einsatz von generischen Klassen
 * vorzustellen.
 */

@SuppressWarnings("ALL")
public class IntegerCache {

    private Integer value = 0;

    /**
     * Speichert eine ganze Zahl in unserem Zwischenspeicher (Cache)
     *
     * @param value Zu speichernde Zahl
     */
    public void add(Integer value) {
        this.value = value;
    }

    /**
     * Liefert die ganze Zahl, welche sich aktuell in unserem Zwischenspeicher (Cache) befindet.
     *
     * @return Gespeicherte Zahl
     */
    public Integer get() {
        return this.value;
    }

}
