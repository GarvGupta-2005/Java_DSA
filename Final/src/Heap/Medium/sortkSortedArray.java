package Heap.Medium;
import java.util.*;
public class sortkSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        
        ArrayList<Integer> arry = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            arry.add(pq.remove());
        }
        
        return arry;
    } 
}
