package Strings.Basic;

import java.util.*;

public class revWordinStr {
    //This approach makes words and then store them in a linear structure and then reverse add them this takes O(n) space complexity
    public static String reverseWords(String s) {
        String cur = "";
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                cur = cur + s.charAt(i);
            }else{
                cur = cur.trim();
                temp.add(cur);
                cur = "";
            }
        }
        temp.add(cur);
        // System.out.println(temp);
        String res = "";
        for (int i = temp.size() - 1; i >= 0; i--) {
            // Check if the element is a string of spaces
            if (temp.get(i).trim().isEmpty()) {
                // Remove the string of spaces
                temp.remove(i);
            }
        }
        // System.out.println(temp);
        for(int i = temp.size()-1;i>=0;i--){
            res = res + temp.get(i);
            res = res + " ";
        }
        return  res.trim();
    }
    //This is an approach without extra space
    public static String revrseWords(String s) {
        String result = new String();
     int i = 0;
     int n = s.length();
 
     while(i < n){
         while(i < n && s.charAt(i) == ' ') i++;
         if(i >= n) break;
         int j = i + 1;
         while(j < n && s.charAt(j) != ' ') j++;
         String sub = s.substring(i, j);
         if(result.length() == 0) result = sub;
         else result = sub + " " + result;
         i = j+1;
     }
     return result;
     }

}
