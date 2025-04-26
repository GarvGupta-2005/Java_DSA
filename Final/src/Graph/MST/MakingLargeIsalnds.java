package Graph.MST;

import java.util.HashSet;

public class MakingLargeIsalnds {
    //The First deduction is that we have to see the length of each componenets and find 
    //The max we have or the max we can make by turning one zero into 1
    //The Formula for converting (row,col) into nodes where m is the total rows = 
    //cur_Row*m + curCol = nodeNo

    //We will make the components first by uniomnBySize and then we will try convert 0->1
    //And then we will see by connecting whcih 1 we will get largest component

    //An Edge case is that we have to remeber to not to count the same cell twice

    private boolean isValid(int nr,int nc,int n,int m){
        return (nr >= 0 && nc >= 0 && nr < n && nc< m );
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);

        //Step1 to build the components 
        for(int row = 0;row<n;row++){
            for(int col = 0;col<m;col++){
                if(grid[row][col]==0)continue;
                int [] dr = {-1,0,1,0};
                int [] dc = {0,-1,0,1};
                for(int i = 0;i<4;i++){
                    int nr = row + dr[i];
                    int nc = col + dc[i];
                    if(isValid(nr,nc,n,m) && grid[nr][nc]==1){
                        int node = row*n + col;
                        int adjNode = nr*n + nc;
                        ds.unionBySize(node,adjNode);
                    }
                }
            }
        }

    //Step2 to see whether by turning the zeroes we can get the componenets of max size
    // step 2
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n,m)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.findParent(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findParent(cellNo)));
        }
        return mx;
    }
}
