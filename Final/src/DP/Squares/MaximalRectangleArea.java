package DP.Squares;

import java.util.Stack;

public class MaximalRectangleArea {
    // Helper function to calculate largest rectangle in histogram
    public int largestRectangleArea(int[] histo) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = histo.length;

        for (int i = 0; i <= n; i++) {
            // We use this condition to find the next smaller element
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.pop()];
                int width;
                if (st.empty()) width = i;
                else width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            // Build histogram for current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            // Calculate max area for this histogram
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
