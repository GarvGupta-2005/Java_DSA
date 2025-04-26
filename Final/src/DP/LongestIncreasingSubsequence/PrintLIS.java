import java.util.ArrayList;
import java.util.Arrays;

public class PrintLIS {
    static int longestIncreasingSubsequence(int arr[], int n){
    
    int dp[]=new int[n];
    Arrays.fill(dp,1);
    
    for(int i=0; i<=n-1; i++){
        for(int prev_index = 0; prev_index <=i-1; prev_index ++){
            
            if(arr[prev_index]<arr[i]){
                dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
            }
        }
    }
    
    int ans = -1;
    
    for(int i=0; i<=n-1; i++){
        ans = Math.max(ans, dp[i]);
    }
    
    return ans;
}

public static void main(String args[]) {
	
	int arr[] = {10,9,2,5,3,7,101,18};
	
	int n = arr.length;
	
	System.out.println("The length of the longest increasing subsequence is "+longestIncreasingSubsequence(arr,n));
	
}

static int printlongestIncreasingSubsequence(int arr[], int n) {
    
    // dp[i] will store the length of the Longest Increasing Subsequence ending at index i
    int[] dp = new int[n];
    Arrays.fill(dp, 1); // Every element is an LIS of length 1 by itself initially

    // hash[i] will help us track the previous index in the LIS ending at i
    int[] hash = new int[n];
    Arrays.fill(hash, 1); // Temporary fill (will be set below)

    // Build the dp[] and hash[] arrays
    for (int i = 0; i <= n - 1; i++) {
        hash[i] = i; // By default, point to self (start of a sequence)
        
        for (int prev_index = 0; prev_index <= i - 1; prev_index++) {
            
            // Check if we can extend the LIS from prev_index to i
            if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
                dp[i] = 1 + dp[prev_index];      // Update dp[i] with new longer subsequence length
                hash[i] = prev_index;            // Update hash to point to the previous index in the LIS
            }
        }
    }

    // Find the maximum length and the index where the LIS ends
    int ans = -1;
    int lastIndex = -1;

    for (int i = 0; i <= n - 1; i++) {
        if (dp[i] > ans) {
            ans = dp[i];         // Update the LIS length
            lastIndex = i;       // Update the ending index of the LIS
        }
    }

    // Reconstruct the LIS by backtracking using hash[]
    ArrayList<Integer> temp = new ArrayList<>();
    temp.add(arr[lastIndex]);    // Add the last element of the LIS

    // Backtrack until we reach the start of the LIS chain
    while (hash[lastIndex] != lastIndex) {
        lastIndex = hash[lastIndex];         // Move to previous index
        temp.add(arr[lastIndex]);            // Add that element to the sequence
    }

    // Reverse the sequence since we built it from end to start
    System.out.print("The subsequence elements are ");
    for (int i = temp.size() - 1; i >= 0; i--) {
        System.out.print(temp.get(i) + " ");
    }
    System.out.println();

    // Return the length of the LIS
    return ans;
}

}
