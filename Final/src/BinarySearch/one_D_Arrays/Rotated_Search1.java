package BinarySearch.one_D_Arrays;
import java.util.*;
public class Rotated_Search1 {
    public static int search(ArrayList<Integer> nums, int n, int target) {
        // Write your code here.
        //The key point is to identify the sorted half as one side of mid can be sorted and one side can be not
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums.get(mid)==target){ return mid ;}
            if(nums.get(low)<=nums.get(mid)){  //left half is sorted condition
                if(nums.get(low)<= target && target <= nums.get(mid)){
                    high = mid - 1;
                }
                //The searching condition in that half
                else{  
                    low  = mid + 1;
                }
            }else{
                if(nums.get(mid)<=target && target<=nums.get(high)){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    

}
