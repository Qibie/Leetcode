package com.leetcode.zbf;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CountStart {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStars = Integer.valueOf(scanner.nextLine().trim());
        int[][] starPosition = new int[numStars][2];
        for (int i = 0; i < numStars; ++i) {
            String[] strs = scanner.nextLine().split(" ");
            starPosition[i][0] = Integer.valueOf(strs[0]);
            starPosition[i][1] = Integer.valueOf(strs[1]);
        }
        int numQuestions = Integer.valueOf(scanner.nextLine().trim());
        int[][] questionPostions = new int[numQuestions][4];
        for (int i = 0; i < numQuestions; ++i) {
            String[] strs = scanner.nextLine().split(" ");
            for (int j = 0; j < 4; ++j) {
                questionPostions[i][j] = Integer.valueOf(strs[j]);
            }
        }
        for (int i = 0; i < numQuestions; ++i) {
            System.out.println(getStarNums(questionPostions[i], starPosition, numStars));
        }

    }

    public static int getStarNums(int[] bound, int[][] starPosition, int numStarts) {
        int  count = 0;
        for (int i = 0; i < numStarts; ++i) {
            if ( bound[0] <= starPosition[i][0] &&bound[2] >= starPosition[i][0]) {
                if (bound[1]<= starPosition[i][1] &&bound[3] >= starPosition[i][1]) {
                    ++count;
                }
            }
        }
        return count;
    }


}
