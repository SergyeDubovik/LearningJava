package testArrays;

import static testArrays.Temp.insertionSort;
import static testArrays.ThreeDimArray.print2DArrayInt;

/**
 * есть массив, необходимо найти сумму элементов,
 * превышающих заданное число N
 */

public class TaskArrays {
    public static void main(String[] args) {

        int[] arr = {8, 5, 4, 2, 440, 5, 72, 11, 9};

//        printArray(bubbleSort(arr));

        int[][] arr1 = {
                {1, 2, 3, 6, 14, 2},
                {4, 9, 6, 54, 23, -4},
                {7, 8, 9, 6, 22, 8}
        };
        System.out.println(largerElement(arr1));

        System.out.println(secondMaxElement(arr));


        System.out.println(findAnyElement(arr, 4));
        print2DArrayInt(sortSecondRow(arr1));
        print2DArrayInt(sortSecondColumn(arr1));
        System.out.println();
        print2DArrayInt(makeArray(5,11));


    }

    private static void sum() {
        /*
        обьявить пустую сумму (равную нулю)
        для каждого элемента массива:
        проверить - если этот элемент больше чем n
        добавить его в сумму
         */
        int[] array = {12, -5, 66, 2, 31, 185, 1, 93, 50};
        int n = 92;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > n) {
//                sum = array[i] + sum;
                sum += array[i];
            }
        }
        System.out.println(sum);
    }

    public static void sumWhile() {
        int[] array = {112, -5, 2, 131, 1, 93, 150};
        int n = 92;
        int sum2 = 0;
        int i = 0;
        while (i < array.length) {
            if (array[i] > n) {
                sum2 = sum2 + array[i];
            }
            i++;
        }
        System.out.println(sum2);
    }

    public static void sumDoWhile() {
        int[] array = {132, -5, 2, 131, 1, 93, 150};
        int n = 92;
        int i = 0;
        int sum3 = 0;
        do {
            if (array[i] > n) {
                sum3 += array[i];
            }
            i++;

        } while (i < array.length);
        System.out.println(sum3);
    }

    private static void multiplication() {
        /*
        найти произведение последних пяти элементов массива

            объявить пустое произведение, равное 1
            пройтись по массиву с конца, но не выходя за пределы массива
            умножить произведение на элемент массива
         */
        int[] array = {4, 3};
        int mul = 1;
        for (int i = array.length - 1; i >= array.length - 5 && i >= 0; i--) {
            mul *= array[i];
        }
        System.out.println(mul);
    }

    /*
        Найти количество нечетных элементов массива

        обьявить переменную с количеством
        пройтись по массиву, чтоб вычислить нечетные
        каждый раз счетчик плюсовать на 1 когда найдем нечетное
     */
    private static void oddNumber() {
        int[] array2 = {52, 41, 33, 5, -4, 12};
        int amount = 0;
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] % 2 != 0) {
                amount++;
            }
        }
        System.out.println(amount);
    }

    /*
        Проверить наличие в данном массиве двух соседних положительных элементов

        создать массив
        пройтись по нему
        проверить на положительные и отрицательные
        если первый элемент положительный - проверить следующий, если да, то вывести ответ да
        если нет, то идти по массиву до тех пор, пока не найдется два соседних положительных



     */
    public static void positiveNeighbors() {
        int[] array3 = {2, -5, 66, -1, 3, -21};
        boolean result = false;
        for (int i = 0; i < array3.length - 1; i++) {
            if (array3[i] > 0 && array3[i + 1] > 0) {
                result = true;
            }
        }
        if (result) {
            System.out.println("Adjacent elements is positive");
        } else {
            System.out.println("Adjacent elements isn't positive");
        }


    }

    /*
            надо отсортировать массив по убыванию

            алгоритм вставками:
            делаем цикл i - проходим от второго до последнего элемента
            делаем цикл j - проходим от i до второго элемента
            внутри каждого цикла сравниваем j элемент и j - 1 элемент
            если он больше, то мы меняем местами элементы эти

     */
    private static void sort() {
        int[] array4 = {2, 7, 42, 3, 33, 5};
        int temp;
        for (int i = 1; i < array4.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array4[j] > array4[j - 1]) {
                    temp = array4[j];
                    array4[j] = array4[j - 1];
                    array4[j - 1] = temp;
                }
            }
        }
        printArray(array4);
    }

    public static int[] printArray(int[] array4) {
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");

        }
        return array4;
    }

    public static void printArrayLong(long[] array5) {
        for (int i = 0; i < array5.length; i++) {
            System.out.print(array5[i] + " ");
        }
    }

    /*
        1 чем будет отличаться сортировка от меньшего к большему
    */
    public static void sortFromBigger() {
        int[] array5 = {5, 44, -3, 21, 6};
        int temp;
        for (int i = 1; i < array5.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array5[j] > array5[j - 1]) {
                    temp = array5[j];
                    array5[j] = array5[j - 1];
                    array5[j - 1] = temp;
                }
            }
        }
        printArray(array5);
    }

    /*
        находим макс элемент
     */
    public static void maxElement() {
        int[] array6 = {5, 44, -3, 21, 6};
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] > result) {
                result = array6[i];
            }
        }
        System.out.println(result);
    }

    public static void minElement() {
        int[] array6 = {5, 44, -3, 21, 6};
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] < result) {
                result = array6[i];
            }
        }
        System.out.println(result);
    }

    /*
        сортировка выбором

        находим наибольший элемент
        меняем местами первый и найденый
        повторяем действие для остатка массива
     */
    public static void selectionSort() {
        int[] array7 = {3, 44, -1, 77, 8};
        for (int i = 0; i < array7.length - 1; i++) {

            int maxElementIndex = i;
            for (int j = i + 1; j < array7.length; j++) {
                if (array7[j] > array7[maxElementIndex]) {
                    maxElementIndex = j;
                }
            }

            array7[i] = array7[maxElementIndex] - array7[i];                    //2
            array7[maxElementIndex] = array7[maxElementIndex] - array7[i];      //3
            array7[i] = array7[i] + array7[maxElementIndex];                    //5

//             temp = array7[i];
//            array7[i] = array7[maxElementIndex];
//            array7[maxElementIndex] = temp;

        }
        for (int i = 0; i < array7.length; i++) {
            System.out.print(array7[i] + " ");
        }
    }

    /*
            1 придумать способ как поменять местами 2 числа без временной переменной
            2 как применить его в этом алгоритме сортировка выбором (селекшн сорт),
            3 и вывести от меньшего к большему
     */

    public static void swapElements() {
        int x = 8;
        int y = 11;

//        a = b - a;      // 2
//        b = b - a;      // 5
//        a = a + b;


        System.out.println(x);
        System.out.println(y);
    }

    /*
        найти колво отрицательных элементов в начале массива

        если в начале массива есть отрицательные числа, то идем дальше, пока не встретим положительные
        вывексти колво всех отрицательных
     */

    public static void countNegatives() {
        int[] array8 = {2, -4, -62, -3, -4, -41};
        int i = 0;
        while (i < array8.length && array8[i] < 0) {
            i++;
        }
        System.out.println(i);

        int a = -1;
        for (int j = 0; j < array8.length && array8[j] < 0; j++) {
            a = j;
        }
        System.out.println(a + 1);

    }

    /*
        1 посчитать количество четных элементов в конце массива

        2 первую задачу (sum) решить с помощью цикла while
     */

    public static void amountEvenNumbers() {
        int[] myArr = {2, 12, 46};
        int sum = 0;
        int i = myArr.length - 1;
        while (i >= 0 && myArr[i] % 2 == 0) {
            i--;
            sum++;
        }
        System.out.println(sum);
    }

    /*
        сортировка пузырком от меньшего
     */

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /*
        найти обьем воды в какой-то емкости, зная её профиль поперечного среза
     */

    public static int volumeWater(int[] array) {
        int resVolumeOfWater = 0;
        for (int i = 0; i < array.length; i++) {

        }
        return resVolumeOfWater;
    }

    /*
        1 найти наибольший элемент под главной диагональю
     */

    public static int largerElement(int[][] array) {
        int number = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i > j && array[i][j] > number) {
                    number = array[i][j];
                }
            }
        }
        return number;
    }
    /*
        2 найти второй наибольший элемент массива
     */

    public static int secondMaxElement(int[] array) {
        if (array.length <= 1) {
            throw new RuntimeException("Array has less than 2 elements");
        }
        int firstMaxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMaxValue) {
                secondMaxValue = firstMaxValue;
                firstMaxValue = array[i];
            }
            if (array[i] > secondMaxValue && array[i] < firstMaxValue) {
                secondMaxValue = array[i];
            }
        }
        return secondMaxValue;
    }
    /*
        3 в двумерном массиве упорядочить по возрастанию элементы второго столбца
     */

    public static int[][] sortSecondColumn(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j][1] < array[j - 1][1]) {
                    int temp = array[j][1];
                    array[j][1] = array[j - 1][1];
                    array[j - 1][1] = temp;
                }
            }
        }
        return array;
    }

    /*
        подумать над тем, как найти например 4-й макс элемент
     */
    public static int findAnyElement(int[] array, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            int maxElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxElementIndex]) {
                    maxElementIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[maxElementIndex];
            array[maxElementIndex] = temp;
        }
        return array[n - 1];
    }
    /*
        в двумерном массиве упорядочить по возрастанию элементы второй строки
     */
    public static int[][] sortSecondRow(int[][] array) {
        insertionSort(array[1]);
//        int temp;
//        for (int i = 1; i < array[1].length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (array[1][j] < array[1][j - 1]) {
//                    temp = array[1][j];
//                    array[1][j] = array[1][j - 1];
//                    array[1][j - 1] = temp;
//                }
//            }
//        }
        return array;
    }

        /* заполнить массив следующим образом:
        1 2 3 1 2
        3 1 2 3 1
        2 3 1 2 3
        1 2 3 1 2
        3 1 2 3 1
        то есть - дано 2 числа, первое - размер матрицы n*n, второе: k - цифра, до которой мы пробегаем
        в этом случае:
        n == 5
        k == 3
     */
    public static int[][] makeArray(int n, int k) {
        if (k <= 0 || n <= 0) {
            throw new IllegalArgumentException("n and k should be greater than zero");
        }
        int[][] myArray = new int[n][n];
        int inception = 1;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = inception;
                inception++;
                if (inception == k + 1) {
                    inception = 1;
                }
            }
        }
        return myArray;
    }

}
