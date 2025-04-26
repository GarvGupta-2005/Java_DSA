package Strings.Medium1;

public class stringToInteger {
    public static int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        if (s.isEmpty()) return 0;

        boolean isNegative = false; // Flag for negative numbers
        int index = 0;

        // Check for a sign at the start
        if (s.charAt(0) == '-') {
            isNegative = true;
            index++;
        }else if(s.charAt(0)=='+'){
            index++;
        }

        long ans = 0; // Use long to detect overflow during calculation

        // Process the string, character by character
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            ans = ans * 10 + (s.charAt(index) - '0');
            
            // Clamp the value to the range immediately if it exceeds the bounds
            if (!isNegative && ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && -ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

            index++;
        }

        // Apply the sign
        ans = isNegative ? -ans : ans;

        // Clamp the result to 32-bit integer range
        if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans; // Safe to cast to int
    }
}
