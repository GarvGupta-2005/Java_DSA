package DP.Subsequences;

import java.util.*;

public class SubsetSumEqaulK {
    //This is memoization
    public static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = notTaken + taken;
    }

    public static int findWays(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return findWaysUtil(n - 1, k, num, dp);
    }

    public static int findWays2(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        // Base case
        if (num[0] == 0)
            dp[0][0] = 2; // If num[0] is 0, we have two choices: pick or not pick
        else
            dp[0][0] = 1; // We can always make sum 0 with an empty subset

        if (num[0] <= k && num[0] != 0)
            dp[0][num[0]] = 1;

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notTaken = dp[i - 1][target];

                int taken = 0;
                if (num[i] <= target)
                    taken = dp[i - 1][target - num[i]];

                dp[i][target] = notTaken + taken;
            }
        }

        return dp[n - 1][k];
    }

}
