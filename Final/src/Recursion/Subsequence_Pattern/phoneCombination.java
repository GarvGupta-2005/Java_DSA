package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class phoneCombination {
    
    public static void All_Combinations(int i,String s,String ans,List<String> res){
        if(i == s.length()){
            res.add(ans);
            return;
        }
        if(s.charAt(i)=='2'){
            All_Combinations(i+1,s,ans+"a",res);
            All_Combinations(i+1,s,ans+"b",res);
             All_Combinations(i+1,s,ans+"c",res);
        }
        if(s.charAt(i)=='3'){
            All_Combinations(i+1,s,ans+"d",res);
            All_Combinations(i+1,s,ans+"e",res);
             All_Combinations(i+1,s,ans+"f",res);

        }
        if(s.charAt(i)=='4'){
            All_Combinations(i+1,s,ans+"g",res);
            All_Combinations(i+1,s,ans+"h",res);
             All_Combinations(i+1,s,ans+"i",res);
        }
        if(s.charAt(i)=='5'){
            All_Combinations(i+1,s,ans+"j",res);
            All_Combinations(i+1,s,ans+"k",res);
             All_Combinations(i+1,s,ans+"l",res);

        }
        if(s.charAt(i)=='6'){
            All_Combinations(i+1,s,ans+"m",res);
            All_Combinations(i+1,s,ans+"n",res);
             All_Combinations(i+1,s,ans+"o",res);

        }
        if(s.charAt(i)=='7'){
            All_Combinations(i+1,s,ans+"p",res);
            All_Combinations(i+1,s,ans+"q",res);
             All_Combinations(i+1,s,ans+"r",res);
              All_Combinations(i+1,s,ans+"s",res);
        }
        if(s.charAt(i)=='8'){
            All_Combinations(i+1,s,ans+"t",res);
            All_Combinations(i+1,s,ans+"u",res);
             All_Combinations(i+1,s,ans+"v",res);

        }
        if(s.charAt(i)=='9'){
            All_Combinations(i+1,s,ans+"w",res);
            All_Combinations(i+1,s,ans+"x",res);
             All_Combinations(i+1,s,ans+"y",res);
            All_Combinations(i+1,s,ans+"z",res);

        }
       
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.equals("")==true){
            return res;
        }
        All_Combinations(0, digits, "",res);
        return res;
    }

}
