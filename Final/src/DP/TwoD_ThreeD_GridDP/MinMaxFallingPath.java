package DP.TwoD_ThreeD_GridDP;
import java.util.*;

public class MinMaxFallingPath {
    //Minimum Path
    //1.Memoization
    public int f(int i,int j,int [][] matrix,int [][]dp){
        //Handling Base Cases
          if(j<0 || j>=matrix[0].length){
            return (int)(1e8);
          }
          if(i == 0){
            return matrix[0][j];
          }
          //New BAse CAse of DP
          if(dp[i][j]!=-1)return dp[i][j];
          int u  = matrix[i][j] + f(i-1,j,matrix,dp);
          int ld = matrix[i][j] + f(i-1,j-1,matrix,dp);
          int rd = matrix[i][j] + f(i-1,j+1,matrix,dp);
          return dp[i][j] =  Math.min(u,Math.min(ld,rd));
    }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int min = (int)1e8;
        for(int j = 0;j<m;j++){
            min = Math.min(min,f(n-1,j,matrix,dp));
        }
        return min;
    }
    //2.Tabulation
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        //Handling the base case
        for(int j = 0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                int u = (int)1e8;
                int ld = (int)1e8;
                int rd = (int)1e8;
               if(i-1>=0) {u  = matrix[i][j] + dp[i-1][j];}
               if(i-1>=0 && j-1>=0){  ld = matrix[i][j] + dp[i-1][j-1];}
               if(i-1>=0 && j+1<m){  rd = matrix[i][j] + dp[i-1][j+1];}
                dp[i][j] = Math.min(u,Math.min(ld,rd));
            }
        }

        int min = (int)1e8;
        for(int j = 0;j<m;j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min ;
    }

    //Max Path SUm
    public static int getMaxPathSum(int[][] matrix) {
		int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        //Handling the base case
        for(int j = 0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                int u = (int)-1e8;
                int ld = (int)-1e8;
                int rd = (int)-1e8;
               if(i-1>=0) {u  = matrix[i][j] + dp[i-1][j];}
               if(i-1>=0 && j-1>=0){  ld = matrix[i][j] + dp[i-1][j-1];}
               if(i-1>=0 && j+1<m){  rd = matrix[i][j] + dp[i-1][j+1];}
                dp[i][j] = Math.max(u,Math.max(ld,rd));
            }
        }

        int max = (int)-1e8;
        for(int j = 0;j<m;j++){
            max = Math.max(max,dp[n-1][j]);
        }
        return max ;
	}
}
