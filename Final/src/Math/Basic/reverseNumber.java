package Math.Basic;

public class reverseNumber {
    public static int reverse(int x) {
        if(x == 0){
            return x;
        }
        boolean sign = true;//Positive number
        if(x<0){
            sign = false;//negative conifirmed
        }
        x = Math.abs(x);
        long revNum = 0; //Long datatype since answer can extend the boundaries of Integer
        long n = x;
        while(n>0){
            long cur = n%10;
            revNum = (revNum*10) + cur;
            n=n/10;
        }
        if(revNum>=Integer.MAX_VALUE && sign==true){
            return 0;
        }
        if(revNum>=Integer.MAX_VALUE && sign == false){
            return 0;
        }
        if(sign == false){
            revNum = -1*revNum;
        }
        return (int)revNum;

    }
}
