package TwoPointer_SlidingWindows.Medium;

public class niceSubArrayCount {
     //This question is converte into the binarySubarray with sum k by converting the elements into 0 and 1 by dividing by 2
     public static int countSubarrayWithSumGoal(int [] a,int goal){
        if(goal<0) return 0;
        int count = 0;
        int l = 0;
        int r = 0;
        int n = a.length;
        int sum = 0;
        while(r<n){
            sum+= (a[r]%2);
            while(sum>goal){
                sum -= (a[l]%2);
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
        public int numberOfSubarrays(int[] nums, int k) {
            return countSubarrayWithSumGoal(nums,k) - countSubarrayWithSumGoal(nums,k-1);
        }
}
