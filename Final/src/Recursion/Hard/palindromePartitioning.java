package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {

    public boolean isPalindrome(int i,int j,String s){
       
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(0,s,result,cur);
        return result;
    }
    public void helper(int index,String s,List<List<String>> result,List<String> cur){
        if(index == s.length()){
            result.add(new ArrayList<>(cur));
            return ;
        }
        for(int i= index;i<s.length();i++){
            if(isPalindrome(index,i,s)){
                cur.add(s.substring(index,i+1));
                helper(i+1,s,result,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
}