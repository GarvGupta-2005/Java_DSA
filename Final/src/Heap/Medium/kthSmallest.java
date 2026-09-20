package Heap.Medium;

import java.util.PriorityQueue;

public class kthSmallest {
     public int kthSmallest(int[] arr, int k) {
        // Code here

         //We will store the K smallest elements only in the heap.
         //After that the largest among those k smallest elements will be stored at the root and thus we will return ity
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int x: arr){
            pq.add(x);
            
            while(pq.size() > k){
                pq.poll();
            }
            
        }
        
        return pq.poll();
    }
}
