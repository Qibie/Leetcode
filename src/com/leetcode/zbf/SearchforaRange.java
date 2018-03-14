package com.leetcode.zbf;

import java.util.Arrays;

/**
 * Created by curry on 18-3-5.
 */
public class SearchforaRange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        int low = 0, high = nums.length - 1, index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (index == -1) {
            result[0] = -1;
            result[1] = -1;
        } else {
            int index_low = index, index_high = index;
            while (index_high < nums.length - 1 && nums[index_high + 1] == nums[index_high]) {
                ++index_high;
            }
            while ((index_low >= 1 && nums[index_low - 1] == nums[index_low])) {
                --index_low;
            }
            result[0] = index_low;
            result[1] = index_high;
        }

        return result;
    }


    public int[] searchRange1(int[] nums, int target) {//二分法

        int[] result=new int[2];
        result[0]=firsttarget(nums,target);
        result[1]=lasttarget(nums,target);
        return result;
    }
    public int firsttarget(int[] nums,int target){
        int lo=0;
        int hi=nums.length-1;
        int idx=-1;
        //int mid=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;

            if(target<=nums[mid]){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
            if(nums[mid]==target){
                idx=mid;
                //return idx;
            }
        }

        return idx;
    }

    public int lasttarget(int[] nums,int target){
        int lo=0;
        int hi=nums.length-1;
        int idx=-1;
        //int mid=0;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(target<nums[mid]){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
            if(nums[mid]==target){
                idx=mid;
                //return idx;
            }
        }

        return idx;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 2;
        System.out.print(Arrays.toString(searchRange(nums, target)));
    }

}
