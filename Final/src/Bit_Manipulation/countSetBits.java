package Bit_Manipulation;

public class countSetBits {
    //Rather than using the modulous operator we can use the AND operator to check if the last bit is 1 or not
    //If the last bit is 1 then the number is odd and therefore the number leaves remainder 1 on divison by 2
    //To reduce the number we can simply right shifht it once since right shift is equivalent to dividing by 2
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
}
