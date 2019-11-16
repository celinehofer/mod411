package generic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCacheTest {

    private IntegerCache cache;

    @BeforeEach
    void setUp() {
        cache = new IntegerCache();
    }

    @Test
    void add() {
        Integer expected =  4711;
        cache.add(expected);
        assertEquals(expected, cache.get());
    }

}
