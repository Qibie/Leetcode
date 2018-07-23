package com.backtracking;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.PortableInterceptor.INACTIVE;

public class EightQueens {

    public int queen_itertable(int n) {
        int[] queen = new int[n];
        int count = 0, k = 0;
        for (int i = 0; i < n; ++i)
            queen[i] = Integer.MAX_VALUE;
        while (k < n) {
            int begin = queen[k] == Integer.MAX_VALUE ? 0 : queen[k];
            queen[k] = Integer.MAX_VALUE;
            for (int i = begin; i < n; ++i) {
                if (!check(queen, k, i))
                    continue;
                queen[k] = i;
                break;
            }
            if (queen[k] == Integer.MAX_VALUE) {
                if (k != 0) {
                    --k;
                    queen[k] = queen[k]+1;
                    continue;
                }
                break;
            } else {
                if (k == 7) {
                    ++count;
                    queen[k] = Integer.MAX_VALUE;
                    --k;
                    queen[k] = queen[k]+1;
                } else {
                    ++k;
                }
            }

        }
        return count;
    }


    public void precess(int n, int[] queen, int k, int[] count) {
        if (k == n) {
            ++count[0];
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!check(queen, k, i))
                continue;
            queen[k] = i;
            precess(n, queen, k + 1, count);
        }
    }


    /**
     * 检测row 行 col列是否合格
     *
     * @param queen
     * @param row
     * @param col
     * @return
     */
    public boolean check(int[] queen, int row, int col) {
        //首先检测行
        for (int i = 0; i < row; ++i) {
            if (queen[i] == col)
                return false;
        }
        //对角线检测
        for (int i = 0; i < row; ++i) {
            if ((row - i) == Math.abs(col - queen[i]))
                return false;
        }
        return true;
    }


    public int NQueen(int n) {
        if (n <= 2)
            return 0;
        int[] queen = new int[n], count = new int[1];
        precess(n, queen, 0, count);
        return count[0];
    }

    public static void main(String[] args) {
        System.out.println(new EightQueens().queen_itertable(8));
    }


}
