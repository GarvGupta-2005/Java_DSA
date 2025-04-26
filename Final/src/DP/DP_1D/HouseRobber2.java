package DP.DP_1D;

import java.util.ArrayList;

public class HouseRobber2 {
     // This is a very intuitive problem
    // The observation is that the entire question is same as House Robber 1 just that we can't take first and last element together
    // That means our answer will be formed from either excluding the first or last element

    public int maxi(ArrayList<Integer> nums) {
        // In Tabulation we will go step by step
        int n = nums.size();
        if (n == 0) return 0; // Handle case when nums is empty

        // Step1 Write base cases
        int prev = nums.get(0); // As we have to always include this if we skip 1 index
        int prev2 = 0;

        // Step2 Build the answer
        for (int i = 1; i < n; i++) {
            int take = nums.get(i);
            if (i > 1) {
                take += prev2; // Skipping the adjacent 
            }
            int notTake = 0 + prev;
            int cur = Math.max(take, notTake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // Edge case: If only one house, rob it

        ArrayList<Integer> first = new ArrayList<>(); // Exclude first
        ArrayList<Integer> last = new ArrayList<>(); // Exclude last

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                first.add(nums[i]);
            }
            if (i != nums.length - 1) {
                last.add(nums[i]);
            }
        }

        return Math.max(maxi(first), maxi(last));
    }
}
