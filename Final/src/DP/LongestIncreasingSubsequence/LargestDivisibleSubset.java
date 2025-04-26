import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
    Arrays.fill(dp, 1);

    int[] hash = new int[n];
    Arrays.fill(hash, 1);

    for (int i = 0; i < n; i++) {
        hash[i] = i;

        for (int prev_index = 0; prev_index < i; prev_index++) {
            if (arr[i] % arr[prev_index] == 0 && 1 + dp[prev_index] > dp[i]) {
                dp[i] = 1 + dp[prev_index];
                hash[i] = prev_index;
            }
        }
    }

    int ans = -1;
    int lastIndex = -1;

    for (int i = 0; i < n; i++) {
        if (dp[i] > ans) {
            ans = dp[i];
            lastIndex = i;
        }
    }

    List<Integer> temp = new ArrayList<>();
    temp.add(arr[lastIndex]);

    while (hash[lastIndex] != lastIndex) {
        lastIndex = hash[lastIndex];
        temp.add(arr[lastIndex]);
    }

    // System.out.print("The largest divisible subset is: ");
    // for (int i = temp.size() - 1; i >= 0; i--) {
    //     System.out.print(temp.get(i) + " ");
    // }
    // System.out.println();

    return temp;
    }
}
