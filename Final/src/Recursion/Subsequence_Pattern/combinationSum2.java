package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    //In this problem we want all the non duplicate subsets whose sum is equal to the target
    public void helper(int ind,int target,int [] arr,List<List<Integer>> ans,List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i-1]){   //This step is added to prevent duplicate elements to be added to the current subset
                continue;
            }
            if(arr[i]>target){
                break;
            }    

            ds.add(arr[i]);
            helper(i+1,target-arr[i],arr,ans,ds);
            ds.remove(ds.size()-1);        
        }
    }
    
    public List<List<Integer>> CombinationSum2(int[] candidates, int target) {
        //Since we want the duplicates to be removed, we will first sort the array and then we will pass it to the helper
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(0,target,candidates,result,cur);
        return result;
    }
}
