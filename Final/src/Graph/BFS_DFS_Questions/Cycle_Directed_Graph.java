package Graph.BFS_DFS_Questions;

import java.util.ArrayList;

public class Cycle_Directed_Graph {
    //The only thing that differentiates it from the DFS cycel check on undirected is 
    //path remains the same in undirected but in directed graph path changes and that is
    // is the problem we have to tackle
    //This is a classic case of backtracking as when we encounter a node having multiple 
    //adjacents we first made its pathvisited[i] as 1 and when we return for its next node
    //we turn the pasthvisited[i] = 0 for correct backtrack
    
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[]) {
        vis[node] = 1; 
        pathVis[node] = 1; 
        
        // traverse for adjacent nodes 
        for(int it : adj.get(node)) {
            // when the node is not visited 
            if(vis[it] == 0) {
                if(dfsCheck(it, adj, vis, pathVis) == true) 
                    return true; 
            }
            // if the node has been previously visited
            // but it has to be visited on the same path 
            else if(pathVis[it] == 1) {
                return true; 
            }
        }
        
        pathVis[node] = 0; 
        return false; 
    }
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfsCheck(i, adj, vis, pathVis) == true) return true; 
            }
        }
        return false; 
    
    }
}
