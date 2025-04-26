package Bit_Manipulation;

public class divideWithoutOperators {
    // This question is solved by simple logic: how many powers of two can be removed from the dividend.
    // We will keep removing powers of two from the dividend and see till which count does 1 is received in remainder.
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Handle simple cases
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }

        // Determine the sign of the result
        boolean sign = true;
        if (dividend >= 0 && divisor < 0) sign = false;
        else if (dividend <= 0 && divisor > 0) sign = false;

        // Work with absolute values
        long n = Math.abs((long) dividend); // Convert to long to avoid overflow
        long d = Math.abs((long) divisor); // Convert to long to avoid overflow
        long quotient = 0;

        // Perform division using bit manipulation
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt += 1;
            }
            quotient += 1L << cnt;
            n -= (d << cnt);
        }

        // Apply the sign to the result
        if (!sign) {
            quotient = -quotient;
        }
       
        // Return the final result
        return (int) quotient;
    }
}
