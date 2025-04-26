package Heap.Hard;

import java.util.PriorityQueue;

public class KthLargets {
//The key concept is to fill the PQ until there are k elements and then check for the min element after inserting the kth element in the PQ. If the incoming element is gretaer than the min heap's top then remove the top and give Insert the element else discard it

PriorityQueue<Integer> pq;
int k;
    public KthLargets(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int val : nums){
            add(val);
        }
    }
    
    public int add(int val) {
        if(pq.size()< k || val>pq.peek()){
            pq.offer(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
