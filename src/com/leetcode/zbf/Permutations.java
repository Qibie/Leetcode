package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList() {{
            for (int i : nums) {
                add(i);
            }
        }};

        getResult(result, numsList, new ArrayList<Integer>());
        return result;
    }

    public void getResult(List<List<Integer>> result, List<Integer> numsList, List<Integer> currentList) {
        if (numsList == null || numsList.size() == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < numsList.size(); ++i) {
            int current = numsList.get(i);
            numsList.remove(i);
            currentList.add(current);
            getResult(result, numsList, currentList);
            numsList.add(i, current);
            currentList.remove(currentList.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }

}
