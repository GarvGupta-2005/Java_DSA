package BinarySearch.two_D_Matrix;

import java.util.ArrayList;

public class BSinmatrix {
    //The brute force approach is to traverse the whole matrix in n^2 tc
    //A better approach is that since the whole matrix is sorted just go to each row and see whetther the target lies between the first and last element 
    //if it lies then just apply BS on that row
    // public static boolean BS(int [] a,int target){
    //     int low = 0;
    //     int high = a.length - 1;
    //     while (low<=high) {
    //         int mid = low + (high-low)/2;
    //         if(a[mid]==target){ return true;}
    //         else if(a[mid]<target){ low = mid + 1;}
    //         else{ high = mid - 1;}
    //     }
    //     return false;
    // }
    // public boolean searchInMAtrix(int [][] matrix,int target){
    //     for(int i = 0;i<matrix.length;i++){
    //         if(target>matrix[i][0] && target<matrix[i][matrix[0].length-1]){
    //             return BS(matrix[i],target);
    //         }
    //     }
    //     return false;
    // }   
    //here the answer is in O(n) + O(logn)

    //The third apporach is to be which is the most optimal is to flatten the matrix into !-D array so the answer becomes O(n)
    //The row value and column value can be derived as 
    // row = val /mid ;
    // column = val % mid;
    // where val lies between 0 & n*m-1;

    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // Write your code here.
        int n = matrix.size();
        int m = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
