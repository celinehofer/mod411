package generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCacheTest {

    private StringCache cache;

    @BeforeEach
    void setUp() {
        cache = new StringCache();
    }

    @Test
    void add() {
        String expected = "Eine Zeichenkette";
        cache.add(expected);
        assertEquals(expected, cache.get());
    }
}
