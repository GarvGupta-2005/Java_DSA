package Graph.TopoSort_Problems;

import java.util.*;

public class CycleDetectionTopo {
    static boolean topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int V = adj.size();
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        //Adding all the nodes with 0 indegree as they 
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // int topo[] = new int[V];
        int count = 0;
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            count++;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return count==V;
        //If count == V then all the vertices were added indicating no cycle
        
    }
}
