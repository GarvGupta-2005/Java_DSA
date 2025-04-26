package TwoPointer_SlidingWindows.Hard;

import java.util.HashMap;

public class subarrayWithExactKDistinctIntegers {
    //This kind of pattern where we have to find number of subarrays having exact number of something can be solved by Finding the subarraysa having <=k and <=k-1 and then subtract the answer
    //We will be converting it into that kind of problem where the distinct integers is <= k

   public static int countSubarrays(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        while (r < n) {
            // Increment the frequency of the current number
            if (map.containsKey(nums[r])) {
                map.put(nums[r], map.get(nums[r]) + 1);
            } else {
                map.put(nums[r], 1);
            }

            // Shrink the window if there are more than k distinct integers
            while (map.size() > k) {
                if (map.containsKey(nums[l])) {
                    map.put(nums[l], map.get(nums[l]) - 1);
                    if (map.get(nums[l]) == 0) {
                        map.remove(nums[l]);
                    }
                }
                l++;
            }

            // Add the number of valid subarrays ending at r
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    // Function to count subarrays with exactly k distinct integers
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarrays(nums, k) - countSubarrays(nums, k - 1);
    }

}
