package Graph.ShortestPath;
import java.util.*;

class Tuple{
    int dis;
    int row;
    int col;
    Tuple(int dis,int row,int col){
        this.dis = dis; this.row = row; this.col = col;
    }
}


public class PathWithMinimumEffort {
    //Again using Dijkstra we will go in 4 directions each and will see which effort
    // is minimum and in which direction as PQ will always keep a min dist 
    //At the end we will return the minimal 
    public  int MinimumEffort(int rows, int columns, int[][] grid) {
        // code here
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.dis - y.dis);
        int n = grid.length;
        int m = grid[0].length;
        int [][] visited = new int[n][m];//To keep the track of visited cells
        for(int i = 0;i<n;i++){
            Arrays.fill(visited[i],(int)1e9);
        }
        
        visited[0][0] = 0;//The Src distance = 0;
        pq.add(new Tuple(0,0,0));
        int [] dr = {-1,0,1,0};
        int dc [] = {0,1,0,-1};
        
        while(!pq.isEmpty()){
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.dis;
            int row = it.row;
            int col = it.col;
            
            if(row == n-1 && col == m-1)return diff;
            
            for(int i = 0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newEffort = Math.max(Math.abs(grid[row][col] - grid[nr][nc]),diff);
                    if(newEffort < visited[nr][nc]){
                        visited[nr][nc] = newEffort;
                        pq.add(new Tuple(newEffort,nr,nc));
                    }
                    
                }
            }
                
        }
        return 0;
        
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        return MinimumEffort(n,m,heights);
    }
}
