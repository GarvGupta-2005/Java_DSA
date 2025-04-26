import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {
    
    // Comparator to sort strings based on their length
    Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    // Checks if s2 is a valid predecessor of s1
    // That means: s1 is s2 + one extra character somewhere
    boolean isPredecessor(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;

        int first = 0;  // pointer for s1
        int second = 0; // pointer for s2

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++; // Skip one char from s1
            }
        }

        return second == s2.length(); // All chars in s2 should be matched
    }

    public int longestStrChain(String[] arr) {
        int n = arr.length;

        // Convert array to list to use sort with comparator
        List<String> words = new ArrayList<>(Arrays.asList(arr));
        words.sort(comp); // Sort by length of strings

        int[] dp = new int[n];         // dp[i] stores length of longest chain ending at words[i]
        Arrays.fill(dp, 1);            // Every word can be a chain of length 1

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (isPredecessor(words.get(i), words.get(prev)) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
