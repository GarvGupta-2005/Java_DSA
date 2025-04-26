package Bit_Manipulation;

public class clear_ith_Bit {
    //Agin , it will be done by left shifting 1 i times and then taking the NOT of it
    //Then we will do AND operation with the number
    //This will clear the ith bit and the rest of the bite will remain same
    public  static int clearIthBit(int n, int i){
        int mask  = ~(1<<i);
        int ans = n & mask;
        return ans;

    }
}
