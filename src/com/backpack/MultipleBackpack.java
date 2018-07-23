package com.backpack;

import java.util.Arrays;

public class MultipleBackpack {
    public static int[] multipleBackPack(int[] W, int[] M, int[] V, int N, int C) {
        int[][] F = new int[N + 1][C + 1];
        int[] res = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                int temp_max = F[i - 1][j];
                for (int k = 1; k <= Math.min(M[i], j / W[i]); ++k) {
                    temp_max = Math.max(temp_max, F[i - 1][j - k * W[i]] + k * V[i]);
                }
                F[i][j] = temp_max;
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = N; i >= 1; --i) {
            if (F[i][C] == F[i - 1][C]) {
                res[i] = 0;
            } else {
                int k = Math.min(M[i], C / W[i]);
                for (; k >= 1; --k) {
                    if (F[i][C] == (F[i - 1][C - k * W[i]] + k * V[i])) {
                        res[i] = k;
                        C -= k * W[i];
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] W = {0, 1, 2, 2}, V = {0, 6, 10, 20}, M = {0, 10, 5, 2};
        System.out.println(Arrays.toString(multipleBackPack(W, M, V, 3, 8)));
    }
}
