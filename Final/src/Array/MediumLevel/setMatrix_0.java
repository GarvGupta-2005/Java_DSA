package Array.MediumLevel;

public class setMatrix_0 {
    //This is the brute approach 
//     The steps are the following:
// First, we will use two loops(nested loops) to traverse all the cells of the matrix.
// If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.
// We will perform step 2 for every cell containing 0.
// Finally, we will mark all the cells containing -1 with 0.
// Thus the given matrix will be modified according to the question.

//This is the better approach where we have to mark using 2 differnet arrrays for marking rows and colms where a zero exist and then setting the entire rows and columns ZERO
public void setZeroes(int[][] matrix) {
    int col0 = 1; // Flag to track if the first column should be zeroed
    int n = matrix.length; // Number of rows
    int m = matrix[0].length; // Number of columns

    // Step 1: Traverse the matrix and mark the first row & column
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] == 0) {
                // Mark i-th row:
                matrix[i][0] = 0;

                // Mark j-th column:
                if (j != 0)
                    matrix[0][j] = 0;
                else
                    col0 = 0; // Special case for the first column
            }
        }
    }

    // Step 2: Update the matrix from (1,1) to (n-1, m-1)
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Step 3: Zero out the first row if needed
    if (matrix[0][0] == 0) {
        for (int j = 0; j < m; j++) {
            matrix[0][j] = 0;
        }
    }

    // Step 4: Zero out the first column if needed
    if (col0 == 0) {
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 0;
        }
    }
}
}
