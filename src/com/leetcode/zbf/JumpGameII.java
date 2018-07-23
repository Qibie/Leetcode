package com.leetcode.zbf;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("array is empty");
        }

        return jump(nums, 0);
    }


    public int jump(int[] nums, int index) {
        if (index == nums.length - 1)
            return 0;
        if (nums[index] == 0)
            return Integer.MAX_VALUE;
        int maxStep = index + nums[index] > nums.length - 1 ? (nums.length - 1 - index) : nums[index], count = nums.length;
        for (int i = 1; i <= maxStep; ++i) {
            count = Math.min(count, jump(nums, index + i));
        }
        return count + 1;
    }

    public int jump_1(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("array is empty");
        }
        int lastreache = 0, reach = 0, step = 0;
        for (int i = 0; i <= reach && i < nums.length; ++i) {
            if (i > lastreache) {
                lastreache = reach;
                ++step;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        if (reach < nums.length - 1) {
            return 0;
        }
        return step;
    }


    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        System.out.println(new JumpGameII().jump(nums));
    }

}
