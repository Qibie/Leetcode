/**
 * @description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author qibie-pc
 * @date 2018-04-27
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2]; 
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    array = new int[]{i, j};
                }
            }
        }
        return array;
    }
}
