package com.leetcode.zbf;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int row = A.length, column = A[0].length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
