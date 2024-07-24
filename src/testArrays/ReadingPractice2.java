package testArrays;

public class ReadingPractice2 {

    public static void main(String[] args) {
        System.out.println(0.25 + 0.25);
        asserEquals(3, median(new double[] {1, 3, 2, 6, 5}));
        asserEquals(3, median(new double[] {1, 3, 2, 7, 5}));
        asserEquals(1, median(new double[] {1, 3, 2, 1, 1}));
        asserEquals(1.5, median(new double[] {1, 3, 2, 1, 1, 2}));
        asserEquals(2, median(new double[] {1, 3, 5, 1, 1, 5}));

        assertArrayEquals(new double[] {.1, .3, 1, .1, .1, .5}, normalization(new double[] {1, 3, 10, 1, 1, 5}));
        assertArrayEquals(new double[] {.2, .6, .4, .2, .2, 1}, normalization(new double[] {1, 3, 2, 1, 1, 5}));
        assertArrayEquals(new double[] {.24, .06, .84, .02, 1, .66}, normalization(new double[] {12, 3, 42, 1, 50, 33}));

        double[][] test = {
                {1, .5, 2.5},
                {3.6, 6.3, 0},
                {.7, 2.2, 15}};
        assertArrayEquals(new double[] {1, 3.6, 2.2}, method9(test));
        test = new double[][] {
                {11, 7.5, 2.1},
                {1.6, 4.3, 5.5},
                {5, 12.2, 5.01}};
        assertArrayEquals(new double[] {7.5, 4.3, 5.01}, method9(test));
    }

    private static double median(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        if (array.length % 2 == 1) {
            return array[array.length / 2];
        }
        return (array[(array.length / 2) - 1] + array[array.length / 2]) / 2;
    }

    private static double[] normalization(double[] array) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        double[] result = new double[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i] / max;
        }
        return result;
    }

    private static double[] method9(double[][] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = median(array[i]);
        }
        return result;
    }

    private static void asserEquals(double expected, double actual) {
        if (Math.abs(expected - actual) > 0.0001) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }

    private static void assertArrayEquals(double[] expected, double[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (Math.abs(actual[i] - expected[i]) > 0.0001) {
                throw new RuntimeException("Expected " + expected[i] + " but got " + actual[i]);
            }
        }
    }
}
