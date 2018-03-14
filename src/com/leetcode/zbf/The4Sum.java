package com.leetcode.zbf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by curry on 18-1-14.
 */


public class The4Sum {
    /**
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> index = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tempresult = get3Sum(nums, target - nums[i], i + 1);
            if (tempresult != null && tempresult.size() > 0) {
                for (List<Integer> list : tempresult) {
                    index.add(Arrays.asList(nums[i], list.get(0), list.get(1), list.get(2)));
                }
            }
        }
        return index;
    }

    /**
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public static List<List<Integer>> get3Sum(int[] nums, int target, int start) {
        List<List<Integer>> index = new ArrayList<>();
        for (int i = start; i < nums.length - 2; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tempresult = get2Sum(nums, target - nums[i], i + 1, nums.length - 1);
            if (tempresult != null && tempresult.size() != 0) {
                for (List<Integer> list : tempresult) {
                    index.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
                }
            }

        }
        return index;
    }


    /**
     * @param nums
     * @param target
     * @param start
     * @return
     */
    public static List<List<Integer>> get2Sum(int[] nums, int target, int start, int end) {
        List<List<Integer>> index = new ArrayList<>();
        int start_temp = start, end_temp = end;
        while (start < end) {
            if (start > start_temp && nums[start] == nums[start - 1]) {
                ++start;
                continue;
            }
            if (end < end_temp && nums[end] == nums[end + 1]) {
                --end;
                continue;
            }
            if (nums[start] + nums[end] == target) {
                index.add(Arrays.asList(nums[start], nums[end]));
                ++start;
                --end;
            } else {
                if (nums[start] + nums[end] < target) {
                    ++start;
                } else {
                    if (nums[start] + nums[end] > target) {
                        --end;
                    }
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[] s = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> result = fourSum(s, target);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println("");
        }
    }
}
