package Recursion.Hard;

import java.util.ArrayList;

public class ratInMaze {
    public  void helper(int row,int col,int m,int n,String ans,ArrayList<String> res,ArrayList<ArrayList<Integer>> mat){
        if(row==m-1 && col==n-1){
            res.add(ans);
            return;
        }
        if( row<0 || col<0 ||row>=m || col>=n || mat.get(row).get(col)==0){ //hANDLING ALL THE BASE CASES THAT IS IF WE REACH OUT OF BOUNDS OR WE ENCOUNTER A BLOCKED CELL WE BACKTRACK AND RETURN TO THE PREIVIOUS FUNCTION CALL
            return;
        }
        mat.get(row).set(col,0 ); //Marking the cell as visited
        helper(row+1,col,m,n,ans+'D',res,mat);//Moving down in the matrix
        helper(row-1, col, m, n, ans+'U', res, mat);//Moving up in the matrix
        helper(row, col+1, m, n, ans+'R', res, mat);//Moving right in the matrix
        helper(row, col-1, m, n, ans+'L', res, mat);//Moving left in the matrix
        mat.get(row).set(col,1);//Backtracking and marking the cell as unvisited
    }
    public  ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int m = mat.size();
        int n = mat.get(0).size();
        helper(0,0,m,n,"",res,mat);
        return res;
    }
}
