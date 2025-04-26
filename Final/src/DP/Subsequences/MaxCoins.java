
import java.util.*;
public class MaxCoins{

    //Memorization
    int minimumElementsUtil(int[] arr, int ind, int T, int[][] dp) {
        // Base case: If the current index is 0
        if (ind == 0) {
            // If T is divisible by the first element of the array, return the quotient
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                // If not, return a large value to indicate it's not possible
                return (int) Math.pow(10, 9);
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][T] != -1)
            return dp[ind][T];

        // Calculate the minimum number of elements needed without taking the current element
        int notTaken = 0 + minimumElementsUtil(arr, ind - 1, T, dp);

        // Initialize the minimum number of elements needed taking the current element
        int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to T, calculate the minimum taking it
        if (arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr, ind, T - arr[ind], dp);

        // Store the minimum result in the dp array and return it
        return dp[ind][T] = Math.min(notTaken, taken);
    }

    public int coinChange(int[] arr, int T) {
        int n = arr.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Calculate the minimum number of elements to achieve the target sum
        int ans = minimumElementsUtil(arr, n - 1, T, dp);

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    //Tabulation
    public int coinChange2(int[] arr, int T) {
        int n = arr.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][T + 1];

        //Base case
        for(int t = 0;t<=T;t++){
            if(t%arr[0] == 0){
                dp[0][t] = t/arr[0];
            }else{
                dp[0][t] = (int)1e9;
            }
        }        

        // Calculate the minimum number of elements to achieve the target sum
        for(int i = 1;i<n;i++){
            for(int t = 0;t<=T;t++){
                int notTaken = 0 + dp[i-1][t];
                int taken = (int) Math.pow(10, 9);

        // If the current element is less than or equal to T, calculate the minimum taking it
        if (arr[i] <= t){
            taken = 1 + dp[i][t-arr[i]];
        }
        dp[i][t] = Math.min(taken,notTaken);
            }
        }

        // If it's not possible to achieve the target sum, return -1
        if (dp[n-1][T] >= (int) Math.pow(10, 9))
            return -1;
        return dp[n-1][T];
    }
}