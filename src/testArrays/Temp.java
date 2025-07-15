package testArrays;

import java.util.List;

import static testArrays.TaskArrays.printArray;

public class Temp {
    public static void main(String[] args) {
//        int[] myArray = {1, 21, -2, 55, 4, -31};
//        int[] myArray1 = {1, 2, 44};
//        System.out.println(findMaxElement(myArray));
////        printArray(insertionSort(myArray));
//            printArray(sortAr(myArray1));
//        System.out.println();
//        int[] array = {3, -1, 52, -3, 4};
//        System.out.println(sumOfPositiveElements(array));
//
//        String[] words = {"flairstla", "second", "third la", "bla bla bla"};
//        String substring = "la";
//        for (String i : words) {
//            int first = i.indexOf(substring);
//            int second = i.lastIndexOf(substring);
//            if (first != second) {
//                System.out.println(i);
//            }
//        }
//        numbersOrLetters();
        streamTest();
    }

    /*
        create immutable list
        -> get elements which contains of only letters a-p
        -> get letter by char
        -> input to console
     */
    private static void streamTest() {
        List<String> words = List.of("john", "jack", "phillip", "antoni", "pit");
        List<Character> result = words.stream()
                .filter(w -> w.matches("[a-p]+"))
                .map(w -> w.charAt(2))
                .toList();
        System.out.println(result);
    }

    private static void numbersOrLetters() {
        char[] array2 = {'5', ')', 'g', '2', '(', '(', 'H', 'D', '7', '3'};
        int z = 0;
        int x = 0;
        for (int i : array2) {
            if (i >= 48 && i <= 57) {
                z++;
            } else if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
                x++;
            }

        }
        if (z > x) {
            System.out.println("Numbers more than letters");
        } else {
            System.out.println("Letters more than numbers");
        }
    }

    private static void sortArr() {
        int[] array = {4, 54, -4, 55, 2, 9, 88};
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        printArray(array);
    }

    /*
        найти сумму всех элементов массива
     */

    public static int sumOfArrayElements(int sum) {
        int[] myArray = {3, -5, 66, 13};
        for (int i : myArray) {
            sum += i;
        }
        return sum;
    }

    /*
        найти сумму четных элементов массива
     */

    public static int sumEven(int sum2) {
        int[] myArray = {3, -5, 66, 13, 4};
        for (int i : myArray) {
            if (i % 2 != 0) {
                continue;
            }
            sum2 = sum2 + i;
        }
        return sum2;
    }

    /*
        Сумма положительных элементов массива
     */

    public static int sumPositive(int sum3) {
        int[] myArray = {3, 5, 13, -51, 31, 4};
        for (int i : myArray) {
            if (i / 2 < 0) {
                continue;
            }
            sum3 = sum3 + i;
        }
        return sum3;
    }

    /*
        сортировка вставками
     */
    public static int[] insertionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
    public static Object[] printObjectArray(Object[] array) {
        for (Object o : array) {
            System.out.println(o + " ");
        }
        return array;
    }

    public static int sumOfPositiveElements(int[] array) {

        int sum = 0;
        for (int j : array) {
            if (j > 0) {
                sum += j;
            }
        }
        return sum;
    }

    public static int[] sortAr(int[] array) {
        if (array.length <= 1) {
            throw new RuntimeException("Array too short to sort");
        }
        int tempNumb;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] > array[j - 1]) {
                    tempNumb = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tempNumb;
                }

            }
        }
        return array;
    }

    public static int findMaxElement(int[] ar) {
        if (ar.length <= 1) {
            throw new RuntimeException("Array is too short to perform any operations");
        }
        int maxValue = 0;
        for (int i : ar) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

}
