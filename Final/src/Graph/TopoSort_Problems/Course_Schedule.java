package Graph.TopoSort_Problems;

import java.util.*;

public class Course_Schedule {
    //Simple observation from the examples is that we have to detect whether if there is a
    //cylce in the courses. If there is a cycle in the courses then its not possible 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the adjacency list for the directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Create the indegree array
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // bi → ai (take bi before ai)
            indegree[pre[0]]++; // Increase indegree of ai
        }

        // Step 3: Add all nodes with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Process the queue using BFS (Kahn's Algorithm)
        int count = 0; // To track how many nodes we can take
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 5: If count == numCourses, we can take all courses
        return count == numCourses;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the adjacency list for the directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Create the indegree array
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // bi → ai (take bi before ai)
            indegree[pre[0]]++; // Increase indegree of ai
        }

        // Step 3: Add all nodes with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int [] todo = new int[numCourses];
        // Step 4: Process the queue using BFS (Kahn's Algorithm)
        int count = 0; // To track how many nodes we can take
        while (!queue.isEmpty()) {
            int node = queue.poll();
            todo[count++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        if(count == numCourses)return todo;
        int [] arr = {};
        return arr;
        
    }

}
