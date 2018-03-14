package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry on 18-3-6.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        final int LENGTH = 9;

        List<Character> characterList = new ArrayList<Character>();
        //检查每行
        for (int i = 0; i < LENGTH; ++i) {
            characterList.clear();
            for (int j = 0; j < LENGTH; ++j) {
                if (board[i][j] != '.' && characterList.contains(board[i][j])) {
                    return false;
                }
                characterList.add(board[i][j]);
            }
        }

        //检查每列
        for (int i = 0; i < LENGTH; ++i) {
            characterList.clear();
            for (int j = 0; j < LENGTH; ++j) {
                if (board[j][i] != '.' && characterList.contains(board[j][i])) {
                    return false;
                }
                characterList.add(board[j][i]);
            }
        }
        //检查每一个九宫格
        for (int i = 0; i <= LENGTH - 3; i += 3) {
            for (int j = 0; j <= LENGTH - 3; j += 3) {
                characterList.clear();
                for (int k = 0; k < 3; ++k) {
                    for (int t = 0; t < 3; ++t) {
                        if (board[i + k][j + t] != '.' && characterList.contains(board[i + k][j + t])) {
                            return false;
                        }
                        characterList.add(board[i + k][j + t]);
                    }
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3};
    }


}
