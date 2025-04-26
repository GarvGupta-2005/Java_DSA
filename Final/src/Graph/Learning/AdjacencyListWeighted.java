package Graph.Learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int vertex, weight;
    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

// Function to add an edge between two vertices
public class AdjacencyListWeighted {
    static void addEdge(List<List<Edge>> adj, int u, int v, int w) {
        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w)); // For undirected graph
    }

    static void displayAdjList(List<List<Edge>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); 
            for (Edge j : adj.get(i)) {
                System.out.print("{" + j.vertex + ", " + j.weight + "} "); 
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(adj, u, v, w);
        }

        scanner.close();

        System.out.println("Adjacency List Representation:");
        displayAdjList(adj);
    }
}

