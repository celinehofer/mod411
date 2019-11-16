package adt;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * Representiert einen Knoten in einer binären Baumstruktur
 */
@Setter
@Getter
@SuppressWarnings("WeakerAccess")
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<T> {

    /**
     * Zu speicherne Daten in in unserem Knoten.
     */
    private T payload;

    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    /**
     * Konstruktor ohne Argumente.
     */
    public BinaryTreeNode() {
    }

    /**
     * Erstellt einen Knotenpunkt mit den gegebenen Daten.
     *
     * @param payload Zu speichernde Daten im Knoten
     */
    public BinaryTreeNode(T payload) {
        this.payload = payload;
    }

    /**
     * Erstellt einen Knotenpunkt mit den übergebenen Daten.
     *
     * @param payload    Root element of the BinaryTreeNode
     * @param leftChild  Linker Teilbaum
     * @param rightChild Rechter Teilbaum
     */
    public BinaryTreeNode(T payload, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.payload = payload;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Vergleicht dieses Objekt mit dem angegebenen Objekt. Liefert eine negative ganze Zahl,
     * null oder eine positive Zahl, wenn dieses Objekt kleiner, gleich oder grösser als das
     * angegebene Objekt ist.
     */
    public int compareTo(@NotNull T object) {
        return payload == null ? -1 : payload.compareTo(object);
    }
}
