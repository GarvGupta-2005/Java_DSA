package Math.Basic;

public class palindrome {
    public static boolean palindromeNumber(int n){
        // Write your code here.
        int revNum = 0;
        int x = n;
        while(x>0){
            int cur = x%10;
            revNum = revNum*10 + cur;
            x/=10;
        }
        return revNum==n;
    }
}
