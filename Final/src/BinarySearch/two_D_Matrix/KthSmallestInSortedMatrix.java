class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int beg = matrix[0][0];
        int end = matrix[matrix.length - 1][matrix.length - 1];

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return beg;
    }

    private int lessEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] > target) {
                row--;
            } else {
                count += row + 1;
                col++;
            }
        }

        return count;
    }
}
