package adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort<Integer> integerSort = new BubbleSort<>();
    private BubbleSort<String> stringSort = new BubbleSort<>();

    @BeforeEach
    void setUp() {
        // Not yet used
    }

    @Test
    void sortInteger() {
        Integer[] list = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        integerSort.sort(list);
        assertArrayEquals(expected, list);
    }

    @Test
    void sortString() {
        String[] list = {"b", "c", "d", "a"};
        String[] expected = {"a", "b", "c", "d"};

        stringSort.sort(list);
        assertArrayEquals(expected, list);
    }

}
