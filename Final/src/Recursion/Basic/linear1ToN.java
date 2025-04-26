package Recursion.Basic;
import java.util.*;
public class linear1ToN {

    public static void helper(int n,int count){
        if(count >n){
            return;
        }
        System.out.println(count);
        helper(n, count+1);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        helper(n,0);
        s.close();
    }
}
