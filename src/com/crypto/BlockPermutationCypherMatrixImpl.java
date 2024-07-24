package com.crypto;

public class BlockPermutationCypherMatrixImpl extends SymmetricCypher {
    private int n;
    public BlockPermutationCypherMatrixImpl(int blockSize) {
        n = blockSize;
    }
    @Override
    public char[] encode(char[] open) {
        char[][] tmp = split(open);
        tmp = swapBlocks(tmp);
        return join(tmp);
    }


    private char[][] split(char[] array) {
        char[][] result = new char[array.length / n + 1][];
        for (int i = 0; i < result.length; i++) {
            if (result.length - 1 == i) {
                result[i] = new char[array.length % n];
            } else {
                result[i] = new char[n];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = array[i * n + j];
            }
        }
        return result;
    }

    private char[][] swapBlocks(char[][] blocks) {
        char[][] reversed = new char[blocks.length][];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = new char[blocks[i].length];
        }
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                reversed[i][j] = blocks[i][blocks[i].length - 1 - j];
            }
        }
        return reversed;
    }

    private char[] join(char[][] blocks) {
        int length = 0;
        for (int i = 0; i < blocks.length; i++) {
            length += blocks[i].length;
        }

        char[] result = new char[length];
        int index = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                result[index++] = blocks[i][j];
            }
        }

        return result;
    }
}
//  1 добить эту задачу с блоком (перевернуть каждую строчку полученой матрицы и преобразовать обратно в одномерный массив)
//  2 придумать свой шифр и реализовать шифрование и дешифрование