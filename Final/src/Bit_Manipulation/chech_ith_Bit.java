package Bit_Manipulation;

public class chech_ith_Bit {
    //The brute solution is to convert the number to binary and then check the ith bit
    //This will take O(logn) time to convert to binary and then O(i) time to check the ith bit

    //The optimal solution is to use the left shift operator
    //We will left shift 1<< i times and then do the AND operation with the number
    //if the ith bit is 1 then the result will be non zero else it will be zero

    public static boolean isIthBitSet(int n, int i){
        int mask = 1<<i;
        int ans = n & mask;
        if(ans != 0){
            return true;
        }
        return false;
    }
}
