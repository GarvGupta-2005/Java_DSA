package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static  void permuteHelper(List<Integer> nums, List<Integer> current, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(current));
            return;
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> newNums = new ArrayList<>(nums);//To store all the elements in the new list except for the one we are currently working on
                newNums.remove(i);//Remove the element we are currently working on
                current.add(nums.get(i));//Adding the current element to the current list
                permuteHelper(newNums, current, result);//Recursively call the function with the new list to add further elements to the current list
                current.remove(current.size() - 1); // Remove last element to backtrack
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numss = new ArrayList<>();
        for(int i = 0 ; i<nums.length;i++){
            numss.add(nums[i]);
        }
        permuteHelper(numss, new ArrayList<>(), result);
        return result;
    }

}
