package Graph.BFS_DFS_Questions;

public class NumberOfEnclaves {
    //The idea is same we go along the boundaries and see which paths we can travel and
    //then we mark those "1" as visited as we have travelled along them 
    //Then we traverse the matrix for those ones which were not traversed and count them
    public static void dfs(int row,int col,int [][] grid,int [][]vis,int [] delRow,int []delCol){
        vis[row][col] = 1;//marking the cell from where we can move 
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i<4;i++){
            int nr = row+delRow[i];
            int nc = col+delCol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && vis[nr][nc]==0){
                dfs(nr,nc,grid,vis,delRow,delCol);
            }
        }

    }
    
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        int vis [][] = new int[n][m];
        for(int j = 0;j<m;j++){
            //First row;
            if(grid[0][j] == 1 && vis[0][j] == 0){
                dfs(0,j,grid,vis,delRow,delCol);
            }
            //Last Row
            if(grid[n-1][j] ==1 && vis[n-1][j] ==0){
                dfs(n-1,j,grid,vis,delRow,delCol);
            }
        }
        for(int i = 0;i<n;i++){
            //First Column
            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i,0,grid,vis,delRow,delCol);
            }
            //Last Column
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(i,m-1,grid,vis,delRow,delCol);
            }
        }
        int count = 0;
        for(int i=0 ;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    count++;
                }
            }
        }
        return count;
    }
}
