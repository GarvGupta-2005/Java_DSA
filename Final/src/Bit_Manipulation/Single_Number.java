package Bit_Manipulation;

public class Single_Number {
    public static int singleNumber(int[] nums) {
        //The Brute solution is using a HashMap and store Value & Frequency and then check for the value apperaing once
        //The more efficient way is to use Bitwise Operator XOR as XOR with same number produces 0 and XOR with 0 produces 1
            int ans = 0;
            for(int i = 0;i<nums.length;i++){
                ans = ans^nums[i];
            }
            return ans;
        }
    
}
