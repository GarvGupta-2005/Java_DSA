package Graph.BFS_DFS_Questions;

import java.util.*;

class Pair{
    int row;
    int col;
    int time;
    Pair(int r,int c,int t){
        this.row = r;this.col=c;this.time=t;
    }
}

public class RottenOranges {
    public int orangesRotting(int[][] mat) {
         // Code here
        int n = mat.length;
        int m = mat[0].length;
        
        //Queue to store all the nodes level wise
        Queue<Pair> q = new LinkedList<>();
        //A visited matrix to keep count of all the nodes visited
        int [][] visited  = new int[n][m];
        int cntFresh = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else if(mat[i][j] ==0){
                    visited[i][j] = 0;
                }
                if(mat[i][j] == 1)cntFresh++;
                
            }
        }
        
        
        if(cntFresh == 0) return 0;
        
        
        int cnt = 0;
        int time = 0;
        int [] delRow  = {-1,0,1,0};//Cooresponds to up , right , down , left of a row respectively
        int [] delCol = {0,1,0,-1};//These are the movements of row and col which will gradually happen 
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time,t);
            q.remove();
            for(int i = 0;i<4;i++){
                
                int nrow = r+delRow[i];
                int ncol = c+delCol[i];
    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && mat[nrow][ncol]==1){
        q.add(new Pair(nrow,ncol,t+1));
        visited[nrow][ncol] = 2;
        cnt++;
    }
                
            }
        }
        return cnt!=cntFresh ? -1:time;
    }
}
