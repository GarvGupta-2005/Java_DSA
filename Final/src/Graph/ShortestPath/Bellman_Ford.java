package Graph.ShortestPath;

import java.util.*;

public class Bellman_Ford {
//BellmanFord is designed specifically to detect a negative cycle
//If any path sum is less than zero then it has a negative cycle

//Relax all edges in order (n-1) times sequentially 

//Q1 Why N-1 computations?
//Ans 1 Since the src distance is zero so we just have n-1 nodes left which are then assigned distance in n-1 iterations

//Q2 How to detect negative cycle?
//Ans2 Iterate the loop once more that is Nth time and if the value still goes to decrease then it has a negative cycle as only in 
//negative cycle the values keep on decreasing


static int[] bellmanFord(int V, int[][] edges, int src) {
    int[] dist = new int[V];
    Arrays.fill(dist, (int) 1e8);
    dist[src] = 0;

    // Relax edges (V-1) times
    for (int i = 1; i < V; i++) {
        for (int[] it : edges) {
            int u = it[0], v = it[1], w = it[2];
            if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    // Check for negative weight cycles
    for (int[] it : edges) {
        int u = it[0], v = it[1], w = it[2];
        if (dist[u] != (int) 1e8 && dist[u] + w < dist[v]) {
            return new int[] {-1}; // Return empty array if cycle exists
        }
    }

    return dist;
}
}
