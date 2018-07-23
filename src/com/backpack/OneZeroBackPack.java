package com.backpack;

import java.util.Arrays;

/**
 * 01背包
 */
public class OneZeroBackPack {

    /**
     * 二维数组，可以追溯最佳路径
     *
     * @param N
     * @param C
     * @param W
     * @param V
     * @return
     */
    public static int[] oneZeroBackpack(int N, int C, int[] W, int[] V) {
        int[][] F = new int[N + 1][C + 1];

        int[] path = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= C; ++j) {
                if (j < W[i])
                    F[i][j] = F[i - 1][j];
                else
                    F[i][j] = Math.max(F[i - 1][j], F[i - 1][j - W[i]] + V[i]);
            }
        }

        for (int i = N; i >= 1; --i) {
            if (F[i][C] == F[i - 1][C]) {
                path[i] = 0;
            } else {
                path[i] = 1;
                C -= W[i];
            }
        }
        return path;
    }

    /**
     * 一維數組，不能追溯最優路徑
     *
     * @param N
     * @param C
     * @param W
     * @param V
     * @return
     */
    public static int oneZeroBackpack_up(int N, int C, int[] W, int[] V) {
        int[] F = new int[C + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = C; j >= W[i]; --j) {
                F[j] = Math.max(F[j], F[j - W[i]] + V[i]);
            }
        }
        return F[C];
    }


    public static void main(String[] args) {
        int[] W = {0, 4, 6, 2, 2, 5, 1};
        int[] V = {0, 8, 10, 6, 3, 7, 2};
        System.out.println(oneZeroBackpack_up(6, 12, W, V));

    }
}
