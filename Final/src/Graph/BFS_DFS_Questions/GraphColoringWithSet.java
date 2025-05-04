import java.util.*;

public class GraphColoringWithSet {

    // Main function to check if graph can be colored with m colors
    public boolean isMColorable(int[][] graph, int m) {
        int V = graph.length;
        int[] color = new int[V]; // 0 means uncolored
        return dfsColor(0, color, graph, m);
    }

    // Recursive DFS with color checking
    private boolean dfsColor(int node, int[] color, int[][] graph, int m) {
        int V = graph.length;
        if (node == V) return true; // All nodes are colored successfully

        // Step 1: Build the set of colors used by neighbors
        Set<Integer> usedColors = new HashSet<>();
        for (int neighbor : graph[node]) {
            if (color[neighbor] != 0) {
                usedColors.add(color[neighbor]);
            }
        }

        // Step 2: Try coloring the node with available colors
        for (int c = 1; c <= m; c++) {
            if (!usedColors.contains(c)) {
                color[node] = c;

                // Step 3: Recurse for next node
                if (dfsColor(node + 1, color, graph, m)) {
                    return true;
                }

                // Backtrack if this coloring doesn't lead to a solution
                color[node] = 0;
            }
        }

        // Step 4: If no color works, return false
        return false;
    }

    // Optional: Print coloring result
    public void printColoring(int[][] graph, int m) {
        int[] color = new int[graph.length];
        if (dfsColor(0, color, graph, m)) {
            System.out.println("Coloring possible with " + m + " colors.");
            for (int i = 0; i < color.length; i++) {
                System.out.println("Node " + i + " → Color " + color[i]);
            }
        } else {
            System.out.println("Coloring NOT possible with " + m + " colors.");
        }
    }

    // For testing
    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {0, 2},
            {0, 1, 3},
            {2}
        };

        int m = 3;
        GraphColoringWithSet gc = new GraphColoringWithSet();
        gc.printColoring(graph, m);
    }
}
