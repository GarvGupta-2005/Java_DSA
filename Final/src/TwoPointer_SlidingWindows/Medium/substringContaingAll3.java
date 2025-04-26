package TwoPointer_SlidingWindows.Medium;

import java.util.Arrays;

public class substringContaingAll3 {
    //The idea is to use sliding windows efficiently to generate all the substrings
    //We will store the indices of chacaters in a map
    //We will see when is the minimal window possible or which character has the minimum index occuring
    //When we find the minimal windo index that contains all three characters add 1 to that index and it to the answer
    public static  int numberOfSubstrings(String s) {
        int ans = 0;
        int [] lastSeen = new int[3];//For storing the indices of a , b ,c
        Arrays.fill(lastSeen,-1);
        
        for(int i = 0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a'] = i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1  && lastSeen[2]!=-1 ){
                ans = ans + (1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return ans;
    }
}
