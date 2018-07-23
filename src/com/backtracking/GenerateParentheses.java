package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        int left = 0, righ = 0;
        helper(n, sb, result, 0, 0);
        return result;
    }

    public static void helper(int n, StringBuilder sb, List<String> result, int left, int right) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        if (right > left)
            return;
        if (left < n) {
            sb.append("(");
            helper(n, sb, result, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(")");
            helper(n, sb, result, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
