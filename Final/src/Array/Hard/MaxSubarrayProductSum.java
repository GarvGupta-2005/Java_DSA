package Array.Hard;

public class MaxSubarrayProductSum {
    public static int subarrayWithMaxProduct(int []arr){
        //This approach works on the basis of preifx and suffix
        //We divide array in prefix and suffix part nd then compare 
        //If we have even no of negative numbers then thier product will be positive
        //Else if we encounter any odd number of begative then the answer will lie either before them or after them <-- this is an crucial observation for this
        int n = arr.length; //size of array.
        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    
    }
}
