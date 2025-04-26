package DP.Intro;

import java.util.*;

//In Top-Down we go from the number to the base case
//In the Bottom-Up we go from the base to the answer 
class Solution {
    static final int MOD = 1000000007;

    // Top-Down (Memoization)
    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return fibMemo(n, dp);
    }

    private static long fibMemo(int n, long[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        dp[n] = (fibMemo(n - 1, dp) + fibMemo(n - 2, dp)) % MOD;
        return dp[n];
    }

    // Bottom-Up (Tabulation)
    static long bottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    static long bottomUpspaceOptimised(int n) {
        int prev2 = 0;
    int prev = 1;
    
    for(int i=2; i<=n; i++){
        int cur_i = prev2+ prev;
        prev2 = prev;
        prev= cur_i;
    }

    return prev;
    }


    

}

public class Fibo {
    
}
