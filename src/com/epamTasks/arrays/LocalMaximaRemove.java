package com.epamTasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    /*
        implement the `removeLocalMaxima` method.

        The correct implementation should receive an array of `int` values
        and return a copy of a given array with all local maxima removed in it.
        The original array must not be changed.

        **Local maximum** is an element that is bigger that any of its neighbour elements.
        You should remove elements that are local maxima in the original array.

        Details:
        - The size of given array is guaranteed to be more than 1.
        - Given array is guaranteed to be not null.
        - If the array has no local maxima, then you should return its copy without changes.
        - You may use java.util.Arrays.* methods.

        ### Example

        Input array: `[18, 1, 3, 6, 7, -5]`

        Output array: `[1, 3, 6, -5]`
     */
    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException();
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array.length > 1 && array[i] > array[i + 1]) {
                    continue;
                }
            } else if (i == array.length - 1) {
                if (array[i] > array[i - 1]) {
                    continue;
                }
            } else {
                if (array[i] > array[i + 1] && array[i] > array[i - 1]) {
                    continue;
                }
            }
            resultList.add(array[i]);
        }
        int[] resultArray = new int[resultList.size()];
        for (int j = 0; j < resultArray.length; j++) {
            resultArray[j] = resultList.get(j);
        }
        return resultArray;
    }

}
