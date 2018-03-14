package com.leetcode.zbf;

/**
 * Created by curry on 18-3-12.
 */


import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        return new ArrayList<>(result);
    }


    public static void get2sSum(int[] cadidates, int target, int head, int tail, List<Integer> result) {
        if (cadidates[head] < target) {
            return;
        }
        if (cadidates[head] == target) {
            result.add(cadidates[head]);
        }
        Set<List<Integer>> set = new HashSet<>();
        while (head < tail) {
            while (head < tail && (cadidates[head] + cadidates[tail] < target)) {
                ++head;
            }
            while (head < tail && (cadidates[head] + cadidates[tail] > target)) {
                --tail;
            }
            if (head < tail && (cadidates[head] + cadidates[tail] == target)){
                result.add(cadidates[head]);
                result.add(cadidates[tail]);
                  
            }
        }
    }


}


