import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum Improved
 * @author qibie-pc
 * @date 2018-04-28
 */
 
class TwoSumImproved {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int component = target - nums[i];
            if(map.containsKey(component) && map.get(component) != i){
                return new int[]{i, map.get(component)};
            }
        }
		throw new IllegalArgumentException("No two sum solution!");
	}
}
