package com.backtracking;

import com.sun.org.apache.regexp.internal.RE;

public class CombinationIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] count = new int[1];
        count[0] = 0;
        helper(nums, target, count);
        return count[0];
    }

    public void helper(int[] nums, int target, int[] count) {
        if (target < 0)
            return;
        if (target == 0)
            ++count[0];

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0 || target < nums[i])
                continue;
            helper(nums, target - nums[i], count);
        }
    }


    public int combinationSum4_dp(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; ++i) {
            for (int temp : nums) {
                if (i + temp > target)
                    continue;
                dp[i + temp] += dp[i];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 32;
        System.out.println(new CombinationIV().combinationSum4(nums, target));
    }

}
