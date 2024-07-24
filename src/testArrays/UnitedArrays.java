package testArrays;
/*
    дано: 2 отсортированых массива чисел, задача - обьединить их в 1 отсортированный массив
 */

import static testArrays.TaskArrays.bubbleSort;
import static testArrays.TaskArrays.printArray;

public class UnitedArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 12, 22, 334, 1111};
        int[] array2 = {3, 3, 8, 14};
        int[] result = joinSortedArraysOptimized(array1, array2);
        printArray(result);

    }

    private static int[] joinSortedArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++){
            result[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            result[array1.length + j] = array2[j];
        }
        bubbleSort(result);
        return result;
    }

    private static int[] joinSortedArraysOptimized(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[i + j] = arr1[i];
                i++;
            } else {
                result[i + j] = arr2[j];
                j++;
            }
        }
        if (i == arr1.length) {
            for (; j < arr2.length; j++) {
                result[i + j] = arr2[j];
            }
        } else {
            for (; i < arr1.length; i++) {
                result[i + j] = arr1[i];
            }
        }
        return result;
    }
}
