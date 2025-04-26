package TwoPointer_SlidingWindows.Medium;
public class binarySubArraywithSum {

    //This is a very intutive problem as it requires a bit of math
//The Solution lies in order to find the the numberOfSubarrays with sum<= goal and subarray count with sum<=goal-1 
//then we sybtract the answers and we get the count of subarrays with sum == goal

public static int countSubarrayWithSumGoal(int [] a,int goal){
    if(goal<0) return 0;
    int count = 0;
    int l = 0;
    int r = 0;
    int n = a.length;
    int sum = 0;
    while(r<n){
        sum+=a[r];
        while(sum>goal){
            sum -= a[l];
            l++;
        }
        count += (r-l+1);
        r++;
    }
    return count;
}
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarrayWithSumGoal(nums,goal) - countSubarrayWithSumGoal(nums,goal-1);
    }
}