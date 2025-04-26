package Bit_Manipulation;

public class xorInRange {
    //The brute solution is to iterate from l to r and then XOR all the numbers
    //The optimal solution is to use the properties of XOR
    //if N%4 = 0 then XOR will be N
    //if N%4 = 1 then XOR will be 1
    //if N%4 = 2 then XOR will be N+1
    //if N%4 = 3 then XOR will be 0
    public static int xorFrom1toN(int n){
        if(n%4==0){
            return n;
        }
        else if(n%4 == 1){
            return 1;
        }
        else if(n%4 == 2){
            return n+1;
        }else{
            return 0; //n%4 == 3
        }
    }
    public static int findXOR(int l, int r) {
        int xorFrom1toL = xorFrom1toN(l-1);
        int xorFrom1roR = xorFrom1toN(r);
        return xorFrom1toL ^ xorFrom1roR; 
        //if l = 4 and r  = 8
        //(1^2^3)^(1^2^3^4^5^6^7^8) = 4^5^6^7^8 as 1^1^2^2^3^3 = 0 and 0^4^5^6^7^8 = 4^5^6^7^8
    }
}
