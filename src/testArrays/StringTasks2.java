package testArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StringTasks2 {
    public static void main(String[] args) {
        String[] input = {"apple", "banana", "apple", "orange", "banana", "grape"};
        String[] arr;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i].equals(input[j])) {

                }
            }
        }
        StringBuilder sb = new StringBuilder("Hello").reverse();
        System.out.println(sb);
        String s = "Hello world Java";
        System.out.println(reverse(s));
        System.out.println(mirrorReverse(s));
        containsEqualHash();
    }

    /**
     * @param input - "Hello world Java"
     * @return - "olleH dlrow avaJ"
     */
    public static String reverse(String input) {
        String[] separated = input.split(" ");
        return wordReverse(separated);
    }

    private static String wordReverse(String[] separated) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separated.length; i++) {
            char[] temp = separated[i].toCharArray();
            for (int left = 0, right = temp.length - 1; left < right; left++, right--) {
                char swap = temp[left];
                temp[left] = temp[right];
                temp[right] = swap;
            }
            sb.append(new String(temp));
            if (i != separated.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String mirrorReverse(String input) {
        StringBuilder sb = new StringBuilder(input).reverse();
        return sb.toString();
    }

    public static void containsEqualHash() {
        Random random = new Random();
        Map<Integer, String> data = new HashMap<>();
        int attempts = 0;
        while (true) {
            char[] temp = new char[9];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = (char) ('a' + random.nextInt(26));
            }
            String str = new String(temp);
            int hash = str.hashCode();
            attempts++;
            if (data.containsKey(hash) && !data.get(hash).equals(str)) {
                System.out.println("hashcode - " + hash);
                System.out.println(data.get(hash) + ", " + str);
                System.out.println("sum of attempts: " + attempts);
                break;
            }
            data.put(hash, str);
        }
    }
}
