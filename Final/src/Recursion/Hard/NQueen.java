package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    class Solution {
  public boolean checker(char[][] board, int row_pos, int column_pos) {
    //We have to check only three directions becuase wE just need to check in THE row above and diagonals above as the insertion below is yet to take place so just check above
        // Check the column
        for (int i = 0; i < row_pos; i++) {
            if (board[i][column_pos] == 'Q') {
                return false;
            }
        }

        // Check the left diagonal
        for (int i = row_pos, j = column_pos; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the right diagonal
        for (int i = row_pos, j = column_pos; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
public void helper(int row,char[][] board,int n,List<List<String>> ans){
    if(row==n){
        List<String> rowadd = new ArrayList<>();
        for(int i =0;i<board.length;i++){
            String row11 = new String(board[i]);
            rowadd.add(row11);
        }
        ans.add(rowadd);
        return;
    }
    for(int i = 0 ; i<board[0].length;i++){
        if(checker(board,row,i)==true){
            board[row][i]='Q';  //This step is placing the queeen in the designated position
            helper(row+1,board,n,ans);
            board[row][i]='.';//This step is backtracking the queen from the designated position  if the queen is not placed in the right position
        }
    }
}

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char [][] board = new char[n][n];  //Making the chess board 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(0,board,n,ans);
        return ans;
    }
}
}
