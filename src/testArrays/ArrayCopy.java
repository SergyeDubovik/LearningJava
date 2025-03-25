package testArrays;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] first = {1, 5, 23, 11};
        int[] second = {3, 12, 7, 8, 10, -4};
        arraycopy(first, 1, second, 2, 2);
        System.out.println(Arrays.toString(second));
    }

    private static void arraycopy(int[] arr1, int sourcePos, int[] arr2, int destPos, int length) {
        if (arr1 == null || arr2 == null) {
            throw new NullPointerException("Source or destination array couldn't be empty");
        }
        if (sourcePos > arr1.length || destPos > arr2.length) {
            throw new IndexOutOfBoundsException("Array length shorter than specified index");
        }
        for (int i = 0; i < length; i++) {
            arr2[destPos + i] = arr1[sourcePos + i];
        }
    }
}
