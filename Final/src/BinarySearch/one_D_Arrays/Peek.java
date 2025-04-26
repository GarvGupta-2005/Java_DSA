package BinarySearch.one_D_Arrays;

public class Peek {
    public static int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        int n = nums.length;
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        //The thing is to realize the side where the peek will lie 
        //if the mid is gretaer than prev element and smaller than next element then peek lies on other half 
       int low = 1;
       int high = n-2;
       while(low<=high){
        int mid = low + (high-low)/2;
        if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){ return mid;}
        else if(nums[mid-1]<nums[mid]){ low = mid + 1;}
        else{
            high  = mid - 1;
        }
       } 
return -1;
    }
}
