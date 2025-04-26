package Graph.Learning;

import java.util.*;

public class DFS {
    public static void dfs(int node,boolean [] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);
        
        for(Integer it:adj.get(node)){
            if(!visited[it]){
                dfs(it,visited,adj,ans);
            }
        }
    }
    
    
    
    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean [] visited  = new boolean [V+1];
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.fill(visited,false);
        dfs(0,visited,adj,ans);
        return ans;
    }

    //SC -> O(3N)
    //TC -> O(Nodes) + O(2*Edges)
}
