package lessons.jUnitTestsPracticeFactorial;

import java.math.BigInteger;

public class Factorial {
    public String factorial(String n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        if (!n.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        int parsed;
        try {
            parsed = Integer.parseInt(n);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= parsed; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.toString();
    }
}
