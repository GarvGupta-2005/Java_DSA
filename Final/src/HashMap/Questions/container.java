package Questions;
import java.util.*;

public class container {
    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        
        nc.change(1, 10);
        nc.change(2, 10);
        nc.change(3, 20);
        nc.change(4, 10);

        System.out.println(nc.find(10)); // Output: 1 (smallest index with value 10)

        nc.change(1, 20); // Change index 1 from 10 to 20

        System.out.println(nc.find(10)); // Output: 2 (smallest index with value 10 after update)
    }    
}


class NumberContainers {
    // Stores index-to-value mapping
    Map<Integer, Integer> m;
    
    // Stores value-to-indices mapping (min-heap for efficient retrieval of the smallest index)
    Map<Integer, PriorityQueue<Integer>> d;

    public NumberContainers() {
        m = new HashMap<>(); // Maps index -> value
        d = new HashMap<>(); // Maps value -> min-heap of indices
    }

    // Updates index i with value n
    public void change(int i, int n) {
        // If the index i is already mapped to value n, do nothing
        if (m.containsKey(i) && m.get(i) == n) return;

        // Update the index i to value n
        m.put(i, n);

        // If value n is not already in map d, initialize it with an empty PriorityQueue
        if (!d.containsKey(n)) {
            d.put(n, new PriorityQueue<>());
        }

        // Add index i to the priority queue of value n
        d.get(n).offer(i);
    }

    // Finds the smallest index where value n is stored
    public int find(int n) {
        // If value n is not present in the system, return -1
        if (!d.containsKey(n)) return -1;

        PriorityQueue<Integer> pq = d.get(n); // Get the min-heap of indices for value n

        // Remove outdated indices from the top of the priority queue
        while (!pq.isEmpty() && m.get(pq.peek()) != n) {
            pq.poll(); // Remove invalid index
        }

        // If the queue is empty after cleanup, return -1, else return the smallest valid index
        return pq.isEmpty() ? -1 : pq.peek();
    }

   
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */