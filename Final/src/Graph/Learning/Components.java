package Graph.Learning;

import java.util.ArrayList;
import java.util.Collections;

public class Components {
    public static ArrayList<ArrayList<Integer>> connectedcomponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adjList, visited, component);
                Collections.sort(component);
                components.add(component);
            }
        }

        return components;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, component);
            }
        }
    }
}
