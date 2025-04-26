package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset2 {
    //In this problem we have to make subsets of every size possible making sure that no duplicate subsets are there
    //So for that to happen first sort the array

    public static void helper(int index,int [] arr,List<List<Integer>> result,List<Integer>cur){
        result.add(new ArrayList<>(cur));//This is done at every step to add every variable size subset in the list
        for(int i = index;i<arr.length;i++){
            if(i!=index && arr[i]==arr[i-1]) continue;//The crucial step in removing all the Duplicate subsets
            cur.add(arr[i]);
            helper(i+1,arr,result,cur);
            cur.remove(cur.size()-1);
        }
    }
    public  static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        helper(0,nums,result,new ArrayList<>());
        return result;
    }
}
