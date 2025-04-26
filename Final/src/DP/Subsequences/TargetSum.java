
import java.util.Arrays;

public class TargetSum {
    //Given an arr we have to assign elements sign + or - to form the target 
    //This question can be remodelled to count partitions such that S1 + S2 = target and S1 = totSum - target
//     If we think deeper, we can say that the given ‘target’ can be expressed as addition of two integers (say S1 and S2). 
// S1 + S2 = target   – (i)

// Now, from where will this S1 and S2 come?  If we are given the array as [a,b,c,d,e], we want to place ‘+’ or ‘-’ signs in front of every array element and then add it. One example is :
// +a-b-c+d+e which can be written as (+a+d+e) + (-b-c).
// Therefore, we can say that S1=(+a+d+e) and S2=(-b-c) for this example.
//  If we calculate the total sum of elements of the array (say totSum), we can can say that,
// S1 = totSum - S2      – (ii)
// Now solving for equations (i) and (iii), we can say that 
// S2 = (totSum - target)/2    – (iv)
    int countPartitionsUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base case: If we have reached the first element
        if (ind == 0) {
            // Check if the target is 0 and the first element is also 0
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            // Check if the target is equal to the first element or 0
            if (target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        // Calculate the number of ways without taking the current element
        int notTaken = countPartitionsUtil(ind - 1, target, arr, dp);

        // Initialize the number of ways taking the current element as 0
        int taken = 0;

        // If the current element is less than or equal to the target, calculate 'taken'
        if (arr[ind] <= target) {
            taken = countPartitionsUtil(ind - 1, target - arr[ind], arr, dp);
        }

        // Store the result in the dp array and return it
        return dp[ind][target] = (notTaken + taken);
    }

    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int totSum = 0;

        // Calculate the total sum of elements in the array
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        // Checking for edge cases
        if (totSum - target < 0) {
            return 0;
        }
        if ((totSum - target) % 2 == 1) {
            return 0;
        }

        // Calculate the second sum based on the total sum and the target
        int s2 = (totSum - target) / 2;

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][s2 + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Call the countPartitionsUtil function to calculate the number of ways
        return countPartitionsUtil(n - 1, s2, arr, dp);
    }
}
