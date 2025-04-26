package Array.MediumLevel;

import java.util.HashMap;
import java.util.Map;

public class Sum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}


//The Brute Approach is O(n^2) approach of going over each element and finding its counterpart