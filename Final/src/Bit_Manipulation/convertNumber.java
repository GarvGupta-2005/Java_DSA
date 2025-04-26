package Bit_Manipulation;

public class convertNumber {
    public static int CountSetBits(int n){
        int ans = 0;
        while(n>1){
            ans += n&1;
            n = n>>1;
        }
        if(n==1){
            ans++;
        }
        return ans;
    } 
    public static int minBitFlips(int start, int goal) {
        //The efficent way to do this is using XOR
        //The XOR operator will flip all the that are not same to 1 thus we just need to count ones in it
        int ans = start^goal;
        return CountSetBits(ans);
    }
}
