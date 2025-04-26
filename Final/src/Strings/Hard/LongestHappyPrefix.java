package Strings.Hard;

public class LongestHappyPrefix {
    private int[] computeLPS(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int len = 0; // Length of the previous longest prefix suffix

        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public String longestPrefix(String s) {
        int[] lps = computeLPS(s);
        int len = lps[s.length() - 1]; // length of longest prefix also a suffix
        return s.substring(0, len);   // extract and return the string
    }
}
