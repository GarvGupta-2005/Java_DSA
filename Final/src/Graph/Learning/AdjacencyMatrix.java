package Graph.Learning;

import java.util.*;

public class AdjacencyMatrix {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Number of nodes");
        int n = s.nextInt();
        System.out.println("Enter the Number of edges");
        int m = s.nextInt();
        
        // Initialize adjacency matrix with size n x n (not n+1 x m+1)
        int adjacency [][] = new int[n+1][n+1];
        
        System.out.println("Enter the edges (u v) where u and v are nodes:");
        for(int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            
            adjacency[u][v] = 1; // Mark edge from u to v
            adjacency[v][u] = 1; // Since the graph is undirected
        }
        
        s.close();
        
        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adjacency[i][j] + " ");
            }
            System.out.println();
        }
    }    
}