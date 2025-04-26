package Greedy.Medium_Hard;

import java.util.*;

public class LRU {
    static int pageFaults(int N, int C, int pages[]){
        // code here
        int pageFaults = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int page : pages) {
            if (queue.contains(page)) {
                // Page is in memory, move it to the end (most recently used)
                queue.remove(page);
            } else {
                // Page fault occurs
                pageFaults++;
                if (queue.size() == C) {
                    queue.poll(); // Remove LRU page (front of queue)
                }
            }
            queue.offer(page); // Insert the new (or recently used) page
        }
        return pageFaults;
    }
}
