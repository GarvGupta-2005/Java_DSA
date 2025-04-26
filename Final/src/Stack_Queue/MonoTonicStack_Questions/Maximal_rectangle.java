package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class Maximal_rectangle {
     //A way to solve this problem is to use The maximum Rectangle in histogram. We need to make a hitogram consisting all the ones in the matrix given Suppose for the given Example [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]] the Histogram after adding all the columns with 1 will look like 
    // [ 1 0 1 0 0]
    // [ 2 0 2 1 1]
    // [ 3 1 3 2 2]
    // [ 4 1 3 3 2]
    //We will be using prefixSum to covert the Matrix and then pass each individula array to maximumRectangleinHistogram


    public int largestRectangleArea(int[] histo) {
        Stack < Integer > st = new Stack < > ();
         int maxA = 0;
         int n = histo.length;
         for (int i = 0; i <= n; i++) {
             while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {  //This whole while loop is used to calculate The next smaller element
                 int height = histo[st.peek()]; //If its true then the current element of i is the nse of statck's top element and we will calculate max area for for stack's top
                 st.pop();
                 int width;
                 if (st.empty())   
                 width = i;
                 else
                     width = i - st.peek() - 1;
                 maxA = Math.max(maxA, width * height);
             }
             st.push(i);
         }
         return maxA;
     }

    public int maximalRectangle(char[][] matrix) {
         int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];

        // Convert String matrix to integer matrix and compute prefix sum
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        prefixSum[i][j] = 1; // First row retains the same value
                    } else {
                        prefixSum[i][j] = prefixSum[i - 1][j] + 1; // Add value from above
                    }
                } else {
                    prefixSum[i][j] = 0; // Cell remains 0 if original value is "0"
                }
            }
        }
        //Now we will pass Individual Arrays to compute answer from each row
        int maxA = 0;
        for(int i = 0;i<rows;i++){
            maxA = Math.max(maxA,largestRectangleArea(prefixSum[i]));        
        }
        return maxA;
    }
}
