package Heap.Medium;

import java.util.PriorityQueue;

public class kthSmallest {
    public static int K_Smallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int ans = -1;
        if(k == 1){
            return pq.remove();
        }
        while(k>1){
            pq.remove();
            k--;
        
        }
        return pq.remove();
        
    }
}
