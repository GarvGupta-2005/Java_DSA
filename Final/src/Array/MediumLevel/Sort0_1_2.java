package Array.MediumLevel;

public class Sort0_1_2 {
    public void sortColors(int[] arr) {
        //OPTIMAL APPROACH  : DNF Algorithm
        //Dividing the array with 3-pointers 
        //low mid high 
        // array from low to mid will contain 0
        //array from mid t0 high will contain 1
        //and rest will contain 2
        int n = arr.length-1;
        int low = 0;
        int mid = 0;
        int high = n;
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[low];
                 arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }else if(arr[mid]==1){mid++;}
            else{
                int temp1 = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp1;
                high--;
            }
        }
}
//The better approach is to make 3 var: cnt0 , cnt1 , cnt2 and take their values 
//Then iterate over the array filling it from beginning and then filling 0 then 1 and then 2
}
