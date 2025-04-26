package DP.Strings;

public class ShortestCommonSubsequence {
    //This is very intuitve
    //The intution is to build a dp array and then from the last cell we will traverse backwards
    //If the character is equal then we add it on answer once
    //if its not we move from that point where answer is backward and we will include that element from where we are going back
    //There is a base case that one string might be incomplete so we will check till both strings are complete or not

    public String shortestCommonSupersequence(String s, String t) {
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

        String ans = "";
        int i = n;
        int j = m;
        while(i>0 && j>0){ //Since 0 here signifies -1 base case 
        if(s.charAt(i-1)==t.charAt(j-1)){
            ans = ans + s.charAt(i-1);
            i--;j--;
        }else if(dp[i-1][j]>dp[i][j-1]){
            ans = ans + s.charAt(i-1);
            i--;
        }
        else{
            ans = ans + t.charAt(j-1);
            j--;
        }
        }
        while(i>0){
            ans = ans + s.charAt(i-1);
            i--;
        }
        while(j>0){
            ans = ans + t.charAt(j-1);
            j--;
        }
        String finans = "";
        for(int k = ans.length()-1;k>=0;k--){
            finans = finans + ans.charAt(k);
        }
        return finans;
    }
}
