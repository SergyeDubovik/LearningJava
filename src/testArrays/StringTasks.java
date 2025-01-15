package testArrays;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StringTasks {
    /*
        дано: массив из строк, напечатать те их них, которые содержат выбраный символ
     */
    public static void main(String[] args) {
        String[] strings = {"toronto", "asWE", "a12ff, ", "tent", "!приВет", "hey!!", "S", "Cat"};
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

        String string = "bla brr qwe  toc";
        System.out.println(reverseWordsInStringOptimized(string));

        String given = "17809";
        System.out.println(convertStringToInt(given));
        System.out.println(parseInt(given));
        System.out.println("--------------");
        File someText = new File("C:/users/Сергей/Desktop/some text.txt");
        calculateLettersCountStats();
        calculateLetterPercent(someText);
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

    /*
        2 надо написать метод который принимает строку , в которой слова разделены пробелами НО НЕ ОБЯЗАТЕЛЬНО ОДНИМ.
        Нужно перевернуть все слова внутри, пробелы сохранить и вернуть строку обратно.
        пример: ("bla bla bla  bla") -> ("alb alb alb  alb")
                ("bla brr, qwe  toc") -> ("alb ,rrb ewq  cot")
     */
    public static String reverseLineButSpaces(String newLine) {
        String[] words = newLine.split("\\s");
        String[] reverse = reverseWords(words);
        newLine = String.join(" ", reverse);
        return newLine;
    }

    public static String[] reverseWords(String[] a) {
        for (int i = 0; i < a.length; i++) {
            char[] symbols = a[i].toCharArray();
            a[i] = "";
            for (int j = symbols.length - 1; j >= 0; j--) {
                a[i] = a[i] + symbols[j];
            }
        }
        return a;
    }

    /*
        сделать тоже самое, что и выше, только решением как в методе encode класса SimplePermutationCypher
     */
    public static String reverseWordsInString(String input) {
        String[] words = input.split("\\s");
        String[] reverse = reverseWords2ndOption(words);
        input = String.join(" ", reverse);
        return input;
    }

    public static String[] reverseWords2ndOption(String[] b) {
        for (int i = 0; i < b.length; i++) {
            char[] result = b[i].toCharArray();
            b[i] = "";
            for (int j = 0; j < result.length; j++) {
                b[i] = b[i] + result[result.length - 1 - j];
            }
        }
        return b;
    }

    public static String reverseWordsInStringOptimized(String input) {
        String[] words = input.split("\\s");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(reverseString(words[i]));
            if (i != words.length - 1) {
                result.append(" ");
            }

        }
        return result.toString();
    }

    public static String reverseString(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }


    /*
    3 преобразовать строку в число,
    например: String "178" -> int 178
 */
    public static int convertStringToInt(String str) {
        int res = 0;
        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            int number = temp[i] - '0';
            res = res * 10 + number;
            if (temp[i] < 48 || 58 < temp[i]) {
                throw new IllegalArgumentException("number contains inappropriate symbols");
            }
        }
        return res;
    }

    // second and easier way to convert String to int

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    // есть строка, которая содержит текст, надо подсчитать статистику частоты использования слов разной длины,
    // слово из скольки букв чаще всего встречается в тексте

    public static void calculateLettersCountStats() {
        String text = "Хіба я що знаю? Хіба я знаю... Хіба я можу впевненим бути, що не відхиляться двері... " +
                " отак трошки, з легким скрипінням, і з невідомої темряви, такої глибокої та безконечної, " +
                "не почнуть виходити люди... всі ті, що складали у моє серце, як до власного сховку, свої надії, " +
                "гнів і страждання або криваву жорстокість звіра. Всі ті, що я не можу розминутись із ними, " +
                "що мене утомили... Що ж дивного в тім, коли вони ще раз прийдуть... От я їх вже бачу. " +
                "Ба, ба! Як вас багато... Се ви, що з вас витекла кров в маленьку дірку від солдатської кульки," +
                " а се ви... сухі препарати; вас завивали у білі мішки, гойдали на мотузках в повітрі," +
                " а потому складали в погано прикриті ями, звідки вас вигрібали собаки... " +
                "Ви дивитесь на мене з докором — і ваша правда. " +
                "Знаєте, я раз читав, як вас повішали цілих дванадцять… " +
                "Цілих дванадцять... і позіхнув. А другий раз звістку про ряд білих мішків заїв стиглою сливою. " +
                "Так взяв, знаєте, в пальці чудову сочисту сливу... і почув в роті приємний солодкий смак... " +
                "Ви бачите, я навіть не червонію, лице моє біле, як і у вас, бо жах висмоктав з мене всю кров. " +
                "Я не маю вже краплі гарячої крові й для тих живих мертвяків, серед яких ви йдете, як кривава мара. " +
                "Проходьте! Я утомився." +
                "А люди йдуть. За одним другий і третій, і так без кінця. Вороги й друзі, " +
                "близькі й сторонні — і всі кричать у мої вуха криком свого життя або своєї смерті, " +
                "і всі лишають на душі моїй сліди своїх підошов. Затулю вуха, замкну свою душу і буду кричати: " +
                "тут вхід не вільний!";
        Map<Integer, Integer> stats = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            int wordLength = word.length();
            if (stats.containsKey(wordLength)) {
                int value = stats.get(wordLength);
                stats.put(wordLength, value + 1);
            } else {
                stats.put(wordLength, 1);
            }
        }
        for (Integer k : stats.keySet()) {
            System.out.println(k + " = " + stats.get(k));
        }
        int maxValue = Integer.MIN_VALUE;
        int key = 0;
        for (Integer k : stats.keySet()) {
            if (stats.get(k) > maxValue) {
                maxValue = stats.get(k);
                key = k;
            }
        }
        System.out.println("This text contains the most frequently word " + key + " = " + maxValue);
    }

    // посчитать статистику частоты встречания букв в тексте в процентах

    public static void calculateLetterPercent(File file) {
        String text;
        StringBuilder sb = new StringBuilder();
        try (InputStream inStr = new FileInputStream(file)) {
            LineNumberReader nr = new LineNumberReader(new InputStreamReader(inStr));
            while ((text = nr.readLine()) != null) {
                sb.append(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<Character, Integer> stats = new HashMap<>();
        int totalLetters = 0;
        for (char symbol : sb.toString().toCharArray()) {
            if (Character.isLetter(symbol)) {
                stats.put(Character.toLowerCase(symbol), stats.getOrDefault(symbol, 0) + 1);
                totalLetters++;
            }
        }
        System.out.println('\n' + "letter stats count in the text:");
        for (Character k : stats.keySet()) {
            float percent = ((float)stats.get(k) / totalLetters) * 100;
            System.out.println(k + " - " + percent + " %");
        }
        int maxValue = Integer.MIN_VALUE;
        char key = 0;
        for (Character k : stats.keySet()) {
            if (stats.get(k) > maxValue) {
                maxValue = stats.get(k);
                key = k;
            }
        }
        System.out.println("the most frequently used letter in this text is: " + key + " - " + maxValue + " times");
    }

}
