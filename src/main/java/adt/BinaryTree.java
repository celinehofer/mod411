package adt;

import java.lang.reflect.Method;

public interface BinaryTree<T extends  Comparable<T>> {

    /**
     * @return liefert den Wert true, falls der Baum leer ist
     */
    boolean isEmpty();

    /**
     * Liefert die Wurzel des Baumes.
     *
     * @return Liefert den Wert null, falls der Baum leer ist
     */
    BinaryTreeNode getRoot();

    /**
     * Erstellt eine Baumstruktur mit den angegebenen Parameter.
     *
     * <b>Vorsicht:</b> Der rechte und linke Teilbaum wird nicht geklont!
     *
     * @param payload Daten unseres Knotens
     * @param left    Linker Teilbaum
     * @param right   Rechter Teilbaum
     */
    void makeTree(T payload, BinaryTreeNode left, BinaryTreeNode right);

    /**
     * Löscht den linken Teilbaum.
     *
     * @return Gelöschter Teilbaum
     */
    BinaryTree removeLeftSubtree();

    /**
     * Löscht den rechten Teilbaum.
     *
     * @return Gelöschter Teilbaum
     */
    BinaryTree removeRightSubtree();

    /**
     * Einfügend eines neuen Elementes in die Baumstruktur. Damit das Einfügen funktioniert
     * müssen die Eigenschaften eines BST (Binary Search Tree) erfüllt sein. Dies bedeutet,
     * dass der Baum zu jeder gegebenen Zeit sortiert vorliegt.
     *
     * @param element Einzufügendes Element
     * @return liefert den Wert true, wenn das Element eingefügt werden konnte.
     */
    boolean insert(T element);

    /**
     * Löschen eines Elementes aus der Baumstruktur. Damit das Löschen funktioniert gehen wir
     * davon aus, dass es sich um einen BST (Binary Search Tree) handelt und das zu löschende
     * Element auch nur einmal vorhanden ist.
     *
     * @param element zu löschendes Element
     * @return liefert true, falls das Element gelöscht werden konnte.
     */
    boolean delete (T element);
    
    void preOrder(Method visit);

    void inOrder(Method visit);

    void postOrder(Method visit);

    void levelOrder(Method visit);

}
