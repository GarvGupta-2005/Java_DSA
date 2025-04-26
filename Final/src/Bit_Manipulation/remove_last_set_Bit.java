package Bit_Manipulation;

public class remove_last_set_Bit {
    public static int removeLastSetBit(int n){
        return (n & (n-1));
    }
}
