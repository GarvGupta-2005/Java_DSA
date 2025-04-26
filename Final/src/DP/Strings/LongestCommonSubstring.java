package DP.Strings;

public class LongestCommonSubstring {
    public int longestCommonSubstr(String s, String t) {
        //Your code goes here
		int n = s.length();
        int m = t.length();
        //In tabulation since we can't access negative indices therefore we will do a shift of ind
        //This signifies that every index i will signify i-1
        int [][] dp = new int[n+1][m+1];
        //Base case handled as i=0 will now signify i-1
        for(int i = 0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j = 0;j<m+1;j++){
            dp[0][j] = 0;
        }
        int maxLen = 0;

        //Now the main thing
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen,dp[i][j]);
                }else{
                    dp[i][j] = 0;//Since in substring we require continuity thus we won't break by either checking left or rigt 
                }
            }
        }
        return maxLen;

    }
}
