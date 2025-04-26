package TwoPointer_SlidingWindows.Medium;
import java.util.*;

public class Longest_SubString_Without_Repeating_Character {
    public int lengthOfLongestSubstring(String s) {
        //The Brute force Approach is to genertae all the Substrings anc then check which has no repating charcater and is longest
        int ans  = 0;
        for(int i = 0;i<s.length();i++){
            String sub = "";
            HashMap<Character,Integer> map = new HashMap<>();
            int len = 0;
            for(int j = i;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    break;
                }
                sub = sub + s.charAt(j);
                len = j-i+1;
                ans = Math.max(ans,len);
                map.put(s.charAt(j),1);
            }
        }
        return ans; 
    }


    public static int lengthOfLongestSubstring2(String s) {
        //Now we will be doning the optimal approach where we wil be using two poniters we will e placing l and r on 0th index
        //we will be keeping a map DS to stor the character and the index.
        //Whenever a repating character is encountered we move l to the next index of that place and store the character's new index
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                int cur_char_index = map.get(s.charAt(r));
                if(cur_char_index>=l){ //This condition is used to see whether l is before r or not then only substring is possible
                    l = cur_char_index + 1;//We move l to the next index where the current char was first spotted so that it does not repeat 
                }
            }
            int cur_len = r-l+1;
            ans = Math.max(ans,cur_len);
            map.put(s.charAt(r),r);
            r++;
        }
        return ans;
            }
}