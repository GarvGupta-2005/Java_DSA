package Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> Subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subsets = 1<<n;
        for(int i = 0;i<subsets;i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 0;j<n;j++){
                int ans1 = i&(1<<j);
                if(ans1!=0){
                    cur.add(nums[j]);
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
