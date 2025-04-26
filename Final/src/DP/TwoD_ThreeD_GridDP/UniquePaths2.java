package DP.TwoD_ThreeD_GridDP;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting or ending cell has an obstacle, return 0 immediately
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        
        // Initialize start position
        dp[0][0] = 1;

        // Fill first column (if no obstacles)
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0]; 
            }
        }

        // Fill first row (if no obstacles)
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1]; 
            }
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;  // If there's an obstacle, no paths lead here
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];  // Sum of paths from top & left
                }
            }
        }

        return dp[m - 1][n - 1];  // Return the number of unique paths to bottom-right
    }
}
