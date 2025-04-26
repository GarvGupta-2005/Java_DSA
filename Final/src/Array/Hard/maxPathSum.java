package Array.Hard;

import java.util.*;

public class maxPathSum {
    public static int maxSumPath(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0, result = 0;
        
        while (i < arr1.length && j < arr2.length) {
            // Add elements to sum1 if they are smaller
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            }
            // Add elements to sum2 if they are smaller
            else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j++];
            }
            // Common element found → Switch path at this point
            else {
                result += Math.max(sum1, sum2) + arr1[i]; // Take max sum so far + common element
                sum1 = 0; // Reset sums after switching
                sum2 = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < arr1.length) {
            sum1 += arr1[i++];
        }
        
        // Add remaining elements of arr2
        while (j < arr2.length) {
            sum2 += arr2[j++];
        }
        
        // Take the max of last segment
        result += Math.max(sum1, sum2);
        
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
		while(t-- > 0){
			int n = s.nextInt();
        int m = s.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = s.nextInt();
        }
        for (int j = 0; j < m; j++) {
            arr2[j] = s.nextInt();
        }

        System.out.println(maxSumPath(arr1, arr2));
		}
    }
}
