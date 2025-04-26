package Strings.Hard;

public class NaiveStringMatching {
    public int strStr(String hay, String needle) {
        int ans = -1;

        // Edge case: if needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Length of the sliding window (same as the length of needle)
        int windowSize = needle.length();

        // Iterate through the haystack with a sliding window
        for (int i = 0; i <= hay.length() - windowSize; i++) {
            // Extract the current window of the same length as the needle
            String currentWindow = hay.substring(i, i + windowSize);

            // Check if the current window matches the needle
            if (currentWindow.equals(needle)) {
                return i; // Found the first occurrence
            }
        }

        // If no match is found, return -1
        return ans;
    }
}
