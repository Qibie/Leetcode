package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> currPath = new ArrayList<>();
        helper(candidates, target, currPath, result, 0);
        return result;
    }

    public void helper(int[] candidates, int target, List<Integer> currPath, List<List<Integer>> result, int pos) {
        if (target < 0 )
        return;
        if (target == 0) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        if(pos>=candidates.length)
            return;

        int pre = -1;
        for (int i = pos; i < candidates.length; ++i) {
            if (target < candidates[i] || pre==candidates[i])
                continue;
            currPath.add(candidates[i]);
            helper(candidates, target - candidates[i], currPath, result, i + 1);
            pre=candidates[i];
            currPath.remove(currPath.size() - 1);
        }
    }
}
