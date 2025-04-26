 package BinarySearch.Answers_SearchSpace;

class KthMissingNo {
    public class Solution {
        //The trick is to find how many  numbers are missing upto  some point let us take an example
        //For instance we have an array [2,3,4,7,11] and ideally if no numbers are missing then it should be
        //[1,2,3,4,5] that is 7 in place of 4 thus amount of missing numbers will be 7-4 = 3
        //these numbers are 1,5,6 
        //Similarily in place of 5 we have 11 thus 11-5 = 6 i.e 1,5,6,8,9,10 are the 6 missing numbers
        //after applying BS we will get high and low at opposite starting points such that the gap between these
        //numbers will give us the answers as ans = high + 1 + k
        //this formula is derived from the above example itself
        public static int missingK(int[] arr, int n, int k) {
            // Write your code here.
            int low = 0;
            int high  = n-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                int missing = arr[mid] - (mid+1);
                if(missing < k){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            return high + 1 + k;
        }
    }
}