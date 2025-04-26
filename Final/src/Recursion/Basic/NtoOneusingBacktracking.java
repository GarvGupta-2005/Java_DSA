package Recursion.Basic;

public class NtoOneusingBacktracking {
    public static void helper(int i,int n){
        if(i>n){
            return;
        }
        helper(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        helper(1, 10);
    }
}
