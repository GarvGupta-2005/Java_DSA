package Array.Hard;

import java.util.ArrayList;
import java.util.List;
//The hard part in this specific question is to formulate ncr which is tough part and should be verified by dry run also 
public class Pascal {
     public static long nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        start.add(1);
        res.add(start);
        int row = 1;
        int n_star = 2;
        while(row<numRows){
            List<Integer> temp = new ArrayList<>();
            int col = 0;
            while(col<n_star){
                int val = (int)nCr(row,col);
                temp.add(val);
                col++;
            }
            res.add(temp);
            n_star++;
            row++;
        }
        return res;
    }
}


// public class Solution {
//     public static long nCr(int n, int r) {
//         long res = 1;
//         // Calculating nCr:
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return res;
//     }
//     public static int[][] pascalTriangle(int N) {
//         // Write your code here.
//         // Create a 2D array to store Pascal's Triangle
//         int[][] pascal = new int[N][];

//         // Iterate through each row
//         for (int row = 0; row <N; row++) {
//             // Create an array for the current row
//             pascal[row] = new int[row + 1];

//             // Fill the row using nCr
//             for (int col = 0; col <= row; col++) {
//                 pascal[row][col] = (int) nCr(row, col);
//             }
//         }

//         return pascal;
//     }
//     }
