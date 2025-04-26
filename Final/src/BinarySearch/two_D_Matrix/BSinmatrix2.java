package BinarySearch.two_D_Matrix;

public class BSinmatrix2 {
        //In this particular problem we know that rows and columns are sorted but one thing is that one row may not end at next row's starting point so we take our initial point as last column in first row
        //Then we will se whetehr our target lies in it or not and then we will change our columns and rows accordingly
        //Otherwise the brute force is always there};
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = 0;
            int col = matrix[0].length-1;
            while(row<matrix.length && col>=0){
                if(matrix[row][col]==target){ return true;}
                else if(matrix[row][col]>target){
                    col--;
                }else{
                    row++;
                }
            }
            return false;
        }
    
}
