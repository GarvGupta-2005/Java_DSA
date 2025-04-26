package Graph.BFS_DFS_Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {
    class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    private void dfs(int row, int col, int[][] vis, char[][] grid, List<Pair> shape, int baseRow, int baseCol) {
        vis[row][col] = 1;
        shape.add(new Pair(row - baseRow, col - baseCol)); // Store relative position
        
        int n = grid.length, m = grid[0].length;
        int[] dRow = {-1, 1, 0, 0};  // Up, Down, Left, Right
        int[] dCol = {0, 0, -1, 1};  

        for (int i = 0; i < 4; i++) {
            int nrow = row + dRow[i];
            int ncol = col + dCol[i];
            
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, vis, grid, shape, baseRow, baseCol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<List<Pair>> uniqueIslands = new HashSet<>(); // Store unique island shapes

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    List<Pair> shape = new ArrayList<>();
                    dfs(row, col, vis, grid, shape, row, col);
                    uniqueIslands.add(shape); // Store the unique shape
                }
            }
        }
        return uniqueIslands.size();
    }
}

}
