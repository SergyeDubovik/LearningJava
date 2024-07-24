package testArrays;

import java.util.Arrays;

public class StringTasks {
    /*
        дано: массив из строк, напечатать те их них, которые содержат выбраный символ
     */
    public static void main(String[] args) {
        String[] strings = {"toronto", "asWE", "a12ff, ", "tente", "!приВет", "hey!!", "S", "Cat"};
//        System.out.println(String.join(", ", strings));
        String str = """
                @ first
                @ second
                @ third and fourth
                """;
        char symbol = '!';

        String shopping = " milk; sugar; tomato; bread";
//        System.out.println(formatBySemicolons(shopping));
//        System.out.println();

        String[] forbiddenGoods = {"milk", "meat", "butter", "egg"};
        String shoppingList = "garlic, meat, melon, 10 eggs";
//        System.out.println(buyHealthyGoods(forbiddenGoods, shoppingList));

        String[] words = {"flair slap", "second", "third la", "bla bla bla"};
        String substring = "la";
        contains(words, substring);

    }

    public static void printIfContains(String[] strings, char symbol) {
        for (int i = 0; i < strings.length; i++) {
            char[] result = strings[i].toCharArray();
            for (int j = 0; j < result.length; j++) {
                if (result[j] == symbol) {
                    System.out.println(strings[i]);
                    break;
                }
            }
        }
    }

    public static void printIfContainsOptimised(String[] strings, char symbol) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].indexOf(symbol) >= 0) {
                System.out.println(strings[i]);
            }
        }
    }

    /*
        1 напечатать все строки из массива строк, которые содержат хотя бы одну большую букву
        2 напечатать все строки из массива строк, которые заканчиваются на те же самые 2 буквы, на которые начинаются
        (например: "Hello He" или "abcdab")
        3 почитать код и разобраться с тем, как сравниваются строки в java, а именно equals and hashCode
         3.1 придумать две строки, у которых будет одинаковый хешкод
     */
    public static void bigLetterContains(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            char[] result = strings[i].toCharArray();
            for (int j = 0; j < result.length; j++) {
                if ((result[j] >= 65 && result[j] <= 90) || (result[j] >= 'А' && result[j] <= 'Я')) {
                    System.out.print(strings[i] + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    public static void sameLettersSuffix(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            char[] res = strings[i].toCharArray();
            if (res.length > 3 && res[0] == res[res.length - 2] && res[1] == res[res.length - 1]) {
                System.out.println(strings[i]);
            }
        }
    }

    public static void sameLettersSuffixOptimised(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (s.length() > 3 && s.charAt(0) == s.charAt(s.length() - 2) && s.charAt(1) == s.charAt(s.length() - 1)) {
                System.out.println(s);
            }
        }
    }

    public static void sameLettersSuffixOptimised2(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 3) {
                String prefix = strings[i].substring(0, 2);
                if (strings[i].endsWith(prefix)) {
                    System.out.println(strings[i]);
                }

            }
        }
    }

    /*
        преобразовать не нумерованый список в нумерованый
     */
    public static String transformList(String string) {
        int numberOfPoints = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '@') {
                numberOfPoints++;
            }
        }
        String result = string;
        for (int i = 1; i < numberOfPoints + 1; i++) {
            result = result.replaceFirst("@", i + ")");
        }
        return result;
    }

    /*
        1. дана строка, добавить перенос строки после каждой точки с запятой
    */
    public static String formatBySemicolons(String string) {
        return string.replace(";", ";\n");
    }

    /*
        2. написать цензора - дано: строка и массив из строк, задача - в строке заменить любое слово, которое входит
         в этот массив строк на звездочки, например: "2 eggs, beacon, green onion, salt"
         {"egg", "beacon", "meat"}

         алгоритм:
            пройтись по запрещенным словам, создать звездочки по длине этих слов
            заменить результат в списке покупок, если там есть такие слова - они будут запиканы звездами
     */
    public static String buyHealthyGoods(String[] keyWords, String list) {
        String changed = list;
        for (int i = 0; i < keyWords.length; i++) {
            int wordLength = keyWords[i].length();
            String censor = "*".repeat(wordLength);
            changed = changed.replace(keyWords[i], censor);
        }
        return changed;
    }

    /*
        1
        из списка строк распечатать те их них, которые содержат указаное слово 2 раза,
        например: "first", "second", "third la", "bla bla bla";
        указанная подстрока - "la"
     */
    public static void contains(String[] array, String substring) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i].indexOf(substring);
            int second = array[i].lastIndexOf(substring);
            if (first != second) {
                System.out.println(array[i]);
            }
        }
    }
    /*
        2
        написать фильтрацию для книг по разным критериям, например: фильтрация по автору, по году издания, и т.д.
     */
}
