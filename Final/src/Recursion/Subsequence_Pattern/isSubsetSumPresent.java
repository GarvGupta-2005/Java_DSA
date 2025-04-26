package Recursion.Subsequence_Pattern;

public class isSubsetSumPresent {
    public static boolean helper(int index, int target, int[] nums, int currentSum) {
        // Base case: if the current sum equals the target
        if (currentSum == target) {
            return true;
        }

        // Base case: if all elements are processed or currentSum exceeds target
        if (index == nums.length || currentSum > target) {
            return false;
        }

        // Take condition: include the current element in the sum
        boolean take = helper(index + 1, target, nums, currentSum + nums[index]);

        // Not Take condition: skip the current element
        boolean notTake = helper(index + 1, target, nums, currentSum);

        // Return the result of either taking or not taking the current element
        return take || notTake;
    }

    public static boolean isSubsetPresent(int n, int k, int[] a) {
        return helper(0, k, a, 0);
    }
}
