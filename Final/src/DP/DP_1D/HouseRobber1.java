package DP.DP_1D;

import java.util.*;

public class HouseRobber1 {
    //Memorization
    public int f(int ind,int [] nums,int dp[]){
        if(ind<0){
            return 0;
        }
        if(ind == 0){//It means that if we are stamnding 0 then we skipped i index and we havr to include ind 0
            return nums[0];
        }
        //Same pick not pick
        if(dp[ind]!=-1)return dp[ind];

        int pick = nums[ind] + f(ind-2,nums,dp);
        int notPick = 0 + f(ind-1,nums,dp);
        return dp[ind] = Math.max(pick,notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp [] = new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }

    //Tabulation
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// In Tabulation we will go  step by step
		int n = nums.size();
		int [] dp = new int[n];
		Arrays.fill(dp,-1);

		//Step1 Write base cases
		dp[0] = nums.get(0);//As we have to always include this if we skip 1 index

		//Step2 Build the answer
		for(int i = 1;i<n;i++){
			int take = nums.get(i);
			if(i>1){
				take+= dp[i-2];//Skipping the adjacent 
			}
			int notTake = 0 + dp[i-1];
			dp[i] = Math.max(take,notTake);
		}
		return dp[n-1];
	}

    //Space Optimization of Tabulation
    public static int maximumNonAdjacentSum1(ArrayList<Integer> nums) {
		// In Tabulation we will go  step by step
		int n = nums.size();
	

		//Step1 Write base cases
		int prev = nums.get(0);//As we have to always include this if we skip 1 index
        int prev2 = 0;

		//Step2 Build the answer
		for(int i = 1;i<n;i++){
			int take = nums.get(i);
			if(i>1){
				take+= prev2;//Skipping the adjacent 
			}
			int notTake = 0 + prev;
			int cur = Math.max(take,notTake);
            prev2  = prev;
            prev = cur;
		}
		return prev;
	}

}
