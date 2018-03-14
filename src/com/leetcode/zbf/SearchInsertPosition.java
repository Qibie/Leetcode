package com.leetcode.zbf;

/**
 * Created by curry on 18-3-6.
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }
        int low = 0, hign = nums.length - 1, mid = (low + hign) / 2;
        while (low <= hign) {
            mid = (low + hign) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] >= target) {
                hign = mid - 1;
            }
        }
        if (nums[mid] >= target) {
            return mid;
        } else {
            return mid + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.print(searchInsert(nums, target));

    }
}
