package Graph.ShortestPath;

import java.util.*;



class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

public class ShortestPathInBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        
        // Edge Case: if the source is only the destination.
        if(source[0] == destination[0] && 
           source[1] == destination[1]) return 0; 

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<tuple> q = new LinkedList<>();  
        int n = grid.length; 
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0. 
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[source[0]][source[1]] = 0; 
        q.add(new tuple(0, source[0], source[1])); 

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have 
        // in a direction.
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
 
        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!q.isEmpty()) {
            tuple it = q.peek(); 
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 
            
            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                
                // Checking the validity of the cell and updating if dist is shorter.
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis; 

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && 
                       newc == destination[1]) return dis + 1; 
                    q.add(new tuple(1+dis, newr, newc)); 
                }
            }
        }
        // If no path is found from source to destination.
        return -1; 
    
    }
}


class Tuple {
    int first, second, third;

    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If the starting cell is blocked, return -1
        if (grid[0][0] != 0) {
            return -1;
        }

        // If grid is just one cell and it's open
        if (n == 1) return 1;

        // BFS queue, stores Tuple(distance, row, column)
        Queue<Tuple> pq = new LinkedList<>();
        int[][] distance = new int[n][n];
        
        // Initialize distance matrix with a large value
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[0][0] = 1;
        pq.add(new Tuple(1, 0, 0));

        // Iterate while queue is not empty
        while (!pq.isEmpty()) {
            Tuple cell = pq.poll();
            int wt = cell.first;
            int row = cell.second;
            int col = cell.third;

            // Check all 8 possible movements (including diagonals)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue; // Skip the current cell
                    
                    int nr = row + i;
                    int nc = col + j;

                    // Check if the new cell is within bounds and is traversable
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && distance[nr][nc] > wt + 1) {
                        distance[nr][nc] = wt + 1;

                        // If we reach the destination, return the shortest path length
                        if (nr == n - 1 && nc == n - 1) return wt + 1;

                        pq.add(new Tuple(wt + 1, nr, nc));
                    }
                }
            }
        }
        return -1; // If there is no valid path
    }
}
