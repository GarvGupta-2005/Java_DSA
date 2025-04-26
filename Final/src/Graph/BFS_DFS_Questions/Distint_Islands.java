package Graph.BFS_DFS_Questions;
import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}


public class Distint_Islands {
    //The KeyPoint is to remeber the shape of each island and that will be done by 
    //remeberng the coordinates of each isalnds in a specific order of the traversal
    //That is if we follow DFS then we will maintain the order as up,right,down,left
    //And we wil use A HashSet in order to remember the distinct islands 
    //and this we will do by subtracting each coordinate with their base coordinate 
    //this will give us the  count of distinctive isalnds 
    
    private void dfs(int row,int col,int [][] grid,int [][] vis,ArrayList<String> vec,int row0,int col0){
        vis[row][col] = 1;
        vec.add(toString(row-row0,col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int delRow [] = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nr = row+delRow[i];
            int nc = col+delCol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
                dfs(nr,nc,grid,vis,vec,row0,col0);
            }
        }
        
    }
    private String toString(int r,int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        HashSet<ArrayList<String>> order = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i,j,grid,vis,vec,i,j);
                    order.add(vec);
                }
            }
        }
        return order.size();
    }
}
