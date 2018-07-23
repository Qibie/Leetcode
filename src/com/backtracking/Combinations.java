package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0)
            return result;
        List<Integer> currCombination = new ArrayList<>();
        helper(n, k, currCombination, result, 1);
        return result;
    }

    public void helper(int n, int k, List<Integer> currCombination, List<List<Integer>> result, int pos) {
        if (currCombination.size() == k) {
            result.add(new ArrayList<>(currCombination));
            return;
        }
        if (pos > n)
            return;

        for (int i = pos; i <= n; ++i) {
            currCombination.add(i);
            helper(n, k, currCombination, result, i + 1);
            currCombination.remove(currCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
