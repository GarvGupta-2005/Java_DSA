package Recursion.Basic;
import java.util.*;
public class printNameNTimes {
    public static void helper(String n, int times) {
        if(times == 0){
            return;
        }
        System.out.println(n);
        helper(n, times-1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.next();
        int times = s.nextInt();
        helper(n,times);
        s.close();
    }
}
