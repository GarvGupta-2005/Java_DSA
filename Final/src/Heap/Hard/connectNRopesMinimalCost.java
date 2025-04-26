package Heap.Hard;

import java.util.PriorityQueue;

public class connectNRopesMinimalCost{
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();//Defsult min heap
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        
        int minC = 0;
        while(pq.size()>1){
            int first = pq.poll();//most minimum element
            int sec = pq.poll();//second most
            int sum = first+sec;
            pq.add(sum);
            minC += sum;
        }
        return minC;
    }
    public static void main(String[] args) {
        int [] demo = {2,3,4,6};
        System.out.println(minCost(demo));
    }
}