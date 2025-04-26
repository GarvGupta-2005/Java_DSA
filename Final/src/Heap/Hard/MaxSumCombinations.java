package Heap.Hard;

import java.util.*;

public class MaxSumCombinations {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
            List<Integer> ans = new ArrayList<>(); // List to store the top K maximum sums
            
            // Step 1: Sort both arrays in ascending order
            Arrays.sort(A);
            Arrays.sort(B);
            
            // Step 2: Create a max heap (PriorityQueue with custom comparator for descending order)
            PriorityQueue<AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>>> pq = 
                new PriorityQueue<>((a, b) -> b.getKey() - a.getKey()); // Sorting by sum in descending order
    
            // Step 3: Use a set to track visited index pairs and avoid duplicates
            Set<AbstractMap.SimpleEntry<Integer, Integer>> s = new HashSet<>();
            
            // Step 4: Insert the maximum possible sum (last elements of sorted A and B) into the heap
            pq.add(new AbstractMap.SimpleEntry<>(A[N - 1] + B[N - 1], new AbstractMap.SimpleEntry<>(N - 1, N - 1)));
            s.add(new AbstractMap.SimpleEntry<>(N - 1, N - 1));
            
            // Step 5: Extract the top K maximum sums
            while (K > 0 && !pq.isEmpty()) {
                // Get the current largest sum from the heap
                AbstractMap.SimpleEntry<Integer, AbstractMap.SimpleEntry<Integer, Integer>> p = pq.poll();
                int sum = p.getKey();
                int i = p.getValue().getKey();  // Index from array A
                int j = p.getValue().getValue(); // Index from array B
                ans.add(sum); // Store the sum
                
                // Step 6: Push the next possible pairs into the heap if not already visited
                
                // Case 1: Add (i-1, j) pair if within bounds and not visited
                if (i - 1 >= 0) {
                    AbstractMap.SimpleEntry<Integer, Integer> newPair = new AbstractMap.SimpleEntry<>(i - 1, j);
                    if (!s.contains(newPair)) {
                        pq.add(new AbstractMap.SimpleEntry<>(A[i - 1] + B[j], newPair));
                        s.add(newPair);
                    }
                }
                
                // Case 2: Add (i, j-1) pair if within bounds and not visited
                if (j - 1 >= 0) {
                    AbstractMap.SimpleEntry<Integer, Integer> newPair = new AbstractMap.SimpleEntry<>(i, j - 1);
                    if (!s.contains(newPair)) {
                        pq.add(new AbstractMap.SimpleEntry<>(A[i] + B[j - 1], newPair));
                        s.add(newPair);
                    }
                }
                
                // Decrement K as we have added one sum to the answer list
                K--;
            }
            
            return ans; // Return the top K maximum sums
        }
    
    
}
