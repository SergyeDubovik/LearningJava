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
    }
}
