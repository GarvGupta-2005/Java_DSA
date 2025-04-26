package Bit_Manipulation;

public class get_ith_Bit {
    public int getIthBit(int n, int i){
        int ithBit = (n>>i)&1;
        return ithBit;
    }
}
