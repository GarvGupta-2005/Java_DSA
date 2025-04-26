package TwoPointer_SlidingWindows.Medium;

public class longestrepeatingCharacterReplacement {
    //if we have a string like "ABAB" then the max conversion is counted as = Length - maxCharacterFrequency
    //Length - maxFrequncyCharacter <= k

    public static int characterReplacement(String s, int k) {
        int l = 0; // Left pointer of the sliding window
        int maxFreq = 0; // Maximum frequency of a single character in the current window
        int result = 0; // Length of the longest substring
        int[] hash = new int[26]; // Array to store the count of each character

        for (int r = 0; r < s.length(); r++) { // Right pointer of the sliding window
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']); // Update the maximum frequency in the window

            // Check if the current window size is valid
            if ((r - l + 1) - maxFreq > k) { 
                // If the replacements needed exceed k, shrink the window
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            // Update the result with the length of the valid window
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
    
}
