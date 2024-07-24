package lessons;

import static testArrays.TaskArrays.printArray;

public class NewtonsBinomial {
    public static void main(String[] args) {
        int[] array = calculate(20);
    }
    public static int[] calculate(int n) {
        if (n == 1) {
            return new int[] {1};
        }
        int[] temp = calculate(n - 1);
        int[] result = new int[n];
        result[0] = 1;
        result[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            result[i] = temp[i - 1] + temp[i];
        }
        printArray(result);
        System.out.println();
        return result;
    }
}
/*
    1 сделать иерархию для библиотеки (у каждой книги должен быть автор или набор авторов, колво страниц, год издания,
    издательство, жанр)
    2 реализовать сравнение книг по авторству (1 автор может написать несколько книг, одна и та же книга может быть
    издана разными издателями)

    дано: 2 отсортированых массива чисел, задача - обьединить их в 1 отсортированный массив, например:
    1, 4, 12 и 3, 3, 8, 14 превращаются в 1, 3, 3, 4, 8, 12, 14
    подумать о том, как оптимизировать решение и реализовать без сортировки
 */
