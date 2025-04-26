package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class subset {
    
    public void helper(int [] nums,int index,List<Integer> cur,List<List<Integer>> result){

        if(index>nums.length){
            return ;
        }
        if(index == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        //Pick condition
        cur.add(nums[index]);
        helper(nums,index+1,cur,result);
        cur.remove(cur.size()-1); // To remove this element for following the next condition

        //Not Pick Condition
        helper(nums,index+1,cur,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> cur = new ArrayList<>();
        helper(nums,0,cur,result);
        return result;

    }

}
