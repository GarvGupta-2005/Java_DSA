package DP.Subsequences;
import java.util.*;

public class SubsetSumEqaulTarget {

    //Memoization

    public static boolean f(int i,int k,int [] arr,int [][] dp){
        if(k == 0)return true;
        if(i == 0)return arr[0]==k;
        if(dp[i][k]!=-1){
            if (dp[i][k] == 0)return false;
            else{
                return true;
            }
        }


        boolean notTake = f(i-1,k,arr,dp);
        boolean take = false;

        if(arr[i]<=k){
            take = f(i-1,k-arr[i],arr,dp);
        }

        boolean val = take||notTake;
        if(val == true){
            dp[i][k] = 1;
            return val;
        }else{
            dp[i][k] = 0;
            return val;
        }

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int [][] dp = new int[n][k+1];
        for(int [] x : dp){
            Arrays.fill(x,-1);
        }
        return f(n-1,k,arr,dp);

    }
    
    //Tabulation
    static Boolean isSubsetSum(int arr[], int k) {
        // code here
        int n = arr.length;
         boolean [][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for(int i = 0;i<n;i++){
            //Base Case 1 where target is zero
            dp[i][0] = true;
        }

        //Base case2 
       if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
        
    }
}
