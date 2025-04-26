
import java.util.*;

public class UnboundedKnapsack {

    private static int helper(int ind, int w, int[] weight, int[] profit, int[][] dp) {
        if (ind == 0) {
            if (weight[0] <= w) {
                return dp[ind][w] = (profit[0] * (w / weight[0]));
            } else {
                return dp[ind][w] = 0;
            }
        }
        if (dp[ind][w] != -1) {
            return dp[ind][w];
        }
        int notTake = helper(ind - 1, w, weight, profit, dp);
        int take = Integer.MIN_VALUE;

        if (weight[ind] <= w) {
            take = profit[ind] + helper(ind, w - weight[ind], weight, profit, dp);  // Pick same item again
        }

        return dp[ind][w] = Math.max(take, notTake);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(n - 1, w, weight, profit, dp);
    }

    //Tabulation
    public static int unboundedKnapsack2(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        //Base Case
        for (int wt = 0; wt <= w; wt++) {
            dp[0][wt] = (profit[0] * (wt / weight[0]));
        }

        for (int i = 1; i < n; i++) {
            for (int wt = 1; wt <= w; wt++) {
                int notTake = dp[i - 1][wt];
                int take = Integer.MIN_VALUE;

                if (weight[i] <= wt) {
                    take = profit[i] + dp[i][wt - weight[i]];  // Pick same item again
                }
                dp[i][wt] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][w];
        // return helper(n - 1, w, weight, profit);
    }

}
