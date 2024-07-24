package com.crypto;

public class BlockPermutationCypher extends SymmetricCypher {
    private int n;
    public BlockPermutationCypher(int blockSize) {
        n = blockSize;
    }
    @Override
    public char[] encode(char[] open) {
        char[] res = new char[open.length];
        for (int j = 0; j < open.length; j++) {
            res[j] = open[j];
        }
        for (int i = 0; i < res.length - n + 1; i += n) {
            swapBlock(res, i);
        }
        return res;
    }

    private void swapBlock(char[] array, int startingIndex) {
        for (int i = 0; i <= (n / 2) - 1; i++) {
            char temp = array[i + startingIndex];
            array[i + startingIndex] = array[startingIndex + n - 1 - i];
            array[startingIndex + n - 1 - i] = temp;
        }
    }


}
//  1 добить эту задачу с блоком (перевернуть каждую строчку полученой матрицы и преобразовать обратно в одномерный массив)
//  2 придумать свой шифр и реализовать шифрование и дешифрование