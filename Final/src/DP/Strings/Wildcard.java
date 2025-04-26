package DP.Strings;

public class Wildcard {
    // private boolean f(int i,int j,String p,String s){
    //     if(i<0  && j<0){
    //         return true;
    //         //This indicates that both the strings have exhausted and thus the pattern is matched
    //     }

    //     if(i<0 && j>=0){
    //         return false;
    //         //This indicates that the string S is still left but the pattern is exhausted 
    //     }

    //     if(i>=0 && j<0){
    //         for(int k = 0;k<=i;k++){
    //             if(p.charAt(k)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //         //This indicates that if the String is exhausted but the pattern is still left
    //         //Then the pattern must be filled with just '*' otherwise the pattern will not be matched
    //     }

    //     //Main work
    //     if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
    //         return f(i-1,j-1,p,s);
    //     }
    //     if(p.charAt(i)=='*'){
    //         boolean take = f(i-1,j-1,p,s);
    //         boolean notTake = f(i,j-1,p,s);
    //         return take||notTake;
    //     }
    //     return false;
    // }

    // public boolean isMatch(String s, String p) {
    //     int n = p.length();
    //     int m = s.length();
    //     return f(n-1,m-1,p,s);
    // }

    private boolean f1(int i, int j, String p, String s, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (i >= 0 && j < 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = f1(i - 1, j - 1, p, s, dp);
        }

        if (p.charAt(i) == '*') {
            boolean take = f1(i - 1, j, p, s, dp);     // * = empty
            boolean notTake = f1(i, j - 1, p, s, dp);  // * = consume one from s
            return dp[i][j] = take || notTake;
        }

        return dp[i][j] = false;
    }

    public boolean isMatch1(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m];
        return f1(n - 1, m - 1, p, s, dp);
    }

    //Tabulation
    static boolean isAllStars(String S1, int i) {
        for (int j = 1; j <= i; j++) {
          if (S1.charAt(j - 1) != '*')
            return false;
        }
        return true;
      }
    
      // Function to perform wildcard pattern matching
      static boolean wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();
    
        // Create a 2D array to store the matching results
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
    
        // Initialize the first row and column based on wildcard '*' in S1
        for (int j = 1; j <= m; j++) {
          dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
          dp[i][0] = isAllStars(S1, i);
        }
    
        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
              dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?' is encountered.
            } else {
              if (S1.charAt(i - 1) == '*') {
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches one or more characters.
              } else {
                dp[i][j] = false; // Characters don't match, and S1[i-1] is not '*'.
              }
            }
          }
        }
    
        return dp[n][m]; // The final result indicates whether S1 matches S2.
      }
    
      public static void main(String args[]) {
        String S1 = "ab*cd";
        String S2 = "abdefcd";
    
        if (wildcardMatching(S1, S2)) {
          System.out.println("String S1 and S2 do match");
        } else {
          System.out.println("String S1 and S2 do not match");
        }
      }
}
