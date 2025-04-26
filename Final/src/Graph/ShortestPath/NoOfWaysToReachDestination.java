package Graph.ShortestPath;

import java.util.*;


class Pair {
    long first;
    int second;
    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class NoOfWaysToReachDestination {

    //One Observation is that this is an undirected graph so the weight exists for both nodes

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int []  road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Priority queue for Dijkstra's algorithm (min-heap)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));

        // Distance and ways arrays
        long[] dist = new long[n]; 
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Dijkstra’s Algorithm
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long dis = curr.first;
            int node = curr.second;

            if (dis > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.second;
                long edW = neighbor.first;

                // Found a shorter path
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } 
                // Found another shortest path with the same distance
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        
        return ways[n - 1] % mod;
    }
}
