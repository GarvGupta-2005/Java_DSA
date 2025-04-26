package Recursion.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kthPermutation {
    //The brute Approach is to recusively generate all the permutations and then return the kth permutation after sorting the data structure stroing all permutations
    //This will take O(n!) time complexity as there will be n! permutations

    public ArrayList<String> permutation(StringBuilder S, StringBuilder ans, ArrayList<String> list) {
        if (S.length() == 0) {
            list.add(ans.toString());
            return list ;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            S.deleteCharAt(i);
            ans.append(c);
            permutation(S, ans, list);
            ans.deleteCharAt(ans.length() - 1); // backtrack
            S.insert(i, c); // backtrack
        }
        return list;
    }

    public String getPermutation(int n, int k) {
        int factor = 10;
        int ans = 0;
        factor = (int) Math.pow(factor, n - 1);
        for (int i = 1; i <= n; i++) {
            ans = ans + i * factor;
            factor = factor / 10;
        }
        String s1 = String.valueOf(ans);
        ArrayList<String> res = new ArrayList<>();
        res = permutation(new StringBuilder(s1), new StringBuilder(""), res);
        Collections.sort(res);
        // System.out.println(res);
        return res.get(k-1);
    }

    //The optimized approach is as follows 
    // 1 + (2,3,4) i.e 3! permutations . This will conatain from 0 to 5 i.e 6 permutations
    // 2 + (1,3,4) i.e 3! permutations . This will conatain from 6 to 11 i.e 6 permutations
    // 3 + (1,2,4) i.e 3! permutations . This will conatain from 12 to 17 i.e 6 permutations
    // 4 + (1,2,3) i.e 3! permutations . This will conatain from 18 to 23 i.e 6 permutations
    // So if k = 14 then according to 0-based indexing the answer will lie in the 3rd group i.e 3 + (1,2,4) and the 14th permutation will be 3 2 1 4
    //if k = 17 then according to 0-based indexing the answer 16/6 = 2 i.e 3 + (1,2,4) and 16%6 = 4 i.e the 4th permutation of 3 + (1,2,4) i.e 3 4 1 2
    //continue doing this until the size of numbers list becomes 0
    public String getPermutation2(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1;i<n;i++){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k=k-1;
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);        
            if(numbers.size()==0){
                break;
            }
            k = k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }
}
