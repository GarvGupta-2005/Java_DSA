package BinarySearch.Answers_SearchSpace;

import java.util.*;
public class kokoBanana {

    public static int calculateTotalHours(int[] piles, int mid) {
        int totalH = 0;
        int n = piles.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(piles[i]) / (double)(mid));
        }
        return totalH;
    }
    public static int minimumRateToEatBananas(int []piles, int h) {
        // Write Your Code Here

        Arrays.sort(piles);
        int n = piles.length;
        int low = 1;//Since the minimum hour koko can take is 1
        int high = piles[n-1];//Since max can be the highest number of bananas in a pile
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int cur_hours  = calculateTotalHours(piles,mid);
            if(cur_hours<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

