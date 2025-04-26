package Strings.Medium1;
import java.util.*;
public class romanToInt {
        public int romanToIn(String s) {
            //The logic is simple /
            //If the bigger value is before smaller value you add it 
            //and if the smaller value comes before then it is subtracted
            //This could have been solved by just thinking 
            HashMap<Character,Integer> map = new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);
            int ans = 0;
            for(int i = 0;i<s.length();i++){
                if(i+1<s.length() && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                    ans -= map.get(s.charAt(i));
                }else{
                    ans += map.get(s.charAt(i));
                }
            }
            return ans;
        }
    
}
