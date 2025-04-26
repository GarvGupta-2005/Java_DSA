package Strings.Medium1;
public class longestpalindromeSub {
      //Pretty intutive approach except of dp is that we assume each char as a center of palindrome and then start expanding both sides to left and right extreme to see whether char match
    public static String longestPalindrome(String s) {
        String res = "";
        int len = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome
            int[] odd = expandAroundCenter(s, i, i);
            if (odd[1] - odd[0] + 1 > len) {
                res = s.substring(odd[0], odd[1] + 1);
                len = odd[1] - odd[0] + 1;
            }
            
            // Even-length palindrome
            int[] even = expandAroundCenter(s, i, i + 1);
            if (even[1] - even[0] + 1 > len) {
                res = s.substring(even[0], even[1] + 1);
                len = even[1] - even[0] + 1;
            }
        }
        
        return res;
    }

    private static int[] expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] {l + 1, r - 1}; // Return the valid palindrome bounds
    }
}