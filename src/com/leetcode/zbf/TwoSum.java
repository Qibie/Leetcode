package com.leetcode.zbf;

import java.util.HashMap;

/**
 * Created by curry on 17-12-7.
 *
 *
 * describe
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
            map.put(nums[i],i);
        }

        for(int j=0;j<nums.length;++j){
            if(map.containsValue(target-nums[j])&& map.get(nums[j])!=null){
                return new int[]{map.get(nums[j]),map.get(target-nums[j])};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

}
