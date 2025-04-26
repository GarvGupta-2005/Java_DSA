package Recursion.Hard;

public class StringPermutation {
    public static void stringPermutation( String s , String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i  = 0 ; i < s.length() ; i++){
           String left_part = s.substring(0,i);
           String right_part = s.substring(i+1);
           String chotaans = left_part + right_part ;
           char c = s.charAt(i);
           stringPermutation(chotaans, ans+c);
            }
        }

    
    public static void main(String[] args) {
        String s = "abc";
        stringPermutation(s, " ");
    }
}
