package adt;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BinaryLinkedTree<T extends Comparable<T>> implements BinaryTree<T> {

    // root node
    private BinaryTreeNode root;

    // class data members
    private static Method visit;                               // visit method to use during a traversal
    private static Object[] visitArgs = new Object[1];         // parameters of visit method
    private static int count;                                  // counter
    private static Class[] paramType = {BinaryTreeNode.class}; // type of parameter for visit
    private static Method countNodes;                          // method to count nodes
    static Method outputMethod;                                // method to output node element

    // method to initialize class data members
    static {
        try {
            Class<BinaryLinkedTree> treeClass = BinaryLinkedTree.class;
            countNodes = treeClass.getMethod("countNodes", paramType);
            outputMethod = treeClass.getMethod("output", paramType);
        } catch (Exception e) {
            // can't catch exceptionn here
        }
    }

    /**
     * Besuchsmethode, die das Element ausgibt.
     *
     * @param treeNode auszugebender Knoten
     */
    public static void output(BinaryTreeNode treeNode) {
        System.out.print(treeNode.getPayload() + " ");
    }

    /**
     * Besuchsmethode zum Zählen der Knoten.
     */
    public static void countNodes(BinaryTreeNode treeNode) {
        count++;
    }

    /**
     * @return Liefert den Wert true, falls der Baum leer ist
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Liefert die Wurzel des Baumes.
     *
     * @return Liefert den Wert null, falls der Baum leer ist
     */
    public BinaryTreeNode getRoot() {
        return (isEmpty()) ? null : root;
    }

    /**
     * Erstellt eine Baumstruktur mit den angegebenen Parameter.
     *
     * <b>Vorsicht:</b> Der rechte und linke Teilbaum wird nicht geklont!
     *
     * @param payload Daten des Knotens
     * @param left    Linker Teilbaum
     * @param right   Rechter Teilbaum
     */
    public void makeTree(T payload, BinaryTreeNode left, BinaryTreeNode right) {
        this.root = new BinaryTreeNode<>(payload, left, right);
    }

    /**
     * Löscht den linken Teilbaum.
     *
     * @return Gelöschter Teilbaum
     * @throws IllegalArgumentException wenn der Teilbaum leer ist
     */
    public BinaryTree removeLeftSubtree() {
        if (isEmpty())
            throw new IllegalArgumentException("tree is empty");

        // Linken Teilbaum trennen
        BinaryLinkedTree leftSubtree = new BinaryLinkedTree();
        leftSubtree.root = root.getLeftChild();
        root.setLeftChild(null);

        return leftSubtree;
    }

    /**
     * Löscht den rechten Teilbaum.
     *
     * @return Gelöschter Teilbaum
     * @throws IllegalArgumentException wenn der Teilbaum leer ist
     */
    public BinaryTree removeRightSubtree() {
        if (isEmpty())
            throw new IllegalArgumentException("tree is empty");

        // Rechten Teilbaum trennen
        BinaryLinkedTree rightSubtree = new BinaryLinkedTree();
        rightSubtree.root = root.getRightChild();
        root.setRightChild(null);

        return rightSubtree;
    }

    /**
     * Einfügend eines neuen Elementes in die Baumstruktur. Damit das Einfügen funktioniert
     * müssen die Eigenschaften eines BST (Binary Search Tree) erfüllt sein. Dies bedeutet,
     * dass der Baum zu jeder gegebenen Zeit sortiert vorliegt.
     * <p>
     * Referenz: Algorithmus 14.7 (s. 363)
     *
     * @param element Einzufügendes Element
     * @return liefert den Wert true, wenn das Element eingefüght werden konnte.
     */
    @SuppressWarnings("unchecked")
    public boolean insert(@NotNull T element) {
        if (isEmpty()) {
            makeTree(element, null, null);
            return true;
        }

        BinaryTreeNode parent, child = root;
        do {
            int cmp = child.getPayload().compareTo(element);
            if (cmp == 0)
                return false;
            else {
                parent = child;
                child = (cmp > 0 ? child.getLeftChild() : child.getRightChild());
            }

        } while (child != null);


        BinaryTreeNode node = new BinaryTreeNode<>(element, null, null);

        if (parent.getPayload().

                compareTo(element) > 0)
            parent.setLeftChild(node);
        else
            parent.setRightChild(node);

        return true;
    }

    /**
     * Löschen eines Elementes aus der Baumstruktur. Damit das Löschen funktioniert gehen wir
     * davon aus, dass es sich um einen BST (Binary Search Tree) handelt und das zu löschende
     * Element auch nur einmal vorhanden ist.
     *
     * @param element zu löschendes Element
     * @return liefert true, falls das Element gelöscht werden konnte.
     */
    public boolean delete(T element) {
        BinaryTreeNode parent = root, node = root, child = null, temp = null;

        while (node != null) {
            int cmp = node.compareTo(element);
            if (cmp == 0)
                break;
            else{
                parent = node;
                node = (cmp > 0 ? node.getLeftChild() : node.getRightChild());
            }
        }

        //noinspection ConstantConditions
        if (node == null) return false;

        if (node.getRightChild() == null && node.getLeftChild() == null) { // Es ist ein Blatt
            child = null;

        } else if (node.getLeftChild() == null) {
            child = node.getRightChild();
        } else if (node.getRightChild() == null) {
            child = node.getLeftChild();
        } else {
            child = node.getRightChild();
            temp = node;

            while (child.getLeftChild() != null) {
                temp = child;
                child = child.getLeftChild();
            }
            child.setLeftChild(node.getLeftChild());
            if (temp != node) {
                temp.setLeftChild(child.getRightChild());
                child.setRightChild(node.getRightChild());
            }
        }
        if (parent.getLeftChild() == node)
            parent.setLeftChild(child);
        else
            parent.setRightChild(child);
        return true;
    }

    /**
     * Preorder Traversierung.
     *
     * @param visit Methode, die während des Besuchs anzuwenden ist
     */
    public void preOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traversePreOrder(root);
    }

    /**
     * Actual preorder traversal method
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    private void traversePreOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }
            traversePreOrder(treeNode.getLeftChild());
            traversePreOrder(treeNode.getRightChild());
        }
    }

    /**
     * InOrder Traversierung.
     *
     * @param visit Methode, die während des Besuchs anzuwenden ist
     */
    public void inOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traverseInOrder(root);
    }

    /**
     * Effektive Umsetzung der InOrder Traversierung.
     *
     * @param treeNode Knoten, von welchem die Traversierung gestartet wird
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    private void traverseInOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            traverseInOrder(treeNode.getLeftChild());
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }
            traverseInOrder(treeNode.getRightChild());
        }
    }

    /**
     * PostOrder Traversierung.
     *
     * @param visit Methode, die während des Besuchs anzuwenden ist
     */
    public void postOrder(Method visit) {
        BinaryLinkedTree.visit = visit;
        traversePostOrder(root);
    }

    /**
     * Effektive Umsetzung der PostOrder Traversierung
     *
     * @param treeNode Knoten, von welchem die Traversierung gestartet wird
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    private void traversePostOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            traversePostOrder(treeNode.getLeftChild());
            traversePostOrder(treeNode.getRightChild());
            //visitArgs[0] = treeNode;
            //try {
            //    visit.invoke(null, visitArgs);
            // } catch (Exception e) {
            //     System.out.println(e);
            // }
            System.out.print(treeNode.getPayload() + " ");
            traverseInOrder(treeNode.getRightChild());
        }
    }

    /**
     * LevelOrder Traversierung
     *
     * @param visit Methode, die während des Besuchs anzuwenden ist
     */
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    public void levelOrder(Method visit) {
        ArrayQueue<BinaryTreeNode> q = new ArrayQueue<>();
        BinaryTreeNode treeNode = root;
        while (treeNode != null) {
            visitArgs[0] = treeNode;
            try {
                visit.invoke(null, visitArgs);
            } catch (Exception e) {
                System.out.println(e);
            }

            // put t's children on queue
            if (treeNode.getLeftChild() != null)
                q.put(treeNode.getLeftChild());
            if (treeNode.getRightChild() != null)
                q.put(treeNode.getRightChild());

            // get next node to visit
            treeNode = q.remove();
        }
    }

    /**
     * Liefert die Anzahl der Knoten im Baum.
     *
     * @return Anzahl Knoten im Baum
     */
    public int size() {
        count = 0;
        preOrder(countNodes);
        return count;
    }

    /**
     * Liefert die Tiefe des Baumes beginnend mit dem Startknoten.
     *
     * @return Tiefe des Baumes
     */
    public int height() {
        return countHeight(root);
    }


    /**
     * Liefert die Tiefe des Baumes beginnend mit dem angegebenen Knoten.
     *
     * @param treeNode Von diesem Knoten soll die Tiefe berechnet werden
     * @return Tiefe des Baumes
     */
    private int countHeight(BinaryTreeNode treeNode) {
        if (treeNode == null)
            return 0;

        int leftHeight = countHeight(treeNode.getLeftChild());
        int rightHeight = countHeight(treeNode.getRightChild());

        return (leftHeight > rightHeight) ? ++leftHeight : ++rightHeight;
    }

}
