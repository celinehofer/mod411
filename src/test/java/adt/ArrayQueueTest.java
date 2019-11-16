package adt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue<Integer> arrayQueue;

    @BeforeEach
    void setUp() {
        arrayQueue = new ArrayQueue<>(3);
    }

    @Test
    void isEmpty() {
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    void getFrontElement() {
        arrayQueue.put(1);
        arrayQueue.put(2);
        arrayQueue.put(3);
        assertEquals(1, arrayQueue.getFrontElement());
    }

    @Test
    void getRearElement() {
        arrayQueue.put(1);
        arrayQueue.put(2);
        arrayQueue.put(3);
        assertEquals(3, arrayQueue.getRearElement());
    }

    @Test
    void throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ArrayQueue<>(-5);
        });
    }

    @Test
    void remove() {
    }
}
