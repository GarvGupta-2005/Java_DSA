package Bit_Manipulation;
public class toggling_ith_Bit {

    //Done using the left shift and XOR operation
    public static int toggleIthBit(int n, int i){
        int mask = 1<<i;
        int ans = n^mask;
        return ans;
    }
}