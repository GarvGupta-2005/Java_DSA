package Array.Easy;

public class maxConsecutive_1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximum = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                maximum = Math.max(count,maximum);
            }else{
                count = 0;
            }
        }
        return maximum;
    }
}
