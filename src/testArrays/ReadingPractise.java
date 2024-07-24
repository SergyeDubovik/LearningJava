package testArrays;

import java.lang.Math;

import static testArrays.TaskArrays.printArray;
import static testArrays.TaskArrays.printArrayLong;

public class ReadingPractise {
    public static void main(String[] args) {
//        assert method1(new int[]{1, 2, 3, 4, 5, 6}) == 48;
//        assert method1(new int[]{6, 5, 4, 3, 2, 1}) == 48;
//        assert method1(new int[]{2, 2, 2, 1, 1, 1}) == 9;
//        assert method1(new int[]{21, 23, 25, 13, 17, 19}) == 1;
//        System.out.println(method2(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println (method2(new int[]{0, 2, 3, 4, 5, 6}));
//        System.out.println (method2(new int[]{1, 2, 3, 4, 4, 6}));
//        System.out.println (method2(new int[]{1, 2, 3, 4, 5, 5}));
//
//        int[] actual = method3(new int[]{1, 12, 4, 4, 15, -2}, 3);
//        int[] expected = {-2, 15, 4};
//        assertArrayEquals(expected, actual);
//
//        actual = method3(new int[]{1, 12, 4, 4, 15, -2}, 8);
//        expected = new int[]{-2, 15, 4, 4, 12, 1};
//        assertArrayEquals(expected, actual);
//
//        actual = method3(new int[]{1, 12, 4, 4, 15, -2}, 0);
//        expected = new int[0];
//        assertArrayEquals(expected, actual);

        asserEquals(-1, method4(new int[] {1, 2}));
        asserEquals(-1, method4(new int[] {1, 2, 3, 4, 5}));
        asserEquals(-1, method4(new int[] {5, 4, 3, 2, 1}));
        asserEquals(2, method4(new int[] {0, 1, 2, 1, 1}));
        asserEquals(3, method4(new int[] {1, 3, 1, 3, 1}));
        asserEquals(1, method4(new int[] {0, 1, 0, 0, 0}));
        asserEquals(1, method4(new int[] {1, 5, 1, 0, 1}));

        asserEquals(-1, method5(new int[] {1, 2}));
        asserEquals(-1, method5(new int[] {1, 2, 3, 4, 5}));
        asserEquals(-1, method5(new int[] {5, 4, 3, 2, 1}));
        asserEquals(2, method5(new int[] {0, 1, 2, 1, 1}));
        asserEquals(3, method5(new int[] {1, 3, 1, 3, 1}));
        asserEquals(1, method5(new int[] {0, 1, 0, 0, 0}));

        asserEquals(-1, method5For(new int[] {1, 2}));
        asserEquals(-1, method5For(new int[] {1, 2, 3, 4, 5}));
        asserEquals(-1, method5For(new int[] {5, 4, 3, 2, 1}));
        asserEquals(2, method5For(new int[] {0, 1, 2, 1, 1}));
        asserEquals(3, method5For(new int[] {1, 3, 1, 3, 1}));
        asserEquals(1, method5For(new int[] {0, 1, 0, 0, 0}));
//
        asserEquals(-1, method6(new int[] {1, 2}));
        asserEquals(-1, method6(new int[] {1, 2, 3, 4, 5}));
        asserEquals(-1, method6(new int[] {5, 4, 3, 2, 1}));
        asserEquals(2, method6(new int[] {0, 1, 2, 1, 1}));
        asserEquals(3, method6(new int[] {1, 3, 1, 3, 1}));
        asserEquals(1, method6(new int[] {0, 1, 0, 0, 0}));
        asserEquals(5, method6(new int[] {1, 5, 1, 0, 1}));

        for (int i = 2; i < 1000; i++) {
            int[] temp = fibonacciNumbers(i);
            if (temp[i - 1] < 0) {
                System.out.println(i);
                break;
            }
        }
        printArray((fibonacciNumbers(47)));
        System.out.println();
        printArrayLong(fibonacciNumbersViaLong(48));



    }

    private static int method1(int[] array) {
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result *= array[i];
            }
        }
        return result;
    }

    private static boolean method2(int[] array) {
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == i) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static int[] method3(int[] array, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n && i < array.length; i++) {
            result[i] = array[array.length - 1 - i];
        }
        return result;
    }

    private static void assertArrayEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                throw new RuntimeException("Error!");
            }
        }
    }

    /*
        1 проверить, является ли число палиндромом (1221 - да, 124312 - нет)

        алгоритм:
        обьявить логич переменную (да или нет)
        разобрать число на цифры
        сравнивать их (цифры) между собой в зеркальном порядке
    */

    private static boolean palindromeNumber(int x) {
        int res = 0;
        int numbersCount = (int)(Math.log10(x)) + 1;
        int i = numbersCount - 1;

        int[] numbers = new int[numbersCount];
        while (x > 0) {
            res = x % 10;
            numbers[i] = res;
            i--;
            x /= 10;
        }
        boolean result = true;
        for (int j = 0; j < numbers.length / 2; j++) {
            if (numbers[j] != numbers[numbers.length - 1 - j]) {
                result = false;
                break;
            }

        }


        return result;
    }

    /*
        нужно заполнить массив числами Фибоначчи
        0 1 1 2 3 5 8 13...
     */

    private static int[] fibonacciNumbers(int n) {
        if (n < 2) {
            throw new RuntimeException("Error! n is too small");
        }
        int[] result = new int[n];
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    /*
        переписать числа Фибоначчи с использованием типа long, проверить,
        на каком значении N int больше не сможет работать правильно

     */

    public static long[] fibonacciNumbersViaLong(int v) {
        if (v < 2) {
            throw new RuntimeException("Error: V is too small");
        }
        long[] result2 = new long[v];
        result2[1] = 1;
        for (int i = 2; i < v; i++) {
            result2[i] = result2[i - 1] + result2[i - 2];
        }
        return result2;
    }


    private static void asserEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Expected " + expected + " but got " + actual);
        }
    }

    private static int method4(int[] array) {
//        {1, 5, 1, 0, 1}
        int result = -1;
//        if (array.length < 3) {
//            return result;
//        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                result = i;
            }
        }
        return result;
    }

    private static int method5(int[] array) {
//        {1, 2, 3, 4, 5}
        int i = array.length - 2;
        while (i > 0) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                return i;
            }
            i--;
        }
        return -1;
    }

    private static int method5For(int[] array) {
        for (int i = array.length - 2; i > 0; i--) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private static int method6(int[] array) {
//        {1, 2, 3, 4, 5}
        if (array.length < 3) {
            return -1;
        }
        for (int i = array.length - 2; i > 0; i--) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                return array[i];
            }
        }
        return -1;
    }
}
