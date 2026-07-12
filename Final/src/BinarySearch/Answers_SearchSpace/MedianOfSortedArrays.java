
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {

            // Number of elements taken from nums1 into the left partition
            int cut1 = (low + high) / 2;

            // Remaining elements required in the left partition
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            // Largest element on the left side of nums1
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];

            // Smallest element on the right side of nums1
            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];

            // Largest element on the left side of nums2
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // Smallest element on the right side of nums2
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Total length is even
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }

                // Total length is odd
                return Math.max(left1, left2);
            }

            // Took too many elements from nums1
            if (left1 > right2) {
                high = cut1 - 1;
            }

            // Took too few elements from nums1
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
