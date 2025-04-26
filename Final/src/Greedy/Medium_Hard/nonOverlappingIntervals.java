package Greedy.Medium_Hard;

import java.util.Arrays;

public class nonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //The Key is to find the max no. of intervals that are not overlapping and then
        //Subtract it from the total intervals to find the intervals to be removed
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }
}
