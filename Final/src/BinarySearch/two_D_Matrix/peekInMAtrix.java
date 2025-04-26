package BinarySearch.two_D_Matrix;
// import java.util.*;
public class peekInMAtrix {
    public static int maxIndex(int [][] matrix , int n, int m, int col ){
        int index = -1;
        int ele = 0;
        for(int i = 0;i<n;i++){
            if(matrix[i][col]>ele){
                ele = matrix[i][col];
                index = i;
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int [][]matrix){
        // Write your code here.
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m-1;
        int [] ans = new int[2];
        ans[0] = -1;
        ans[1]  = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int maxRowIndex = maxIndex(matrix,n,m,mid);
            int left = mid-1>=0 ? matrix[maxRowIndex][mid-1] : -1;
            int right = mid + 1<m ? matrix[maxRowIndex][mid + 1] : -1;
            if(matrix[maxRowIndex][mid]> left && matrix[maxRowIndex][mid]>right){
                ans[0] = maxRowIndex;
                ans[1] = mid;
                return ans;
            }else if(matrix[maxRowIndex][mid]<left){
                high = mid  - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    
}
}
