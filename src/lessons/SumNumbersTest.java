package lessons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumNumbersTest {

    @Test
    void sum() {
        SumNumbers sn = new SumNumbers();
        assertEquals(10, sn.sum(6,4));
        assertEquals(1, sn.sum(0,1));
        assertEquals(23, sn.sum(7,16));
        assertEquals(35, sn.sum(20,15));
        assertEquals(118, sn.sum(99,19));
    }
}