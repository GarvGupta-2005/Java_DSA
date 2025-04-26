package TwoPointer_SlidingWindows.Hard;

import java.util.HashMap;

public class longest_Substring_With_k_distinctchar {
    public static int kDistinctChars(int k, String s) {
		// Write your code here
		int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r))+1);
            }else{
                map.put(s.charAt(r),1);
            }

            if(map.size()>k){  //If the 
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(map.size()<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
	}
}
