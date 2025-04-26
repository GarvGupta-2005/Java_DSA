package TwoPointer_SlidingWindows.Hard;

public class minWindowSubsequence {
    /*
	Time Complexity: O( N * N )
	Space Complexity: O( 1 )

	where N is the length of string 
*/

public class Solution {
    
    public static String minWindow(String S, String T) {
        
        // Initially our window is empty
        String window = "";
        int j = 0, min = S.length() + 1;
        
        for (int i = 0; i < S.length(); i++) {
            
            // If characters are same, then increment the j pointer
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                
                // If we finally reach the end of string T, we can start shrinking our window
                if (j == T.length()) {
                    int end = i + 1;
                    j--;
                    
                    // We are doing j-- in order to minimise our window size
                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    
                    // Incrementing i and j for next iteration
                    j++;
                    i++;
                    
                    // Updating our window, if we found an element of minimum length
                    if (end - i < min) {
                        
                        // Updating minimum
                        min = end - i;
                        
                        // Updating window
                        window = S.substring(i, end);
                    }
                }
            }
        }
        
        //returning our final answer, which is stored in window
        return window;
    }
}
}
