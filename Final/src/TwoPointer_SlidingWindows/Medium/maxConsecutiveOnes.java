package TwoPointer_SlidingWindows.Medium;

public class maxConsecutiveOnes {
    //We can reframe this problem as Longest Substring wit at most k zeroes
    public static int longestOnes(int[] a, int k) {
        int n = a.length;
        int l = 0,r=0;
        int maxLen = 0;
        //Only increment r to expand //increment l only in case of shrinkage
        int zeroes = 0;
        while(r<n){
            if(a[r]==0){  //Counting the number of zeroes in current subarray
                zeroes++;
            }
            if(zeroes>k){ //Placing the l pointer such that the number of zeroes is in limit
                if(a[l] == 0){
                    zeroes--; //if l is on zero then decrement the number of zeroes and incrementing l
                }
                l++;
            }
            if(zeroes<=k){
                if(l<=r) {  //Calulating the length of current subarray if it has correct number of zeroe
                    int cur = r-l+1;
                    maxLen = Math.max(cur,maxLen);
                }
            }
            r++;
        }
        return maxLen;
    }
}
