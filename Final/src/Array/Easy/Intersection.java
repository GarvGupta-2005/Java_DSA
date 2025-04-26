package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Sort both arrays to apply the 2-pointer approach
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                // Only add unique elements
                if (common.isEmpty() || common.get(common.size() - 1) != nums1[i]) {
                    common.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        // Convert ArrayList to int[]
        int[] res = new int[common.size()];
        for (int k = 0; k < common.size(); k++) {
            res[k] = common.get(k);
        }
        return res;
    }
}

