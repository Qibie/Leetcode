package com.leetcode.zbf;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int column = matrix[0].length, row = matrix.length, start = 0;
        while (column > 2 * start && row > 2 * start) {
            printNumber(matrix, start, result);
            ++start;
        }
        return result;
    }

    public void printNumber(int[][] matrix, int start, ArrayList<Integer> result) {
        int column = matrix[0].length, row = matrix.length;
        int endx = column - start - 1, endy = row - start - 1;
        if (start <= endx) {
            for (int i = start; i <= endx; ++i) {
                result.add(matrix[start][i]);
            }
        }
        if (start < endy) {
            for (int i = start + 1; i <= endy; ++i) {
                result.add(matrix[i][endx]);
            }
        }
        if (start < endx && start < endy) {
            for (int i = endx - 1; i >= start; --i) {
                result.add(matrix[endy][i]);
            }
        }
        if (start < endy - 1 && start < endx) {
            for (int i = endy - 1; i > start; --i) {
                result.add(matrix[i][start]);
            }
        }
    }
}
