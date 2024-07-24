package lessons;

/*
        1 Найти количество нечетных элементов массива

        2 Проверить наличие в данном массиве двух соседних четных элементов
 */


public class Test3 {
    public static void main(String[] args) {
        positiveAdjacentElements();
        sumOdd();

        double s = 4;
        System.out.println(squareS(s));

    }

    private static void positiveAdjacentElements() {
        int[] array11 = {5, 11, -62, 5, 88, 32};
        boolean res = false;
        for (int i = 0; i < array11.length - 1; i++) {
            if (array11[i] % 2 == 0 && array11[i + 1] % 2 == 0) {
                res = true;
            }
        }
        if (res) {
            System.out.println("We have 2 even elements");
        } else {
            System.out.println("We don't have 2 even elements");
        }


    }

    private static void sumOdd() {
        int[] array = {5, 11, -62, 52, 88, 32};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static double squareS(double side) {
        double res = Math.pow(side, 2);
        return res;
    }



}
