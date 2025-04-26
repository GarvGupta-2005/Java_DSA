package Array.Hard;

import java.util.ArrayList;

public class pairinversiontwicegreater {
    //This problem is similar to pair inversion just the fact that the pair should be formed such that a[i]>2*a[j]
    public void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary array
        int left = low; // Starting index of the left half
        int right = mid + 1; // Starting index of the right half

        // Merge both halves into temp in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining elements from the left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from the right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy sorted elements back to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Count reverse pairs in the current range
    public int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    // Merge sort and count reverse pairs
    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt; // Base case: single element or empty array

        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // Sort and count in the left half
        cnt += mergeSort(arr, mid + 1, high); // Sort and count in the right half
        cnt += countPairs(arr, low, mid, high); // Count reverse pairs
        merge(arr, low, mid, high); // Merge the sorted halves
        return cnt;
    }

    // Wrapper function
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
