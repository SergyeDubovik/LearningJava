package testArrays;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] first = {1};
        int[] second = {3, 12, 7, 8, 10, -4};
        int[] array = new int[0];
        int[] array2 = new int[0];
        arraycopy(first, 0, second, 0, 1);
        System.out.println(Arrays.toString(second));
    }

    private static void arraycopy(int[] source, int sourcePos, int[] destination, int destPos, int length) {
        if (source == null || destination == null) {
            throw new NullPointerException("Source or destination array couldn't be null");
        }
        if (sourcePos > source.length || destPos > destination.length) {
            throw new IndexOutOfBoundsException("Array length shorter than specified index");
        }
        for (int i = 0; i < length; i++) {
            destination[destPos + i] = source[sourcePos + i];
        }
    }
}
