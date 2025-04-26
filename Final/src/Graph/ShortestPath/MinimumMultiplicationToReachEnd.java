package Graph.ShortestPath;

import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int f,int s){
        this.first = f;
        this.second = s;
    }
}
public class MinimumMultiplicationToReachEnd {
    //This is a very intutive problem as there is a trick to apply here to form a graph question
    //The Hint is that we have to mod with 10^5 that is the END will lie somewhere between
    // 0 and 9999 as beyond 9999 anything will produce output wrong with mod
    
    
    int minimumMultiplications(int[] arr, int start, int end) {
        
        // Edge Case: If the start is already equal to the end, no multiplication is needed.
        if (start == end) return 0; 

        // Create a queue for storing the numbers as a result of multiplication
        // of the numbers in the array and the start number.
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0)); 

        // Create a dist array to store the no. of multiplications to reach
        // a particular number from the start number.
        int[] dist = new int[100000]; 
        Arrays.fill(dist, (int) 1e9); // Initialize all distances as a large value
        dist[start] = 0; // Since we don't need to measure from the starting point

        int mod = 100000; // Since we are dealing with numbers modulo 100000
        int n = arr.length; 

        // O(100000 * N) 

        // Multiply the start number with each of the numbers in the arr
        // until we get the end number.
        while (!q.isEmpty()) {
            Pair current = q.poll(); // Use poll to remove and get the front element in one step
            int node = current.first; 
            int steps = current.second;

            // Iterate over all numbers in arr to multiply with the current node
            for (int i = 0; i < n; i++) {
                // Prevent overflow by casting to long before multiplication
                long product = (long) arr[i] * node;  
                int num = (int) (product % mod); 

                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1; 

                    // Whenever we reach the end number,
                    // return the calculated steps.
                    if (num == end) return steps + 1; 
                    
                    // Push the new number into the queue with updated step count
                    q.add(new Pair(num, steps + 1)); 
                }
            }
        }
        // If the end number is unattainable.
        return -1; 
        
    }
}
