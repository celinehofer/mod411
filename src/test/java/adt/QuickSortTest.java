package adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort<Integer> integerSort = new QuickSort<>();

    @BeforeEach
    void setUp() {
    }

    @Test
    void sortInteger() {
        Integer[] list = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        integerSort.sort(list);
        assertArrayEquals(expected, list);
    }

}
