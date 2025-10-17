package com.epamTasks.beginner.arrays;

import java.util.Arrays;

public class CycleSwap {

    /*
        implement static methods:

      void cycleSwap(int[] array)
        Shifts all the elements in the given array in the right direction by 1 position.
        In this case, the last array element becomes first.
        For example, 1 3 2 7 4 becomes 4 1 3 2 7.

      void cycleSwap(int[] array, int shift)
        Shift all the elements in the given array in the right direction in the cycle manner by shift positions.
        Shift value is guaranteed to be non-negative and not bigger than the array length.
        For example, 1 3 2 7 4 with a shift of 3 becomes 2 7 4 1 3.

        For a greater challenge, try not using loops in your code (not mandatory).

        Examples:

          Code Sample:
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array);
            System.out.println(Arrays.toString(array));

          Output:
            [4, 1, 3, 2, 7]

          Code Sample:
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 2);
            System.out.println(Arrays.toString(array));

          Output:
            [7, 4, 1, 3, 2]

          Code Sample:
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 5);
            System.out.println(Arrays.toString(array));

          Output:
            [1, 3, 2, 7, 4]
     */
    static void cycleSwap(int[] array) {
        if (array.length == 0) {
            return;
        }
        int firstPosition = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = firstPosition;
    }

    static void cycleSwap(int[] array, int shift) {
        if (array == null || array.length == 0 || shift <= 0 || shift > array.length) {
            return;
        }
        shift = shift % array.length;
        int[] result = new int[array.length];
        System.arraycopy(array, array.length - shift, result, 0, shift);
        System.arraycopy(array, 0, result, shift, array.length - shift);
        System.arraycopy(result, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 7, 4};
        CycleSwap.cycleSwap(array);
        System.out.println(Arrays.toString(array)); // Should be [4, 1, 3, 2, 7]

        int[] array2 = new int[]{1, 3, 2, 7, 4};
        CycleSwap.cycleSwap(array, 2);
        System.out.println(Arrays.toString(array2)); // Should be [7, 4, 1, 3, 2]

        int[] array3 = new int[]{1, 3, 2, 7, 4};
        CycleSwap.cycleSwap(array, 5);
        System.out.println(Arrays.toString(array3)); // Should be [1, 3, 2, 7, 4]
    }

}
