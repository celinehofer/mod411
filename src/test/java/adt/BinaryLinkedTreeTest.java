package adt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryLinkedTreeTest {

    private BinaryLinkedTree<Integer> tree;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        tree = new BinaryLinkedTree<>();
        tree.makeTree(
                6,
                new BinaryTreeNode<>(3,
                        new BinaryTreeNode<>(1),
                        new BinaryTreeNode<>(5)),
                new BinaryTreeNode<>(9,
                        new BinaryTreeNode<>(7),
                        new BinaryTreeNode<>(10))
        );

    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void preOrder() {
        tree.preOrder(BinaryLinkedTree.outputMethod);
        assertEquals("6 3 1 5 9 7 10 ", outContent.toString());
    }

    @Test
    void inOrder() {
        tree.inOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 3 5 6 7 9 10 ", outContent.toString());
    }

    @Test
    void postOrder() {
        tree.postOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 5 3 7 10 9 6 ", outContent.toString());
    }

    @Test
    void levelOrder() {
        tree.levelOrder(BinaryLinkedTree.outputMethod);
        assertEquals("6 3 9 1 5 7 10 ", outContent.toString());
    }

    @Test
    void insertOne() {
        assertTrue(tree.insert(4));
        tree.inOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 3 4 5 6 7 9 10 ", outContent.toString());
    }

    @Test
    void insertTwo() {
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(8));
        tree.inOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 3 4 5 6 7 8 9 10 ", outContent.toString());
    }

    @Test
    void insertTwoLevelTest() {
        assertTrue(tree.insert(4));
        assertTrue(tree.insert(8));
        tree.levelOrder(BinaryLinkedTree.outputMethod);
        assertEquals("6 3 9 1 5 7 10 4 8 ", outContent.toString());
    }

    @Test
    void insertToEmptyTree() {
        tree = new BinaryLinkedTree<>();
        assertTrue(tree.insert(5));
        tree.levelOrder(BinaryLinkedTree.outputMethod);
        assertEquals("5 ", outContent.toString());
    }

    @Test
    void insertNull() {
        assertThrows(IllegalArgumentException.class,
                () -> tree.insert(null));
    }

    @Test
    void deleteElement5() {
        tree.delete(5);
        tree.inOrder(BinaryLinkedTree.outputMethod);
        assertEquals("1 3 6 7 9 10 ", outContent.toString());
    }

    @Test
    void size() {
        assertEquals(7, tree.size());
    }

    @Test
    void height() {
        assertEquals(3, tree.height());
    }

}