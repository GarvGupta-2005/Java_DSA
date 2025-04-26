package DP.DP_1D;

public class FrogJump{

    //This is the memorization code 
    public int f(int ind,int [] heights,int [] dp){
        if(ind == 0){return dp[ind] =  0;}
        
        
        if(dp[ind]!=-1){return dp[ind];}
        
        
        int left = f(ind-1,heights,dp) + Math.abs(heights[ind]-heights[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind>1){
            right = f(ind-2,heights,dp) + Math.abs(heights[ind]-heights[ind - 2]);
        }
        return dp[ind] = Math.min(left,right);
        
    }
    
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int [] dp = new int[n+1];
        for(int i = 0;i<n+1;i++){
            dp[i] = -1;
        }
        f(n-1,height,dp);
        return dp[n-1];
    }


    public static int frogJump(int n, int heights[]) {

        //this will be the tabulation approach bootom to up 
        //in memorizaton we went to n-1 to 0
        //Here we will go from 0 to n
         int [] dp = new int[n+1];
         //Write the base case = 
         dp[0] = 0;
         for(int i = 1;i<n;i++){
             int left = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
             int right = Integer.MAX_VALUE;
             if(i>1){
                 right = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
             }
             dp[i] = Math.min(left,right);
         }
         return dp[n-1];
    }

    //Space Optimization of tabulation
    int minCost2(int[] height) {
        // code here
        int prev2 = 0;
        int prev = 0;
        for(int i = 1;i<height.length;i++){
            int fs = prev + Math.abs(height[i]-height[i-1]);
            int ss = (int)1e9;
            if(i>1){
                ss = prev2 + Math.abs(height[i]-height[i-2]);
            }
            int cur = Math.min(fs,ss);
            prev2 = prev;
            prev  = cur;
        }
        return prev;
    }

}