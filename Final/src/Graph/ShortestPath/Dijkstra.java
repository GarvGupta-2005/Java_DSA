package Graph.ShortestPath;

import java.util.*;


class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


public class Dijkstra {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.


    //This Dijkstra's Algorithm Relaxes on eah node once and uses a PQ to store the Nodes based on the minimum weight
    //This doesen't work on negative weights cycle as it can cause Infinite Loop 
    //The Time Complexity is Elog(V)
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        PriorityQueue<iPair> pq = new PriorityQueue<>((x,y)->x.second-y.second);
        int [] dist = new int[adj.size()];
        
        Arrays.fill(dist,(int)1e9);
        
        dist[src] = 0;
        pq.add(new iPair(src,0));
        while(!pq.isEmpty()){
            int dis = pq.peek().second;
            int node = pq.peek().first;
            pq.remove();
            for(int i = 0;i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).second;
                int edgeNode = adj.get(node).get(i).first;
                
                
                if(dis + edgeWeight < dist[edgeNode]){
                    dist[edgeNode] = dis + edgeWeight;
                    pq.add(new iPair(edgeNode,dist[edgeNode]));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer x : dist){
            ans.add(x);
        }
        return ans;
    }


}
