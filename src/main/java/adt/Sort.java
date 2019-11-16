package adt;

/**
 * Wenn verschiedene Algorithmen für die Lösung desselben Problems entwickelt werden, ist es zweckmässig,
 * das Entwurfsmuster <b>Strategy</b> zu verwenden. In diesem Fall besteht es daraus, dass die Signatur
 * der Sortiermethoden in einer Schnittstelle vorgegeben ist:
 *
 * @param <E> Zu sortierender Datentyp
 */
public interface Sort<E extends Comparable<E>> {

    void sort(E[] sammlung);

}
