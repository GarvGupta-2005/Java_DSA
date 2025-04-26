package DP.Squares;

public class CountSquares {
    //The dp[i][j] will represent in how many squares is this cell the right bottom cell 
//This is how we will fill the dp table and the total sum of all cells of the dp cell will be answer

//The intuition is that all the dp[][] will be initailly filled with 1 as each cells are squares 
//If when we are building a bigger square then all we need is to take the minimal of adjacent cells and then add 1 to it to count which size square will be this one be part of

public static int countSquares(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int [][] dp = new int[n][m];
    for(int j = 0;j<m;j++){
        dp[0][j] = matrix[0][j];
    }
    for(int i = 0;i<n;i++){
        dp[i][0] = matrix[i][0];
    }

    for(int i = 1;i<n;i++){
        for(int j = 1;j<m;j++){
            if(matrix[i][j]==0){
                dp[i][j] = 0;
            }else{
                dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
    }

    int sum = 0;
    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            sum+=dp[i][j];
        }
    }
    return sum;
}

public static void main(String[] args) {
    int [][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
    System.out.println(countSquares(matrix));
}

}
