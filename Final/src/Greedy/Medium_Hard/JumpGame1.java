package Greedy.Medium_Hard;
public class JumpGame1 {
    public static boolean canJump(int[] nums) {
        //This Can be solved using DP as well but here we use the Greedy technique
//At each point we will maintain a maxIndexReac to check whether we can reach the current point or not
//if the current index is beyond the reach of the maxIndex then return false;
//else increment maxIndex every time

int maxIndex = 0;
for(int i = 0; i<nums.length; i++){
    if(i>maxIndex) return false; //Unable to reach
    maxIndex = Math.max(maxIndex,nums[i]+i);
}
return true;

    }
}