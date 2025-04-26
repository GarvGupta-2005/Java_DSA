package Graph.ShortestPath;

import java.util.*;

public class ShortestPathUnit_Undirected {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        
        int n = adj.size();
        int [] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int it : adj.get(node)){
                if(dist[node] + 1<dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    } 
}
