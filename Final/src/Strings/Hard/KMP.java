package Strings.Hard;

import java.util.ArrayList;


public class KMP {
//     In KMP Algorithm,
// We preprocess the pattern and build LPS array for it. The size of this array is same as pattern length.
// LPS is the Longest Proper Prefix which is also a Suffix. A proper prefix is a prefix that doesn’t include whole string. For example, prefixes of “abc” are “”, “a”, “ab” and “abc” but proper prefixes are “”, “a” and “ab” only. Suffixes of the string are “”, “c”, “bc”, and “abc”.
// Each value, lps[i] is the length of longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
// Preprocessing Overview:
// We search for lps in subpatterns. More clearly we focus on sub-strings of patterns that are both prefix and suffix.
// For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores the length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].



// Java program to search the pattern in given text using
// KMP Algorithm


    
    static void constructLps(String pat, int[] lps) {
        
        // len stores the length of longest prefix which 
        // is also a suffix for the previous index
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {
            
            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            
            // If there is a mismatch
            else {
                if (len != 0) {
                    
                    // Update len to the previous lps value 
                    // to avoid redundant comparisons
                    len = lps[len - 1];
                } 
                else {
                    
                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        // Pointers i and j, for traversing 
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched 
                // store the start index in result
                if (j == m) {
                    res.add(i - j);
                    
                    // Use LPS of previous index to 
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }
            
            // If there is a mismatch
            else {
                
                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res; 
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba"; 
        String pat = "aaba"; 

        ArrayList<Integer> res = search(pat, txt);
        for (int i = 0; i < res.size(); i++) 
            System.out.print(res.get(i) + " ");
    }




}


class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int N = txt.length();
        int M = pat.length();

        int[] lps = computeLPS(pat);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < N) {
            if (j < M && pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                result.add(i - j + 1); // Pattern found at index i - j + 1 (1-based indexing)
                j = lps[j - 1];
            } else if (i < N && (j == 0 || pat.charAt(j) != txt.charAt(i))) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
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
}
