


import java.util.*;
public class LongestIncreSubse{
    private int f(int ind,int prev_ind,int [] nums,int [][] dp){
        //The prev_ind demotes the last index that was included in our subsequence
        if(ind == nums.length)return 0;
        if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];

        int notTake = 0 + f(ind+1,prev_ind,nums,dp);

        int take = 0;
        if(prev_ind ==-1 || nums[ind]>nums[prev_ind]){
            take = 1 + f(ind+1,ind,nums,dp);
        }
        return dp[ind][prev_ind+1] =  Math.max(take,notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];//n+1 so that we can include the base case of negative index
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,-1,nums,dp);
    }

    static int longestIncreasingSubsequence(int arr[], int n){
    
        int dp[][]=new int[n+1][n+1];
        
        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){
                
                int notTake = 0 + dp[ind+1][prev_index +1];
        
                int take = 0;
        
                if(prev_index == -1 || arr[ind] > arr[prev_index]){
                    
                    take = 1 + dp[ind+1][ind+1];
                }
        
                dp[ind][prev_index+1] = Math.max(notTake,take);
                
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String args[]) {
        
        int arr[] = {10,9,2,5,3,7,101,18};
        
        int n = arr.length;
        
        System.out.println("The length of the longest increasing subsequence is  "+longestIncreasingSubsequence(arr,n));
        
    }
}