package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class generatePARENTHESIS {
    public static  boolean IsValid(String s){
        int count = 0 ;
    for(int i = 0 ; i < s.length() ; i++){
        if(s.charAt(i)=='('){
            count++;
        }
         else {
            if(count == 0){
            return false;
        }
        count--;
    }
    }
    if(count!=0){
        return false;
    }
    return true;
    }
    public static void helper(int rem_opening,int rem_closing,String ans,List<String>final_ans){
        if(rem_opening == 0 && rem_closing==0){
            if(IsValid(ans)){
                final_ans.add(ans);
            }
            return ;
        }
        if(rem_opening<0 || rem_closing<0){
            return;
        }
        if(rem_opening > rem_closing){
            return;
        }
        
        //use opening parenthesis
        helper(rem_opening-1, rem_closing,ans+"(",final_ans);
        // use closing bracket
        helper(rem_opening,rem_closing-1,ans+")",final_ans);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> final_ans = new ArrayList<>();
        helper(n,n,"",final_ans);
        return final_ans;
    }
//O(2^n) time complexity
}
