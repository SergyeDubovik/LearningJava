package com.epamTasks;

import java.util.Arrays;

public class SumOfPrevious {

    /*
        implement getSumCheckArray method.

        The correct implementation should receive an array of int values and return an array of booleans
        where each element is a result of a check if a corresponding element is a sum of two previous elements in given array.

        Details:

        The length of given array is guaranteed to be 2 or more.
        Given array is guaranteed to be not null.
        Method returns an array of booleans where each element is a result for corresponding element in given array.
        First two elements of the boolean array are always false.

        Example
        Input array: [1, -1, 0, 4, 6, 10, 15, 25]

        Output array: [false, false, true, false, false, true, false, true]
     */
    public static void main(String[] args) {
        int[] array = {1, -1, 0, 4, 6, 10, 15, 25};
        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){
        boolean[] result = new boolean[array.length];
        result[0] = false;
        result[1] = false;

        for (int i = 2; i < array.length; i++) {
            result[i] = array[i] == array[i - 1] + array[i - 2];
        }
        return result;
    }
}
