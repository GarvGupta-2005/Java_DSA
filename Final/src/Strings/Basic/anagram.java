package Strings.Basic;

public class anagram {
    //Two strings can be anagrams only if one can be made using other strings' characters thus they have to have same chacter frequncy and same charaters
        public static boolean isAnagram(String s, String t) {
            int [] frequency1 = new int[256];
            for(int i = 0 ; i<s.length();i++){
                char cur_char = s.charAt(i);
                int cur_char_ascii = cur_char;
                frequency1[cur_char_ascii]+=1;
            }
            int [] frequency2 = new int[256];
            for(int i = 0 ; i<t.length();i++){
                char cur_char = t.charAt(i);
                int cur_char_ascii = cur_char;
                frequency2[cur_char_ascii]+=1;
            }
          for(int i = 0 ; i < 256 ; i++){
            if(frequency1[i]==frequency2[i]){
                continue;
            }else{return false;}
          }
          return true;
        }
    }

