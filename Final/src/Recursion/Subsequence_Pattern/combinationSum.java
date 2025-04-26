package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    //This problem involves finding subset sum where we can repeat the elements
    public void helper(int index, int target, int[] nums, List<List<Integer>> result, List<Integer> cur) {
        // Base case: if target becomes 0, we've found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        // If we reach the end of the array or target goes negative, stop recursion
        if (index >= nums.length || target < 0) {
            return;
        }

        // Take condition: include the current number
        cur.add(nums[index]);
        helper(index, target - nums[index], nums, result, cur);
        cur.remove(cur.size() - 1);

        // Not take condition: move to the next index
        helper(index + 1, target, nums, result, cur);
    }

    public List<List<Integer>> CombinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(0, target, candidates, result, cur);
        return result;
    }
}
