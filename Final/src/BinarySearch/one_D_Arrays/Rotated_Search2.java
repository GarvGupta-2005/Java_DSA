package BinarySearch.one_D_Arrays;

public class Rotated_Search2 { //Contains duplicate also 
    public static boolean searchInARotatedSortedArrayII(int []nums, int target) {
        // Write your code here.
         //The condition that prevents us from findinig the correct half is a[low]==a[mid]==a[high]
        //For instance if arr [] = [3,1,2,3,3,3,3,]
        //Thus we have to elminat ethis condition 
        
        //...........................................................................................

        //The key point is to identify the sorted half as one side of mid can be sorted and one side can be not
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){ return true ;}
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }//To eliminate the unnecceasry condition 
            if(nums[low]<=nums[mid]){  //left half is sorted condition
                if(nums[low]<= target && target <= nums[mid]){
                    high = mid - 1;
                }
                //The searching condition in that half
                else{  
                    low  = mid + 1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
