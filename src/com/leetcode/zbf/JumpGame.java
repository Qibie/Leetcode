package com.leetcode.zbf;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int reach = 0;
        for (int i = 0; i < reach && i < nums.length; ++i) {
            reach = Math.max(reach, nums[i] + i);
        }
        if (reach < nums.length - 1) {
            return false;
        }
        return true;
    }
}
