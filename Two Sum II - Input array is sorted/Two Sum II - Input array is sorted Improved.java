/**
 * Given an array of integers that is already sorted in ascending order
 * Note:Your returned answers (both index1 and index2) are not zero-based. You
 * may assume that each input would have exactly one solution and you may not
 * use the same element twice.
 * 
 * @author qibie-pc
 * @date 2018-04-28
 */
class Solution {
	public int[] twoSum(int[] num, int target) {
		int result[] = new int[2];
		if(num == null || num.length < 2) {
			return result;
		}
		int i = 0;
		int j = num.length - 1;
		while(i < j) {
			int sum = num[i] + num[j];
			if(sum == target){
				result[0] = i + 1;
				result[1] = j + 1;
				break;
			} else if(sum < target){
				++i;
			} else {
				--j;
			}
		}
		return result;
	}
}