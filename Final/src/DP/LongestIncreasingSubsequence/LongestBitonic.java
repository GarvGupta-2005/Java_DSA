import java.util.Arrays;

public class LongestBitonic {
    //Just we can say that kongest increasing and longest decreasing is also a bitonic subsequence
    //We just have to apply LIS first from the forward direction and then from backward
    //THis will help us count all the elements upto some midpoint which will give us the answer
    
    public static int LongestBitonicSequence(int n, int[] arr) {
         // A bitonic sequence is one that first increases then decreases
    // So we find LIS from the front and LIS (on reversed array = LDS) from the back

    int[] dp1 = new int[n]; // For Longest Increasing Subsequence (LIS)
    int[] dp2 = new int[n]; // For Longest Decreasing Subsequence (LDS from i to end)

    Arrays.fill(dp1, 1); // Each element alone is length 1
    Arrays.fill(dp2, 1);

    // Step 1: Compute LIS from left to right
    for (int i = 0; i < n; i++) {
        for (int prev = 0; prev < i; prev++) {
            if (arr[prev] < arr[i]) {
                dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
            }
        }
    }

    // Step 2: Compute LDS from right to left (same as LIS but reversed logic)
    for (int i = n - 1; i >= 0; i--) {
        for (int next = n - 1; next > i; next--) {
            if (arr[next] < arr[i]) {
                dp2[i] = Math.max(dp2[i], 1 + dp2[next]);
            }
        }
    }

    int maxLength = 0;

    // Step 3: Combine LIS and LDS values for each index
    // Subtract 1 to avoid double-counting the peak element
    for (int i = 0; i < n; i++) {
        maxLength = Math.max(maxLength, dp1[i] + dp2[i] - 1);
    }

    return maxLength;
    }
}
