package com.leetcode.zbf;

import java.util.Scanner;

public class SubstringCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStrings = 0, numQuestions = 0;

        String str;
        while (scanner.hasNext()) {
            str = scanner.nextLine();
            numStrings = Integer.valueOf(str.trim());
            String[] strings = new String[numStrings];
            for (int i = 0; i < numStrings; ++i) {
                strings[i] = scanner.nextLine();
            }
            numQuestions = Integer.valueOf(scanner.nextLine().trim());
            for (int i = 0; i < numQuestions; ++i) {
                str = scanner.nextLine().trim();
                int count = 0;
                for (int j = 0; j < numStrings; ++j) {
                    if (strings[j].contains(str))
                        ++count;
                }
                System.out.println(count);
            }
        }
    }
}
