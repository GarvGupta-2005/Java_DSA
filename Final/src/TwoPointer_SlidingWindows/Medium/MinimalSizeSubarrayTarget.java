package TwoPointer_SlidingWindows.Medium;

public class MinimalSizeSubarrayTarget {
    public int minSubArrayLen(int target, int[] nums) {
        
        int l = 0;
        int r = 0;
        int size = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        while(r<n){
            sum+=nums[r];
            while(sum>=target){
                size = Math.min(size,r-l+1);//Potential answer spotted
                sum -= nums[l++];
            }
            r++;
        }
        if(size == Integer.MAX_VALUE){
            return 0;
        }else{
            return size;
        }
    }
}
