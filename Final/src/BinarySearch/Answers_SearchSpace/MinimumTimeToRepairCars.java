package BinarySearch.Answers_SearchSpace;

public class MinimumTimeToRepairCars{
    class Solution {
        //Observations:
        //1. The Higher the rank, the slower the mechanics work
        //2. The equation r*n^2 is the minutes, not the number of cars. Remember it.
    
        public boolean isPossible(int[] ranks, long mid, int cars) {
            int cars_repaired = 0;
            for (int i = 0; i < ranks.length; i++) { // Fix loop condition
                cars_repaired += (int) Math.sqrt(mid / ranks[i]);
                if (cars_repaired >= cars) return true; // Early exit for efficiency
            }
            return cars_repaired >= cars;
        }
    
        public long repairCars(int[] ranks, int cars) {
            long low = 1L; // Use 'L' for long literals
            int minRank = ranks[0]; // The minimum rank determines the fastest mechanic
    
            // Find the minimum rank
            for (int i = 1; i < ranks.length; i++) {
                if (minRank > ranks[i]) {
                    minRank = ranks[i];
                }
            }
    
            // The maximum time that can be taken by a mechanic is minRank * cars * cars
            // This can be shown if there is only one mechanic with rank 4 and we have 10 cars,
            // then it will take 4 * 10 * 10 = 400 minutes.
            long high = (long) minRank * cars * cars; // Ensure long computation
            long ans = 0L;
    
            while (low <= high) {
                long mid = low + (high - low) / 2;
                if (isPossible(ranks, mid, cars)) {
                    ans = mid;
                    high = mid - 1; // Try for a smaller time
                } else {
                    low = mid + 1; // Increase time
                }
            }
            return ans;
        }
    }
    
}