package Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthLargest {
    public int findKthLargest(int[] nums, int k) {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer i , Integer j){
                if(i > j){
                    return -1; // to not sort 
                }else{
                    return 1; // to sort
                }
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);
        int n = nums.length;
        for(int i = 0;i<n;i++){
            pq.add(nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        int count = 1;
        while(pq.size()>0){
            if(count == k){
                ans = pq.poll();
                break;
            }
            count++;
            pq.poll();
        }
        return ans;
    }

}
