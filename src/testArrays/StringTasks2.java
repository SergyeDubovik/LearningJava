package testArrays;

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
    }

    /**
     *
     * @param input - "Hello world Java"
     * @return - "olleH dlrow avaJ"
     */
    public static String reverse(String input) {
        String[] separated = input.split(" ");
        StringBuilder sb = new StringBuilder();
        char[] temp;
        for (int i = 0; i < separated.length; i++) {
            temp = separated[i].toCharArray();
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
}
