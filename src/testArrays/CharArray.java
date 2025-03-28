package testArrays;
/*
    проверить, является ли строка палиндромом
 */

public class CharArray {
    public static void main(String[] args) {
        task2();
        int result = powerTwo(2);
        System.out.println(result);
        System.out.println(powerTwo(result));
        System.out.println(powerTwo(powerTwo(result)));
        result = sum2(result, 4);
        System.out.println(result);
        int a = 3;
        int b = 5;
        result = powerTwo(a) + powerTwo(b);
        System.out.println(result);

        boolean res = task2(new char[]{')', 'j', '[', ']', 'O'}, '[', ']');
        System.out.println(res);
        res = task2(new char[]{')', 'j', '[', ']', 'O'}, '(', ')');
        System.out.println(res);

        char[] array2 = {'5',')', 'g', '0','2', '9', '(', '{', '(', 'H', 'D', ')', ')'};
        String res2 = numbersOrLetters(array2);
        System.out.println(res2);

        int[] array = {2, 5, -6, 21, 3, 18};
        arraySort(array);

    }

    private static void palindrome() {
        char[] pal = {'a', 'b', 'c', 'b', 'a',};
        boolean res = true;
        for (int i = 0; i < pal.length / 2; i++) {
            if (pal[i] != pal[pal.length - 1 - i]) {
                res = false;
                break;
            }

        }
        System.out.println("palindrome: " + res);
    }
    /*
        превратить все буквы в заглавные

        проверить, если символ является маленькой буквой (от 97 до 122), то вычитаем 32 от него
        остальные не трогаем
     */
    private static void bigLetters() {
        char[] array = {')', '(', '4', ':', ' ', 'j'};
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 97 && array[i] <= 122) {
                array[i] -= 32;
            }
        }
        for (char c : array) {
            System.out.print(c + " ");

        }
    }

    /*
            1 превратить большие буквы в маленькие
     */
    private static void turnToUppercase() {
        char[] letters = {'J', 'A', 'p','Z','@', '3','[', '"', 'G', 'c', '[', 'W', 'e'};
        for (int i = 0; i < letters.length; i++){
            if (letters[i] >= 65 && letters[i] <= 90) {
                letters[i] += 32;
            }
        }
        for (char letter : letters) {
            System.out.print(letter + " ");
        }
    }
    /*
        2 проверить, все ли открывающиеся скобки закрываются в этой строке
        (должны совпадать скобки, открываться и закрываться, если 2 открыты, то должны быть и две закрывающиеся)

        алгоритм:
        обьявляем 2 счетчика откр и закр скобок (==0)
        проходим по массиву с начала до конца
        если текущий эл массива - откр скобка, то добавляем в счетчик открывающихся
        а если закр скобка - то проверяем, еслть ли уже откр скобки (разница между откр и закр счетчиками > 0)
        добавляем в счетчик закр скобку
        после цикла сравниваем 2 счетчика, если они равны - то ответ да, если нет - то нет
     */
    private static void task2() {
        char[] brackets = {'5',')', 'g','(','(', '(', 'H', 'D', ')', ')'};
        int openBrackets = 0;
        int closedBrackets = 0;
        for (char bracket : brackets) {
            if (bracket == '(') {
                openBrackets++;
            } else if (bracket == ')') {
                closedBrackets++;
            }
        }
        System.out.println(openBrackets == closedBrackets);
    }

    private static boolean task2(char[] array, char left, char right) {
        int openBrackets = 0;
        int closedBrackets = 0;
        for (char c : array) {
            if (c == left) {
                openBrackets++;
            } else if (c == right) {
                closedBrackets++;
            }
        }
        return openBrackets == closedBrackets;
    }

    private static int powerTwo(int a) {
        return a * a;
    }
    private static int sum2(int a, int b) {
        return a + b;
    }

    /*
        1 определить, чего в массиве больше - цифр или латинских букв

        алгоритм:
        создаем две переменные, счётчики
        находим в массиве цифры и буквы и добавляем их к соотв счетчику
        сравниваем их, и выводим в ответ то, чего получилось больше
    */

    private static String numbersOrLetters(char[] array2) {

        int z = 0;
        int x = 0;
        for (char c : array2) {
            if (c >= 48 && c <= 57) {
                z++;
            } else if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                x++;
            }

        }
        if (z > x) {
            return "Numbers more than letters";
        } else if (z < x){
            return "Letters more than numbers";
        } else {
            return "Number equals Letters";
        }
    }
    /*

        2 написать функцию распечатки массива, и взять любой алгоритм сортировки
         и распечатывать массив на каждом изменении массива
     */
    private static int[] arraySort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                int currentElement;
                if (array[j] > array[j - 1]) {
                    currentElement = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = currentElement;
                    printArray(array);

                }
            }
        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void printArrayLong(long[] array) {
        for (long l : array) {
            System.out.println(l + " ");
        }
        System.out.println();
    }


}

