package Heap.Medium;


import java.util.*;

class Solution {


//This is a very intutive question we have to Keep count of Both the number of tasks of same kind remaining and the time they were last executed//Will be done using OOPS
//We will be maintaing a Priority Queue for active tasks and a queue for those tasks in cooldown
//We will be putting the tasks in cooldown queue after executing them PQ
//If the current time - last_executed_time > n then we can bring them out of queue in active PQ



    // Task class to store count and available execution time
    class Task {
        int time;   // The next available execution time
        int count;  // Remaining occurrences of the task

        Task(int time, int count) {
            this.time = time;
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] freq = new int[26]; // Since only 26 uppercase letters exist

        // Max-Heap (PriorityQueue) based on task frequency (higher first)
        PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.count, t1.count));

        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Push all tasks with a frequency > 0 into the PriorityQueue
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Task(0, freq[i])); // Initially, all tasks are available at time 0
            }
        }

        // Queue to store tasks that are in cooldown
        Queue<Task> cooldownQueue = new LinkedList<>();

        while (!pq.isEmpty() || !cooldownQueue.isEmpty()) {
            // Check if any task in cooldown can be re-added to PQ
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().time <= time) {
                pq.add(cooldownQueue.poll());
            }

            if (!pq.isEmpty()) {
                Task t = pq.poll(); // Get the task with highest count
                t.count--; // Execute once
                t.time = time + n + 1; // Cooldown period before next execution

                if (t.count > 0) {
                    cooldownQueue.add(t); // Put back in cooldown queue
                }
            }

            time++; // Move to the next unit of time
        }

        return time;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(sol.leastInterval(tasks, n)); // Expected output: 8
    }
}


public class taskScheduler {
    
}
