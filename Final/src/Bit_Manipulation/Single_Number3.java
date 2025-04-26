package Bit_Manipulation;
public class Single_Number3 {
    public static int[] singleNumber(int[] nums) {
        // Step 1: Compute XOR of all numbers in the array.
        // XORR will be the XOR of the two unique numbers since duplicate numbers cancel out.
        long XORR = 0;
        for (int i = 0; i < nums.length; i++) {
            XORR = XORR ^ nums[i];
        }

        // Step 2: Find the rightmost set bit in XORR.
        // This bit is where the two unique numbers differ.
        long right = (XORR & (XORR - 1)) ^ XORR;

        // Step 3: Partition numbers into two groups based on the rightmost set bit.
        // Group 1: Numbers with the rightmost set bit.
        // Group 2: Numbers without the rightmost set bit.
        int b1 = 0, b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i] & right; // Check if the rightmost set bit is set.
            if (cur != 0) {
                // XOR numbers in Group 1 to isolate the first unique number.
                b1 = b1 ^ nums[i];
            } else {
                // XOR numbers in Group 2 to isolate the second unique number.
                b2 = b2 ^ nums[i];
            }
        }

        // Step 4: Return the two unique numbers.
        return new int[] {b1, b2};
    }
}
