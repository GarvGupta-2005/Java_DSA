
package BinarySearch.Answers_SearchSpace;
import java.util.Arrays;

public class aggreCows {

    //The minimum distance is maximum between any two cows that is if any cows will have minimum distance 1 between them we try to increase this ditance for us
    //we will have to write a function which checks whether we can place a specific number of cows in the given stall distances such that the distance we give is achieved
    public static boolean canWePlace(int [] stalls,int distance,int k){
        int cur_cow = 1;
        int pos_of_last_cow = stalls[0];
        int n = stalls.length;
        for(int i = 1;i<n;i++){
            if(stalls[i]-pos_of_last_cow>=distance){
                cur_cow++;
                pos_of_last_cow = stalls[i];
            }
        }
        if(cur_cow>=k){
            return true;
        }else{
            return false;
        }
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = 1;
        int n = stalls.length;
        int high = stalls[n-1] - stalls[0];
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canWePlace(stalls, mid, k)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}