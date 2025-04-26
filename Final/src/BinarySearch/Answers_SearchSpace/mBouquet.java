package BinarySearch.Answers_SearchSpace;
public class mBouquet {

    //In this problem we have to find it whether we can make m bouquets with k adjacent flowers
//if total required flowers excedd the array length then it is impossible to find an anser thus return-1
//Else we always have an answer 
//In this approach we have to find the minimum days to bloom all the flowers 
 //The max days is the highest value in the days array 
 //Thus high will be highest value 
 //The low will be the  minimum possibe l



        public static boolean isPossible(int [] arr,int mid,int k,int m){
        //In this function we will pass a time in days and see how many consecutive flowers we can bloom
        int n = arr.length; // Size of the array
            int cnt = 0;
            int noOfB = 0;
            // Count the number of bouquets:
            for (int i = 0; i < n; i++) {
                if (arr[i] <= mid) {
                    cnt++;
                } else {
                    noOfB += (cnt / k);
                    cnt = 0;
                }
            }
            noOfB += (cnt / k);
            return noOfB >= m;
     }
        public static int roseGarden(int[] arr, int k, int m) {
            // Write your code here.
            int low  = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            int ans = -1;
            int n = arr.length;
            for(int i = 0;i<n;i++){
                if(arr[i]<low){
                    low = arr[i];
                }
                if(arr[i]> high){
                    high = arr[i];
                }
            }
            while(low<=high){
                int mid = low + (high-low)/2;
                if(isPossible(arr,mid,k,m)){
                    ans = mid;
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
            }
            return ans;
        }
    
}