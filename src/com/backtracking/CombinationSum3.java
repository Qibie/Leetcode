package com.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1 || n < (((k * (k + 1)) >> 1))) {
            return result;
        }
        List<Integer> currPath = new ArrayList<>();
        helper(k, n, currPath, result, 1);
        return result;
    }

    public void helper(int k, int target, List<Integer> currPath, List<List<Integer>> result, int pos) {
        if (target < 0)
            return;
        if (target == 0 && currPath.size()==k) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        if (pos > 9 || currPath.size() > k)
            return;
        for (int i = pos; i <= 9; ++i) {
            if (target < i)
                break;
            currPath.add(i);
            helper(k, target - i, currPath, result, i + 1);
            currPath.remove(currPath.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
    }
}
