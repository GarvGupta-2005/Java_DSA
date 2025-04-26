package Greedy.Medium_Hard;
import java.util.*;
public class JobSequnce {

    class Pair {
        int deadline;
        int profit;

        public Pair(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // Priority Queue sorting by deadline (descending), then profit (descending)
        int n = deadline.length;

        // Step 1: Create a list of pairs and sort by profit (descending), then deadline (descending)
        List<Pair> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Pair(deadline[i], profit[i]));
        }

        // Sorting jobs by profit in descending order; if profit is same, sort by deadline descending
        jobs.sort((a, b) -> b.profit != a.profit ? Integer.compare(b.profit, a.profit) : Integer.compare(b.deadline, a.deadline));

        // Step 2: Find the maximum deadline
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // Step 3: Array to track free slots
        boolean[] slot = new boolean[maxDeadline + 1]; // 1-based index
        int totalProfit = 0;
        int jobsCompleted = 0;

        // Step 4: Assign jobs greedily
        for (Pair job : jobs) {
            // Try to find a free slot for this job, starting from its deadline
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    jobsCompleted++;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(jobsCompleted, totalProfit));
    }

}