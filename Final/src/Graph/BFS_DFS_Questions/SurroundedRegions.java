package Graph.BFS_DFS_Questions;

public class SurroundedRegions {
    //One observation of this question is that the 'O' on the boundaries will not be
    //converted as they are not bounded by 'X' om all sides and this holds true for all
    //'O' they are connected to so 
    //mark all the Boundary 'O' 
    //And then iterate again on the matrix and change the values 
    
    
    public static void dfs(int row,int col,char[][] mat,int [][]visited,int []delRow,int []delCol){
        //The Cell encountered lies on boundary so it cannot be convertd 
        visited[row][col] = 1;//MArking it in advance so that we do not turn this to 'X'
        int n = mat.length;
        int m = mat[0].length;
    
        //checking if the boundary cell is connected to others or not
        for(int i = 0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && mat[nrow][ncol]=='O'){
                dfs(nrow,ncol,mat,visited,delRow,delCol);
            }
        }
    }
        
        
        
        static char[][] fill(char board[][]) {
            // code here
            int n = board.length;
            int m = board[0].length;
            int [][] visited = new int[n][m];
            int delRow [] = {-1,0,1,0};
            int delCol [] = {0,1,0,-1};
            //Traversing the first and last row 
            for(int j = 0;j<m;j++){
    
                //first row
                if(board[0][j] == 'O' && visited[0][j] == 0){
                    dfs(0,j,board,visited,delRow,delCol);
                }
    
                //Last row
                if(board[n-1][j] == 'O' && visited[n-1][j] == 0){
                    dfs(n-1,j,board,visited,delRow,delCol);
                }
            }
    
            for(int i = 0;i<n;i++){
                
                //first column
                if(board[i][0] == 'O' && visited[i][0] == 0){
                    dfs(i,0,board,visited,delRow,delCol);
                }
    
                //Last column
                if(board[i][m-1] == 'O' && visited[i][m-1] == 0){
                    dfs(i,m-1,board,visited,delRow,delCol);
                }
            }
    
            for(int i= 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(board[i][j]=='O' && visited[i][j]!=1){
                        board[i][j] ='X';
                    }
                }
            }
            return board;
        }
}
