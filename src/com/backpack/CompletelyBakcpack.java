package com.backpack;

import java.util.Arrays;

public class CompletelyBakcpack {
    /**
     * 二维数组，可以追溯最佳路径
     *
     * @param W
     * @param V
     * @param N
     * @param C
     * @return
     */
    public static int[] multipleBackPack(int[] W, int[] V, int N, int C) {
        int[][] F = new int[N + 1][C + 1];
        int[] res = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                if (j >= W[i])
                    F[i][j] = Math.max(F[i - 1][j], F[i][j - W[i]] + V[i]);
                else
                    F[i][j] = F[i - 1][j];
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = N; i >= 1; --i) {
            if (C >= W[i] && F[i][C] == F[i][C - W[i]] + V[i]) {
                int k = 0;
                while (C >= W[i] && F[i][C] == F[i][C - W[i]] + V[i]) {
                    C -= W[i];
                    ++k;
                }
                res[i] = k;
            } else {
                res[i] = 0;
            }
        }

        return res;
    }


    /**
     * @param W
     * @param V
     * @param N
     * @param C
     * @return
     */
    public static int multipleBackPack_up(int[] W, int[] V, int N, int C) {
        int[] F = new int[C + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                if (j >= W[i])
                    F[j] = Math.max(F[j], F[j - W[i]] + V[i]);
            }
        }
        return F[C];
    }


    public static void main(String[] args) {
        int[] W = {0, 2, 3, 4, 7};
        int[] V = {0, 1, 3, 5, 9};

        System.out.println(multipleBackPack_up(W, V, 4, 10));
    }
}
