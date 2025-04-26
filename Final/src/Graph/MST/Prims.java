package Graph.MST;

import java.util.*;

class Pair {
    int node;
    int distance;
    Pair(int n, int d) {
        this.node = n;
        this.distance = d;
    }
}
public class Prims {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V]; // Visited array
        pq.add(new Pair(0, 0)); // Start from node 0 with weight 0
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            if (vis[node] == 1) continue; // If already in MST, skip

            vis[node] = 1; // Mark node as visited
            sum += wt; // Add weight to MST sum

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i)[0]; // Neighbor node
                int edW = adj.get(node).get(i)[1]; // Edge weight

                if (vis[adjNode] == 0) {
                    pq.add(new Pair(adjNode, edW));
                }
            }
        }
        return sum;
    }
}
