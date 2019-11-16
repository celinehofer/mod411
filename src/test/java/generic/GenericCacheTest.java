package generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericCacheTest {

    @BeforeEach
    void setUp() {
        // Not used yet
    }

    @Test
    void addInteger() {
        GenericCache<Integer> integerCache = new GenericCache<>();

        Integer expected = 4711;
        integerCache.add(expected);
        assertEquals(expected, integerCache.get());
    }

    @Test
    void addString() {
        GenericCache<String> stringCache = new GenericCache<>();

        String expected = "Eine Zeichenkette";
        stringCache.add(expected);
        assertEquals(expected, stringCache.get());
    }

}
