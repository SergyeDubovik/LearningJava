package testArrays;

import com.objects.stats.Stats;

public class ThreeDimArray {
    public static void main(String[] args) {
        int[][] array = {{2, 3, 7},
                {-5, 5, -66},
                {1, -22, 12}};
//        print2ArrayInt(generateArray3(10));

//        char[] letters = {'c', 'r', 'e', 'a', 't', 'e', ' ', 'a', 'r', 'r', 'a', 'y'};
//        printArrayChar(someWord(letters));
//        System.out.println();
//        System.out.println(isPrime(2147483647));
//
//        int[] array1 = {1, 66, -8, 5, 13, 4};
//        System.out.println(sumEvenElements(array1));
        print2DArrayInt(chess(5));

        int[] elements = {2, 144, -7, 5, 66, 1, 2, 31, 7, 12};
        System.out.println(findMax(elements, 3));
        System.out.println(findMin(elements, 5));
        System.out.println(findAverage(elements, 2));
        Stats s = calculateStats(elements, 7);
        s.print();
    }

    public static void print2DArrayInt(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }

    public static void printArrayChar(char[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
    }

    /*
        найти сумму элементов 2-мерного массива, расположеных на главной диагонали
     */

    public static int sumMainDiagonal(int[][] myArray) {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (i == j) {
                    sum = sum + myArray[i][j];
                }
            }
        }
        return sum;

    }

    /*
        найти сумму элементов, второй строки и третьего столбца
     */

    public static int sumOf2(int[][] myArray2) {
        int sum = 0;
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2[i].length; j++) {
                if (i == 1 || j == 2) {
                    sum += myArray2[i][j];
                }
            }
        }
        return sum;
    }

    /*
        1 найти произведение элементов 2 - мерного массива, расположеных на побочной диагонали
     */
    public static int multiplication(int[][] ar) {
        int sumMultiplication = 1;
        for (int i = ar.length - 1; i >= 0; i--) {
            for (int j = ar[i].length - 1; j >= 0; j--) {
                if (i + j == ar.length - 1) {
                    sumMultiplication *= ar[i][j];
                }
            }
        }
        return sumMultiplication;
    }

    /*
        2 найти наименьший элемент третьей строки и первого столбца
     */

    public static int smallestElement(int[][] ar) {
        int smaller = Integer.MAX_VALUE;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] < smaller && (j == 0 || i == 2)) {
                    smaller = ar[i][j];
                }
            }
        }
        return smaller;
    }

    /*
     00001
     00011
     00111
     00011
     00001
     */

    public static int[][] generateArray1(int x) {
        int[][] newArray = new int[x][x];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if ((i + j <= x - 1) && (i >= j)) {
                    newArray[i][j] = 1;
                }
            }
        }
        return newArray;
    }

    /*
        1 2 3 . . . . .10
        0 1 2 . . . . .9
        0 0 1 . . . . .8
        . . . . . . . . . .
        0 0 0 0 . . . 1
     */

    public static int[][] generateArray2(int y) {
        int[][] myArray = new int[y][y];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                if (i == j) {
                    myArray[i][j] = 1;
                } else if (i < j) {
                    myArray[i][j] = myArray[i][j - 1] + 1;
                }
            }
        }
        return myArray;
    }

    /*
        1 2 3 4 5 . . . 10
        11 12 13 . . . 20
        21 22 23 . . . 30
        . . . . . . . . . . . .
        91 92 93 . . . 100
     */

    public static int[][] generateArray3(int c) {
        int[][] myArray2 = new int[c][c];
        int inception = 1;
        for (int i = 0; i < myArray2.length; i++) {
            for (int j = 0; j < myArray2[i].length; j++) {
                myArray2[i][j] = inception;
                inception++;
            }
        }
        return myArray2;
    }

    /*
        из одномерного массива символов распечатать первое слово из него до пробела (слова разделены пробелом)
     */

    public static char[] someWord(char[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 32) {
                temp = i;
                break;
            }
        }
        char[] newWord = new char[temp];
        for (int i = 0; i < newWord.length; i++) {
            newWord[i] = array[i];
        }
        return newWord;
    }

    /*
        проверить число на простоту
     */

    public static boolean isPrime(int x) {
        for (int i = 2; i < x / 2; i++) {
            if (x % i == 0) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    /*
        1 заполнить 2-мерный массив 1 и 0 в шахматном порядке
     */

    public static int[][] chess(int size) {
        int[][] newArray = new int[size][size];
        int q = 1;
        int w = 5;
        for (int i = 0; i < newArray.length; i++) {
            for (int z = 0; z < newArray[i].length; z++) {
                if ((i + z) % 2 == 0) {
                    newArray[i][z] = q;
                } else {
                    newArray[i][z] = w;
                }

            }
        }
        return newArray;
    }

    /*
        2 найти сумму четных элементов массива
     */

    public static int sumEvenElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    /*
        есть массив из чисел, найти наибольшее, среднее и наименьшее за неделю
     */

    public static int findMax(int[] array, int n) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= array.length - n && i >= 0; i--) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static int findMin(int[] array, int n) {
        int minValue = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= array.length - n && i >= 0; i--) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    public static double findAverage(int[] array, int n) {
        int sum = 0;
        for (int i = array.length - 1; i >= array.length - n && i >= 0; i--) {
            sum += array[i];
        }
        return (double) sum / n;
    }

    public static Stats calculateStats(int[] array, int n) {
        Stats s = new Stats(findMax(array, n), findMin(array, n), findAverage(array, n));
        return s;
    }

}
