package Recursion.Basic;


public class oneToN_backtracking {
    public static void helper(int i,int n){
        if(i<1){
            return;
        }
        helper(i-1, n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        helper(8, 8);
    }
}
