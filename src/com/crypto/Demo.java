package com.crypto;


public class Demo {
    public static void main(String[] args) {
        char[] text = {'a', 'H', 'E', 'l', 'l', 'O', 'w', 'o', 'r', 'L', 'd', 'Z', 'z'};
        String text1 = "govvnyxoqyyntylnombizdsxqiyebpsbcdwocckqo";
        char[] arr = text1.toCharArray();
        printArrayChar(arr);
        Cypher cypher = new ComplexCypher(new Cypher[] {
//                new SimplePermutationCypher(),
//                new BlockPermutationCypher(7),
//                new CaesarCypher(10),
                new BlockPermutationCypherMatrixImpl(4),
//                new HomeTaskDecodeText(10)
        });
        char[] encodedText = cypher.encode(text);
        printArrayChar(encodedText);
        char[] decoded = cypher.decode(arr);
        printArrayChar(decoded);

    }
    public static void printArrayChar(char[] array) {
        for (char c : array) {
            System.out.print(c);
        }
        System.out.println();
    }
}

    /*
        реализовать другие виды шифров, а именно -
        1 перестановка соседних символов  (банк - абкн), 2-1,4-3,6-5...
        2 блочные перестановки  - определяем длину блока - N, переворачиваем каждый блок длины N отдельно

        helloworld - при блоке по 3 превратится в lehwollrod

        применить принцип инкапсуляции на других иерархиях классов
     */