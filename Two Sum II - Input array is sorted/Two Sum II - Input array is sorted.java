import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order
 * Note:Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * @author qibie-pc
 * @date 2018-04-28
 */
class Two Sum II - Input array is sorted {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }
        for(int i = 0; i < numbers.length; i++){
            int result = target - numbers[i];
            if(map.containsKey(result) && map.get(result) > i){
                return new int[]{i, map.get(result)};
            }
        }
        throw new IllegalArgumentException("No two sum solution!");
    }
}
