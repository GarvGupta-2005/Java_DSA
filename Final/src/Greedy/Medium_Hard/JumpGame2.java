package Greedy.Medium_Hard;

public class JumpGame2 {
    public static int jump(int[] nums) {
        //One Solution is to use DP and use Memorization to solve this 
        //Here We will use Greedy Approach to Solve this

        int jumps = 0, l = 0, r = 0;
        int n = nums.length;
        //We will be making intervals by using the two pointers
        //Either l or r will represent the largest distance and smallest distance
        // and we will increment tthe largest pointer until we reach n
        while(r<n-1){
            int farthest = 0;
            for(int index = l;index<=r;index++){
                farthest = Math.max(farthest,index+nums[index]);
            }
            l = r+1;
            r = farthest;
            jumps = jumps + 1;
        }
        return jumps;
    }
}
