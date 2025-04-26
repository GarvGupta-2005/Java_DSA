package Bit_Manipulation;

public class powerOf2 {
    public static boolean isPowerOfTwo(int n) {
        //Any number that is power of 2 will have only one set bot that is MSB
        if(n == 0 || n == Integer.MIN_VALUE ){ 
            return false;
        }
        if((n & n-1) == 0){ //If the number is a power of 2 then n-1 will have all the bits flipped and AND operation will be 0
            return true;
        }else{
            return false;
        }
    }
}
