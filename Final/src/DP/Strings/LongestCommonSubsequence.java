package DP.Strings;
import java.util.*;

public class LongestCommonSubsequence {
    //Memorization
    public int helper(int i,int j,String s,String t,int [][] dp){
        //Base case 
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //IF we encounter equal characters
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = 1 + helper(i-1,j-1,s,t,dp);
        }

        return dp[i][j] =  Math.max(helper(i-1,j,s,t,dp),helper(i,j-1,s,t,dp));
    }

    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n-1,m-1,s,t,dp);
    }

    //Tabulation
    public static int lcs(String s, String t) {
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

        //Now the main thing
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }

}
