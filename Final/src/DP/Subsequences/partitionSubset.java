package DP.Subsequences;

public class partitionSubset {
    private boolean isSubsetSum(int arr[], int k) {
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

    public boolean canPartition(int[] nums) {
        //Observation1 if the total sum is even then only we can have 2 subsets having equal sum
        //Observation2 If we can find one subset with sum totalSum/2 then we can surely have another subset having same sum as first subset 

        int sum = 0;
        for(int x : nums){
            sum += x;
        }

        if(sum%2 != 0)return false;

        return isSubsetSum(nums,sum/2);
        
    }
}
