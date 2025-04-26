package DP.TwoD_ThreeD_GridDP;

import java.util.Arrays;

public class MinPathSum {
     //This is Memoization code
    public static int f(int i,int j,int [][] grid,int [][] dp){
        if(i == 0 && j == 0)return grid[0][0];
        if(i<0 || j<0)return (int)1e9;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left = grid[i][j] + f(i,j-1,grid,dp);
        int up = grid[i][j] + f(i-1,j,grid,dp);
        return dp[i][j] = Math.min(left,up);
    }
    public static int minSumPath(int[][] grid) {
    	// Memoization
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,m-1,grid,dp);

    }

    //Tabulation
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
               if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j]; // Start position
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
    }
    //SPace optimization
    //In space optimizTION we don't need the entire gird we just need to carry the current row and the previous row that's it
    static int minSumPath(int n, int m, int[][] matrix) {
        // Initialize an array to store the previous row values
        int prev[] = new int[m];

        for (int i = 0; i < n; i++) {
            // Create a temporary array to store the current row values
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    temp[j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is its value
                else {
                    int up = matrix[i][j];
                    if (i > 0)
                        up += prev[j]; // Add the value from above if it's not out of bounds
                    else
                        up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

                    int left = matrix[i][j];
                    if (j > 0)
                        left += temp[j - 1]; // Add the value from the left if it's not out of bounds
                    else
                        left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

                    // Store the minimum of the two possible paths in the current cell
                    temp[j] = Math.min(up, left);
                }
            }
            // Update the previous row with the values of the current row
            prev = temp;
        }

        // The final result is stored in the last element of the previous row
        return prev[m - 1];
    }
}
