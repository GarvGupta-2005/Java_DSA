package Recursion.Basic;

public class palindromeCheckRecursion {
    public static boolean isPalindrome(int i , String s,int n){
        if(i>=n/2){
            return true;
        }
        if(s.charAt(i)!=s.charAt(n-i-1)){
            return false;
        }
        return isPalindrome(i+1, s, n);
    }
}
