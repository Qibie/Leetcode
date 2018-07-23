package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> numList = new ArrayList() {{
            for (int i : nums) {
                add(i);
            }
        }};
        getResult(result, numList, new ArrayList<Integer>());
        return result;
    }

    public void getResult(List<List<Integer>> result, List<Integer> numList, List<Integer> currentList) {
        if (numList == null || numList.size() == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < numList.size(); ++i) {
            int current = numList.get(i);
            if (i > 0 && current == numList.get(i - 1))
                continue;
            numList.remove(i);
            currentList.add(current);
            getResult(result, numList, currentList);
            numList.add(i, current);
            currentList.remove(currentList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }
}
