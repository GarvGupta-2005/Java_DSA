package BinarySearch.one_D_Arrays;

public class minInRotatedArray {
    public static int findMin(int []arr) {
        // Write your code here.
        //The condept is same to find whether the left half is sorted or the right half is sorted
        //if left half is sorted ans = Math.min(ans,arr[low])
        //if right half is sorted ans = Math.min(ans,arr[mid])
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[low]<=arr[mid]){
                ans = Math.min(ans,arr[low]);
                low = mid + 1;
            }else{
                ans = Math.min(ans,arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
