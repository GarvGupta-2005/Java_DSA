package Graph.ShortestPath;
import java.util.*;

class Pair {
    int first;  // Adjacent node
    int second; // Weight of the edge

    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

class Tuple {
    int first, second, third;  // First = time, Second = src node, Third = unused in this case

    Tuple(int f, int s, int t) {
        this.first = f;
        this.second = s;
        this.third = t;
    }
}


public class Network_Delay {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] time = new int[n + 1]; // To store the minimum time to reach each node
        Arrays.fill(time, (int) 1e9);
        time[src] = 0; // Source node has zero delay

        // Step 1: Create the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] t : times) {
            adj.get(t[0]).add(new Pair(t[1], t[2])); // (Destination, Weight)
        }

        // Step 2: Implement Dijkstra’s Algorithm using Priority Queue
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        pq.add(new Tuple(0, src, 0));

        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int currTime = it.first;
            int node = it.second;

            for (Pair p : adj.get(node)) {
                int adjNode = p.first;
                int edgeWeight = p.second;

                if (currTime + edgeWeight < time[adjNode]) {
                    time[adjNode] = currTime + edgeWeight;
                    pq.add(new Tuple(time[adjNode], adjNode, 0));
                }
            }
        }

        // Step 3: Get the maximum time required to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (time[i] == (int) 1e9) return -1; // Unreachable node
            maxTime = Math.max(maxTime, time[i]);
        }

        return maxTime;
    }    
}
