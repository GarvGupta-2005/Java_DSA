package DP.TwoD_ThreeD_GridDP;
import java.util.*;

public class Triangle {
    //Memoization
    public int f(int i, int j,List<List<Integer>> triangle, int n,int [][] dp){
        //Base Case 
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        if(dp[i][j]!=-1)return dp[i][j];

        int down = triangle.get(i).get(j) + f(i+1,j,triangle,n,dp);
        int diagonal = triangle.get(i).get(j) + f(i+1,j+1,triangle,n,dp);
        return dp[i][j] =  Math.min(down,diagonal);
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,triangle,n,dp);
    }

    //Tabulation
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],0);
        }
        //Setting the base cases 
        for(int j = 0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        //Since the tabulation is bottom up approach and is opposite of memoization then we will start from opposite end here as well
        for(int i = n-2;i>=0;i--){
            for(int j = i;i>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

}
