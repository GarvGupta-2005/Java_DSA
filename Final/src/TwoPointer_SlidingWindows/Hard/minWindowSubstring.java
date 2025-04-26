package TwoPointer_SlidingWindows.Hard;

import java.util.HashMap;

public class minWindowSubstring {
    public String minWindow(String s, String t) {
        // Initialize two pointers for the sliding window
        int l = 0, r = 0;
        
        // Map to store the frequency of characters in string `t`
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        // `cnt` keeps track of how many characters of `t` have been matched so far
        int cnt = 0;

        // Variables to store the start index and the minimum length of the valid window
        int sindex = -1;
        int minlen = Integer.MAX_VALUE;

        // Populate the map with the frequency of characters in `t`
        for (int i = 0; i < t.length(); i++) {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Traverse the string `s` using the right pointer `r`
        while (r < s.length()) {
            char ch = s.charAt(r); // Current character

            // If the character exists in `t` and its count in the map is greater than 0,
            // it means this character is contributing to a valid substring
            if (mpp.containsKey(ch) && mpp.get(ch) > 0) {
                cnt++;
            }

            // Decrement the frequency of the current character in the map
            mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);

            // When all characters in `t` are matched, try to shrink the window
            while (cnt == t.length()) {
                // Check if the current window is smaller than the previously found windows
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1; // Update minimum length
                    sindex = l;         // Update starting index of the minimum window
                }

                // Shrink the window from the left by incrementing the left pointer `l`
                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) + 1);

                // If the character at the left pointer was part of `t` and its count becomes
                // positive, it means we're losing a required character
                if (mpp.get(s.charAt(l)) > 0) {
                    cnt--; // Decrease the count of matched characters
                }

                l++; // Move the left pointer to shrink the window
            }

            r++; // Expand the window by moving the right pointer
        }

        // If no valid window is found, return an empty string
        return sindex == -1 ? "" : s.substring(sindex, sindex + minlen);
    }
}

