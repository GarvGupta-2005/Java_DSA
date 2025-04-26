package Strings.Basic;

import java.util.HashMap;

public class isoMorphic {
    public static boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> map = new HashMap<>();
        //Map the charaacters in s to characters in t
        //IF the same element appears twice in s then check if the character appearing in t is same or not
        //if same then continue else return false
        //Also the important part is to check if the same chacater is mapped to someone or not as it violates the rule that one chacater can be mapped to someone else

        for(int i = 0;i<s.length();i++){
            
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))==t.charAt(i)){
                    continue;
                }else{
                    return false;
                }

            }else{
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

}
