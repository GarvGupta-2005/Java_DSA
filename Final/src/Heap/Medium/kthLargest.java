package Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargest {
//We will use a min heap here to store only the k largest elements of the array
    // Once the heap only contains the largest k elements among the array we can return the root of the heap/
    // as among those k largest  elements, the smallest will be at the root which is also the kth largest in the entire array 
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x : nums){
            pq.add(x);

            while(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }
}
