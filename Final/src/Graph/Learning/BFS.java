package Graph.Learning;

import java.util.*;

public class BFS {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[V];
        Arrays.fill(visited,false);
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            //Get all the adjacent nodes if they are not visited yet and then add them to queue
            //add them to the bfs when they are encounterd in queue
            
            for(Integer it:adj.get(node)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    //SC -> O(3n)
    //TC -> O(Node + Edges)
}