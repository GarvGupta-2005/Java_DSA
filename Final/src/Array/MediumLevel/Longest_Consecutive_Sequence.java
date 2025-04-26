package Array.MediumLevel;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] a) {
        // How to identify if a number can be the starting number for a sequence:

// First, we will put all the array elements into the set data structure.
// If a number, num, is a starting number, ideally, num-1 should not exist. So, for every element, x, in the set, we will check if x-1 exists inside the set. :
// If x-1 exists: This means x cannot be a starting number and we will move on to the next element in the set.
// If x-1 does not exist: This means x is a starting number of a sequence. So, for number, x, we will start finding the consecutive elements.
// How to search for consecutive elements for a number, x:

// Instead of using linear search, we will use the set data structure itself to search for the elements x+1, x+2, x+3, and so on.
// Thus, using this method we can narrow down the search and optimize the approach.
int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
