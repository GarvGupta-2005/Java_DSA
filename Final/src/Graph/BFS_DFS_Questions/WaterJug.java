package Graph.BFS_DFS_Questions;

import java.util.*;

public class WaterJug {
    // Function to find the minimum steps to obtain d liters in one jug
    static void minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) {
            System.out.println("Not possible");
            return;
        }

        // Queue for BFS: stores (jug1, jug2, steps, path)
        Queue<int[]> q = new LinkedList<>();
        Map<String, String> pathMap = new HashMap<>(); // Store path for each state
        boolean[][] visited = new boolean[m + 1][n + 1];

        // Start with both jugs empty
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        pathMap.put("0,0", "Start");

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int jug1 = curr[0], jug2 = curr[1], steps = curr[2];

            String stateKey = jug1 + "," + jug2; // Unique key for state
            String path = pathMap.get(stateKey); // Retrieve path for this state

            // If we reach the target amount
            if (jug1 == d || jug2 == d) {
                System.out.println("Minimum steps: " + steps);
                System.out.println("Path:");
                System.out.println(path);
                return;
            }

            // List of possible operations
            List<int[]> nextStates = Arrays.asList(
                new int[]{m, jug2, steps + 1}, // Fill jug1
                new int[]{jug1, n, steps + 1}, // Fill jug2
                new int[]{0, jug2, steps + 1}, // Empty jug1
                new int[]{jug1, 0, steps + 1}, // Empty jug2
                new int[]{jug1 - Math.min(jug1, n - jug2), jug2 + Math.min(jug1, n - jug2), steps + 1}, // Pour jug1 -> jug2
                new int[]{jug1 + Math.min(jug2, m - jug1), jug2 - Math.min(jug2, m - jug1), steps + 1}  // Pour jug2 -> jug1
            );

            List<String> actions = Arrays.asList(
                "Fill Jug1", "Fill Jug2", "Empty Jug1", "Empty Jug2", 
                "Pour Jug1 -> Jug2", "Pour Jug2 -> Jug1"
            );

            for (int i = 0; i < nextStates.size(); i++) {
                int[] next = nextStates.get(i);
                int newJug1 = next[0], newJug2 = next[1];

                if (!visited[newJug1][newJug2]) {
                    visited[newJug1][newJug2] = true;
                    q.add(next);
                    pathMap.put(newJug1 + "," + newJug2, path + " -> " + actions.get(i) + " (" + newJug1 + "," + newJug2 + ")");
                }
            }
        }

        System.out.println("No solution found.");
    }
  
    public static void main(String[] args) {
      
        // jug1 = 4 litre, jug2 = 3 litre 
        int m = 4, n = 3, d = 1;
        minSteps(m, n, d);
    }
}
