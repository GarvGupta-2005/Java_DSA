package Recursion.Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class binaryStrings {
    public static void allBinaryStrings(String ans,int len,List<String> arr){
        
        if(ans.length() == len){
           boolean flag = true;
           for(int i = 1;i<ans.length();i++){
               if(ans.charAt(i)=='1' && ans.charAt(i-1)=='1'){
                   flag = false;
                   break;
               }
           }
           if(flag == true){
               arr.add(ans);
           }
            return;
        }
        
        if(ans.length()>len){
            return;
        }
        
        allBinaryStrings(ans+'0',len,arr);
        allBinaryStrings(ans+'1',len,arr);
        
    }
  public static List<String> generateBinaryStrings(int n) {
    // code here
    
    List<String> arr = new ArrayList<>();
    allBinaryStrings("",n,arr);
    return arr;
    
  }
}
