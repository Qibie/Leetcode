package com.leetcode.zbf;


import java.util.ArrayList;
import java.util.Collections;

public class PermutationStr {
    public ArrayList<String> allResult = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        if (str.length() == 1) {
            allResult.add(str);
            return allResult;
        }
        Permutation(new StringBuilder(str), 0, new StringBuilder());
        Collections.sort(allResult);
        return allResult;
    }

    public void Permutation(StringBuilder str, int start, StringBuilder result) {
        if (start >= str.length()) {
            allResult.add(result.toString());
            return;
        }
        for (int i = start; i < str.length(); ++i) {
            if (i != start && str.charAt(i) == str.charAt(start)) {
                continue;
            }
            result.append(str.charAt(i));
            StringBuilder stringBuilder = new StringBuilder(str);
            if (i != start) {
                char c = stringBuilder.charAt(start);
                stringBuilder.setCharAt(start, stringBuilder.charAt(i));
                stringBuilder.setCharAt(i, c);
            }
            Permutation(stringBuilder, start + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> arrayList = new PermutationStr().Permutation(str);
        for (String string : arrayList) {
            System.out.println(string);
        }
    }

}
