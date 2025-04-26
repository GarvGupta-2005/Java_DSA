
import java.util.Arrays;

public class Number_of_LIS {
    //The intution to solve this question is that we have to maintain a count array at each index
    //that will tell us how many LIS can be formed up till now and dp[i] will store the the length
    //at the end we will have to just return the all the counts to get the answer
    //if dp[prev]+1 > dp[i] then we can add this in our LIS
    // else if they are equla that means this element can also form a LIS of its own

    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int maxi = 1;
        for (int i = 0; i <= n - 1; i++) {
            for (int prev = 0; prev <= i - 1; prev++) {

                if (arr[prev] < arr[i] && dp[prev] + 1 > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    cnt[i] = cnt[prev];
                } else if (arr[prev] < arr[i] && dp[prev] + 1 == dp[i]) {
                    cnt[i] += cnt[prev];
                }

            }
            maxi = Math.max(maxi, dp[i]);
        }
        int nos = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (dp[i] == maxi) {
                nos += cnt[i];
            }
        }
        return nos;

    }
}
