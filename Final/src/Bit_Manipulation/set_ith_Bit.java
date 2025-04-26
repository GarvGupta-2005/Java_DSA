package Bit_Manipulation;

public class set_ith_Bit {
    //This will be done similarily to check ith bit 
    //First we will left shift 1 i times and then do OR operation with the number
    //This will set the ith bit to 1 if it was 0 and if it was already 1 then it will remain 1

    public static int setIthBit(int n, int i){
        int mask = 1<<i;
        int ans = n | mask;
        return ans;
    }

    
}
