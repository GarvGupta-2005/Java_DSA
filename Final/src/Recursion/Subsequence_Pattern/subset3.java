package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class subset3 {
    public  static void helper(int sp,int k,int target,List<List<Integer>> result, List<Integer>cur){
        if(cur.size()==k && target == 0){  //Positive base case where the sum is formed of the size k
            result.add(new ArrayList<>(cur));
            return;
        }
        if(cur.size()>k && target!=0){ //The negative base case where the size of Set reaches beyond the limit
            return;
        }

        for(int i = sp;i<=9;i++){//The for loop is to prevent of the same number being used twice
            if(i<=target){  //To see whether the current number is less than the target or not
                int new_target = target - i;
                cur.add(i);
                helper(i+1,k,new_target,result,cur);//Taking the current value  into the answer hence new_target
                cur.remove(cur.size()-1);
            }
        }

    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(1,k,n,result,cur);
        return result;
    }
}
