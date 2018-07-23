package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<Integer>(), result,0);
        return result;
    }

    public void helper(int[] candidates, int target, List<Integer> currPath, List<List<Integer>> result,int pos) {
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        for (int i=pos;i<candidates.length;++i) {
            if (candidates[i] > target)
                continue;
            currPath.add(candidates[i]);
            helper(candidates, target - candidates[i], currPath, result,i);
            currPath.remove(currPath.size() - 1);
        }
    }


}
