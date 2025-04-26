package Strings.Hard;

import java.util.*;

public class StringHashing2 {
    static final int P = 31;
    static final int MOD = (int) 1e9 + 7;

    // Polynomial Rolling Hash Function
    public static long computeHash(String s) {
        long hash = 0;
        long power = 1;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash = (hash + val * power) % MOD;
            power = (power * P) % MOD;
        }

        return hash;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("aa");
        arr.add("ab");
        arr.add("aa");
        arr.add("b");
        arr.add("c");
        arr.add("dd");
        arr.add("b");

        // Use a HashSet to store unique hash values
        HashSet<Long> hashSet = new HashSet<>();

        for (String s : arr) {
            long hashVal = computeHash(s);
            hashSet.add(hashVal);
        }

        System.out.println("Number of distinct strings: " + hashSet.size());
    }
}

