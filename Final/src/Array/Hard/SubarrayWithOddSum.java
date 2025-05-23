package Array.Hard;

public class SubarrayWithOddSum {


    //This problem is of the topic Prefix Sum whicj i hate the most 
    //The key idea is that if the the current sum id odd then sum from the start to current is odd and to make another odd subarray 
    //We need to add an even number or an even subarray so we add evencount to it 
        public static int numOfSubarrays(int[] arr) {
            final int MOD = 1_000_000_007;
            int count = 0, prefixSum = 0;
            // evenCount starts as one since the initial sum (0) is even
            int oddCount = 0, evenCount = 1;
    
            for (int num : arr) {
                prefixSum += num;
                // If current prefix sum is even, add the number of odd subarrays
                if (prefixSum % 2 == 0) {
                    count += oddCount;
                    evenCount++;
                } else {
                    // If current prefix sum is odd, add the number of even
                    // subarrays
                    count += evenCount;
                    oddCount++;
                }
    
                count %= MOD; // To handle large results
            }
    
            return count;
        }
    
}
