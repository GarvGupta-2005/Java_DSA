package Greedy.Easy;

import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[] ) {
    // code here
    Arrays.sort(bt);
    int wt = 0;
    int cur_time = bt[0];
    for(int i = 1;i<bt.length;i++){
        cur_time += bt[i];
        int cur_wait = cur_time - bt[i];
        wt+= cur_wait;
    }
    int ans = wt/bt.length;
    return ans;
  }
}
