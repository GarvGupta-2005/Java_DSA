package DP.Strings;
import java.util.*;

public class DistinctSubsequences {
    //This is the memorization code
    private int f(int i,int j,String s,String t,int [][]dp){
        if(j<0){
            //This means that the target string has been achieved therefore return 1;
            return 1;
        }
        if(i<0){
            //This means that the target has not been achieved but the Main String has finished
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            int take = f(i-1,j-1,s,t,dp);
            int notTake = f(i-1,j,s,t,dp);
            return dp[i][j] =  take+notTake;
        }
        //This will happen if the the current char in s does not match the current char of t
        return dp[i][j] =  f(i-1,j,s,t,dp);
    }

    public int numDistinct(String s, String t) {
        int [][] dp = new int[s.length()][t.length()];
        for(int i = 0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return f(s.length()-1,t.length()-1,s,t,dp);
    }
//This is tabulation
    public int numDistinct2(String s, String t) {
        int [][] dp = new int[s.length()+1][t.length()+1];
        // If target is empty, there's one way to match (delete everything)
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        // If source is empty but target is not, 0 ways (we skip dp[0][0])
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        //Main work
        for(int i = 1;i<s.length()+1;i++){
            for(int j = 1;j<t.length()+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    int take = dp[i-1][j-1];
                    int notTake = dp[i-1][j];
                     dp[i][j] =  take+notTake;
                }else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    
}
