package DP.Strings;

public class PrintLcs {
    static void lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
    
        int[][] dp = new int[n + 1][m + 1];
    
        // Build the DP table
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
    
        int len = dp[n][m]; // length of LCS
        char[] lcsArr = new char[len]; // array to store LCS characters
    
        int index = len - 1;
        int i = n, j = m;
    
        // Trace back to fill lcsArr
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsArr[index] = s1.charAt(i - 1); // fill from end
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    
        // Print the LCS
        System.out.println(new String(lcsArr));
    }
    
}
