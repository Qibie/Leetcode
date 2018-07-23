package com.leetcode.zbf;

public class MatrixMultiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }
        int length = A.length;
        int[] B = new int[length];
        if (length == 1) {
            B[0] = A[0];
            return B;
        }
        B[0] = 1;
        for (int i = 1; i < length; ++i) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = length - 2; i >=0 ; --i) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
