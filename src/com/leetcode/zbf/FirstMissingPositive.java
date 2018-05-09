package com.leetcode.zbf;

import java.util.Arrays;

public class FirstMissingPositive {
//    public static int firstMissingPositive(int[] nums) {
//        if(nums==null || nums.length==0){
//            return 1;
//        }
//        Arrays.sort(nums);
//        int i=0;
//        for(i=0;i<nums.length;++i){
//           if(nums[i]>0){
//               break;
//           }
//        }
//        if(i>=nums.length||nums[i]>1){
//            return 1;
//        }
//        for(i=i+1;i<nums.length;++i){
//            if((nums[i]-nums[i-1])>1){
//                return nums[i-1]+1;
//            }
//        }
//        return nums[nums.length-1]+1;
//    }


    public static int firstMissingPositive(int [] nums){
        if(nums==null || nums.length==0){
            return 1;
        }
        int temp=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
               temp=nums[nums[i]-1];
               nums[nums[i]-1]=nums[i];
               nums[i]=temp;
                i--;
            }
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int [] nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
