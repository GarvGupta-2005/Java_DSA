package DP.TwoD_ThreeD_GridDP;

import java.util.*;

public class UniquePaths {
    public static int f(int r,int c,int [][]dp){
		if(r<0 || c<0)return 0;
		if(r == 0 && c==0){
			return dp[0][0]=1;
		}

		if(dp[r][c]!=-1)return dp[r][c];

		int up = f(r-1,c,dp);
		int left = f(r,c-1,dp);
		return dp[r][c] = up+left;
	}

	public static int uniquePaths(int m, int n) {
		// This is Memoization Code
		int [][] dp = new int[m][n];
		for(int i = 0;i<m;i++){
			Arrays.fill(dp[i],-1);
		}
		return f(m-1,n-1,dp);
	}

	//Tabulation
	public int uniquePaths2(int m, int n) {
        //This is the Tabulation Code
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0)dp[i][j] = 1;
                else if(j == 0){dp[i][j]=1;}
                else{
                    int left = dp[i][j-1];
                    int up = dp[i-1][j];
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m-1][n-1];
    }
	//SPace optimization
	static int countWays(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];
        
        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];
            
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }
            
            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }
}
