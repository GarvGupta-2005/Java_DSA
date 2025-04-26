package DP.DP_1D;

public class CLIMBSTAIRS {

    //This is the bottom-up approach
    public  int countStairs(int nStairs) {
        if (nStairs == 0) return 1; // Base case
        if (nStairs == 1) return 1; // Base case
    
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]
    
        for (int i = 2; i <= nStairs; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
    
        return prev1;
    }
        public int climbStairs(int n) {
            return countStairs(n);
        }




}
