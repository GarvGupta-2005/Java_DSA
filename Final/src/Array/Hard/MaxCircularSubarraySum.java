package Array.Hard;

public class MaxCircularSubarraySum {
     //In out first attempt we were tring to iterate circularly on the array 
    //But after reading the hint it is clear that the sum is divided in two parts 
    //Either the max sum is in between or it it split accross
    //For max sum we can findi it directly using kadane's 
    //For split in that cae we have to find the min_sum and subtract it from total 
    //This will give us the max in circular

    public int maxSum(int nums[]){
        int ans = Integer.MIN_VALUE;
        int cur = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            cur += nums[i%n];
            ans = Math.max(ans,cur);
            if(cur<0){
                cur = 0;
            }
        }
        return ans;
    }
    public int minSum(int[] nums){
        int ans = Integer.MAX_VALUE;
        int cur = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            cur += nums[i%n];
            ans = Math.min(ans,cur);
            if(cur>0){
                cur = 0;
            }
        }
        return ans;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int max_kadane = maxSum(nums);
        int min_kadane = minSum(nums);
        int circular_max = total - min_kadane;

        // If all elements are negative, return max_kadane (not circular_max)
        if (circular_max == 0) {
            return max_kadane;
        }

        return Math.max(max_kadane, circular_max);
    }
}
