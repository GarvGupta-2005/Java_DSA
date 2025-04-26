package Graph.MST;

import java.util.*;

public class MaxRemoveStones {
     //The Intution behind this is to connect all the stones that are sharing row and column 
    //and connect them in a component like unionByRank and then the max stones we can remove
    //are the component size-1;
    //Which can be deduced to a formula => no. of stones - no. of components
    
    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0;i<n;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);//Dimensions of the plane
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();//To store only those nodes where stones are presnet in same row or column
        for(int i = 0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeColumn = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow,nodeColumn);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeColumn,1);
        }
        int cnt = 0;
       for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findParent(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }



    public int removeStones(int[][] stones) {
        return maxRemove(stones,stones.length);
    }
}
