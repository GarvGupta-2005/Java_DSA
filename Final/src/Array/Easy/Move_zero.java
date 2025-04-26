package Array.Easy;

public class Move_zero {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
         if(nums[i] == 0){
            continue; 
         }else{
             int temp = nums[i] ; 
             nums[i] = nums[index];
             nums[index] = temp;
             index++;
         }
        }
     }
}
