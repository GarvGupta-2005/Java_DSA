package Questions;

import java.util.HashMap;

public class NoOfDistinctColors {
    // The Basic jist of the question is we have to remember the ball no. which we
    // have coloured and the colour we have already used in order to find the
    // current unique differnet colors
    // The Concept of hashing was already in my mind. The hint only taught me to use
    // 2 hashmaps

    public static int[] queryResults(int limit, int[][] que) {
        HashMap<Integer, Integer> Ball = new HashMap<>();// To store which ball has been used
        HashMap<Integer, Integer> Color = new HashMap<>();// To Store all the unique colors
        int n = que.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cur_ball = que[i][0];
            int cur_col = que[i][1];
            // First we will deal with the case where ball has not been painted yet then we
            // will deal with the case ehere the ball has already been painted once

            if (!Ball.containsKey(cur_ball)) {// The current ball has not been painted yet
                // Now we will see whether the current color is in use or not;
                if (!Color.containsKey(cur_col)) {
                    Ball.put(cur_ball, cur_col);// Putting the ball with its corresponding color
                    Color.put(cur_col, 1);
                    res[i] = Color.size();
                } else {
                    // The Color has been in use by some other Ball as well
                    res[i] = Color.size();// Since the current color is not distinct
                    Ball.put(cur_ball, cur_col);// Putting the new ball with the already used color
                    Color.put(cur_col, Color.get(cur_col) + 1);// Incrementing the no of ball using the current col
                }
            } else {// The current ball has been painted once
                int old_col = Ball.get(cur_ball);
                Color.put(old_col, Color.get(old_col) - 1);// Decrementing the no.of balls used by old_color
                if (Color.get(old_col) <= 0) {
                    Color.remove(old_col);// This will remove the the old_color from color map as it is not being used
                                          // by any ball
                }
                Ball.put(cur_ball, cur_col);
                Color.put(cur_col, Color.getOrDefault(cur_col, 0) + 1); // Fix: Increment new color count if already
                                                                        // used
                res[i] = Color.size();
            }
        }
        return res;
    }
}
