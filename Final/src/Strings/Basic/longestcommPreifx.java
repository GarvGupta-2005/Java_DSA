package Strings.Basic;

public class longestcommPreifx {
    public static String LongestCommonPrefix(String [] strs){
        if (strs == null || strs.length == 0) return ""; // Handle edge cases
        
        String res = ""; // To store the result

        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i); // Take the character from the first string
            
            // Check this character against all other strings
            for (String s : strs) {
                // If the character index exceeds any string length or there's a mismatch
                if (i >= s.length() || s.charAt(i) != currentChar) {           //This for each loop checks for each string in the Strs arrays
                    return res; // Return the common prefix found so far
                }
            }

            // If the character is common to all strings, append it to the result
            res += currentChar;
        }

        return res; // Return the result if the loop completes
    }
}
