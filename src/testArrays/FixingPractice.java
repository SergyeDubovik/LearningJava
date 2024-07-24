package testArrays;

public class FixingPractice {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 5, 3};
        int[] actual = insert(array, 2, 7);
        assertArrayEquals(new int[]{1, 2, 7, 2, 5, 3}, actual);
        actual = insert(array, 0, 7);
        assertArrayEquals(new int[]{7, 1, 2, 2, 5, 3}, actual);
        actual = insert(array, 5, 8);
        assertArrayEquals(new int[]{1, 2, 2, 5, 3, 8}, actual);

        actual = remove(array, 2);
        assertArrayEquals(new int[]{1, 2, 5, 3}, actual);
        actual = remove(array, 0);
        assertArrayEquals(new int[]{2, 2, 5, 3}, actual);
        actual = remove(array, 4);
        assertArrayEquals(new int[]{1, 2, 2, 5}, actual);


        assertTrue(contains(array, 1));
        assertTrue(contains(array, 2));
        assertTrue(contains(array, 5));
        assertTrue(!contains(array, 7));
        assertTrue(!contains(array, 8));
        assertTrue(!contains(actual, 3));
    }

    /**
     * Insert an element into array by index. Shift all other elements to the right.
     *
     * @param array origin array
     * @param index position where to insert new element
     * @param value new element value
     * @return array with inserted element
     */
    private static int[] insert(int[] array, int index, int value) {
        int[] result = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }
        result[index] = value;
        for (int i = index + 1; i < result.length; i++) {
            result[i] = array[i - 1];
        }
        return result;
    }

    /**
     * Remove element with selected index from array. Shift all other elements to the left.
     *
     * @param array origin array
     * @param index position from where to remove an element
     * @return array with removed element
     */
    private static int[] remove(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0; i < index; i++) {
            result[i] = array[i];
        }
        for (int i = index; i < array.length - 1; i++) {
            result[i] = array[i + 1];
        }
        return result;
    }

    /**
     * Check whether an array contains a value.
     *
     * @param array an array
     * @param value a value
     * @return true if array contains a value or false otherwise.
     */
    private static boolean contains(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static void assertArrayEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (actual[i] != expected[i]) {
                throw new RuntimeException("Expected " + expected[i] + " but got " + actual[i]);
            }
        }
    }

    private static void assertTrue(boolean actual) {
        if (!actual) {
            throw new RuntimeException("Not true");
        }
    }
}
