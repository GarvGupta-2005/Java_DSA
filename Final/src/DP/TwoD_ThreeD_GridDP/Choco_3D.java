package DP.TwoD_ThreeD_GridDP;

import java.util.*;

public class Choco_3D{
    static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid,
                          int[][][] dp) {
    // Check if j1 and j2 are valid column indices
    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
      return (int) (Math.pow(-10, 9));

    // If we are at the last row, return the sum of chocolates in the selected columns
    if (i == n - 1) {
      if (j1 == j2)
        return grid[i][j1];
      else
        return grid[i][j1] + grid[i][j2];
    }

    // If the result for this state is already computed, return it
    if (dp[i][j1][j2] != -1)
      return dp[i][j1][j2];

    int maxi = Integer.MIN_VALUE;
    // Iterate through possible moves in the next row
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        int ans;
        // If j1 and j2 are the same, add chocolates from grid[i][j1] only
        if (j1 == j2)
          ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
        else
          // Add chocolates from both j1 and j2
          ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
        // Update maxi with the maximum result
        maxi = Math.max(maxi, ans);
      }
    }
    // Store the result in the dp array and return it
    return dp[i][j1][j2] = maxi;
  }

	public static int maximumChocolates(int r, int c, int[][] grid) {

		int [][][] dp = new int[r][c][c];
		for (int row1[][] : dp) {
      for (int row2[] : row1) {
        Arrays.fill(row2, -1);
      }
    }
		return maxChocoUtil(0,0,c-1,r,c,grid,dp);
	}

    //Tabulation
    public int solve(int n, int m, int grid[][]) {
        // Code here
        // Create a 3D array to store computed results
    int dp[][][] = new int[n][m][m];

    // Initialize the dp array with values from the last row of the grid
    for (int j1 = 0; j1 < m; j1++) {
      for (int j2 = 0; j2 < m; j2++) {
        if (j1 == j2)
          dp[n - 1][j1][j2] = grid[n - 1][j1];
        else
          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
      }
    }

    // Outer nested loops to traverse the DP array from the second last row to the first row
    for (int i = n - 2; i >= 0; i--) {
      for (int j1 = 0; j1 < m; j1++) {
        for (int j2 = 0; j2 < m; j2++) {
          int maxi = Integer.MIN_VALUE;

          // Inner nested loops to try out 9 options
          for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
              int ans;

              if (j1 == j2)
                ans = grid[i][j1];
              else
                ans = grid[i][j1] + grid[i][j2];

              // Check if the indices are valid
              if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                ans += (int) Math.pow(-10, 9);
              else
                ans += dp[i + 1][j1 + di][j2 + dj];

              // Update maxi with the maximum result
              maxi = Math.max(ans, maxi);
            }
          }
          // Store the result in the dp array
          dp[i][j1][j2] = maxi;
        }
      }
    }

    // The final result is stored at the top row (first row) of the dp array
    return dp[0][0][m - 1];
    }
}