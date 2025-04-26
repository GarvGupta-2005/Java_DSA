package DP.Strings;

public class MinInsertionDeletiontomakeStringEqual {
    
//The intuition is to not to touch the common part and then delete from one string and insert 
    //Thus keeping The LCS intact we have to just perform on other characters

    public  int lcs(String s, String t) {
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

    public int minDistance(String word1, String word2) {
        int lcs_len = lcs(word1,word2);
        int n = word1.length();
        int m = word2.length();

        //Let us assume that we delete from word1 and insert from word2
        int deletions = n - lcs_len; //Taking the part which is not common
        int insertions = m - lcs_len; //Insertin the part not common
        return deletions+insertions;
    }
}
