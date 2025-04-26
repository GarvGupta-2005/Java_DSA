package Strings.Hard;

public class Shoertest_Palindrome {
    //The way to apply KMP in this is by the following 
//"The longest proper  prefix in S which is also a suffix in reversed S which is also a palindrome"
//We could have thought of KMP because we were required to add the characters on the front part


private String reverse(String s){
    StringBuilder sb = new StringBuilder("");

    for(int i = s.length() - 1; i>=0 ; i--){
        sb.append(s.charAt(i));
    }

    return sb.toString();
}

private int[] computeLPS(String pattern) {
    int M = pattern.length();
    int[] lps = new int[M];
    int len = 0; // Length of the previous longest prefix suffix

    lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]

    int i = 1;
    while (i < M) {
        if (pattern.charAt(i) == pattern.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1]; //You can also write, len = len-1;
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }

    return lps;
}

public String shortestPalindrome(String s) {
    String rev = reverse(s);

    String temp = s + "-" + rev;

    int [] lps = computeLPS(temp);

    int longestLPS = lps[lps.length - 1];

    String remaining = rev.substring(0,s.length() - longestLPS);
    return remaining + s;
}
}
