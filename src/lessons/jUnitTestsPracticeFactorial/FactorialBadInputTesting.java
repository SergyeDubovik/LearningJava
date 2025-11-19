package lessons.jUnitTestsPracticeFactorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialBadInputTesting {
    Factorial factorial = new Factorial();

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null));
    }

    @Test
    void testNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-1"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("1-"));
    }

    @Test
    void testFractionalInput() {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("1.5"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("1,5"));
    }

    @Test
    void testNonDigitalInput() {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("1b"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("c21"));
    }
}
