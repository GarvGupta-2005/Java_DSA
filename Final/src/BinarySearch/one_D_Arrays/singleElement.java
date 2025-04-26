package BinarySearch.one_D_Arrays;

import java.util.ArrayList;

public class singleElement {
    public static int singleNonDuplicate(int[] nums) {
        //Observatin that is staring point 
        //Before the single element all pairs appera on even-odd indice pair that is left half and our answer in on right therefore eliminate left   and after single element they appear as odd-even indices that is right half and answer lies on left part therefore eliminate right part

        int n = nums.length;
        //Handling all base cases 
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){ return nums[n-1];}
        //Now begin for indice [1,n-2]
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid]; //The element we are looking for 
            }
            //left part does not contain single element therefore move right
            if((mid%2==1 && nums[mid-1]==nums[mid])|| (mid%2==0 && nums[mid]==nums[mid+1] ) ){
                low = mid + 1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of the array.

        // Edge cases:
        if (n == 1)
            return arr.get(0);
        if (!arr.get(0).equals(arr.get(1)))
            return arr.get(0);
        if (!arr.get(n - 1).equals(arr.get(n - 2)))
            return arr.get(n - 1);

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the single element:
            if (!arr.get(mid).equals(arr.get(mid + 1)) && !arr.get(mid).equals(arr.get(mid - 1))) {
                return arr.get(mid);
            }

            // We are in the left:
            if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))
                    || (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                // Eliminate the left half:
                low = mid + 1;
            }
            // We are in the right:
            else {
                // Eliminate the right half:
                high = mid - 1;
            }
        }

        // Dummy return statement:
        return -1;
}
}
