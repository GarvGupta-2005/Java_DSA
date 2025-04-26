package Bit_Manipulation;

import java.util.Arrays;

public class Single_Number2 {
    //The first Solution involves checking the previous element for difference
    //If they ar eequal then incremen the counter 3 times else if mismatch found then that is the answer
    //This will not  work with the corner case if the ans is last element that is pointer will go out of bounds 
    //In this case retrun last element
    public static int singleNumber2_1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1;i<n;i=i+3){
            if(nums[i-1]!=nums[i]){
                return nums[i-1];
            }
        }
        return nums[n-1];
    }

     //The second solution extensively uses Bitwise Operators XOR and NOT
    //We Use buckets to store the the characters that appears ones twice and then we move
    public int singleNumber2_2(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int i = 0;i<nums.length;i++){
            ones = (ones^nums[i])&(~twos);//This Stores the current value in ones if not present in twos
            twos = (twos^nums[i])&(~ones);//This Stores the current value in twos if not present in ones
        }
        return ones;
    }
}
