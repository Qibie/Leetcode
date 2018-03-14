package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by curry on 18-1-19.
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        DFS(result, n, n, "");
        return result;
    }

    public static void DFS(List<String> result, int left, int right, String path) {
        if (right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(path);
            return;
        }
        if (left > 0) {
            DFS(result, left - 1, right, path + "(");
        }
        if (right > 0) {
            DFS(result, left, right - 1, path + ")");
        }
    }

    public static void main(String[] args) {
        int n=3;

        List<String> result=generateParenthesis(n);
        for(String s:result){
            System.out.println(s);
        }
    }
}
