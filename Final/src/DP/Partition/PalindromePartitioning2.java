
import java.util.Arrays;

public class PalindromePartitioning2 {

    //The recursive Code is this
    public boolean isPalindrome(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public int palindromeCut(int i, int n, String s) {
        if (i == n) {
            return 0;
        }

        int minCost = (int) 1e9;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + palindromeCut(j + 1, n, s);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        return palindromeCut(0, n, s) - 1;
        //We subtract -1 from the final answer because when we call the partition for the last character it perfroms a partition even beyond it which is not feasible at all so we have to subtract 1
    }

    //Memorization 
    public int palindromeCut1(int i, int n, String s, int[] dp) {
        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = (int) 1e9;
        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + palindromeCut1(j + 1, n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }

    public int minCut1(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return palindromeCut1(0, n, s, dp) - 1;
    }

    //Tabulation Code
    public int minCut3(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        // return palindromeCut1(0,n,s,dp)-1;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = (int) 1e9;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }
}
