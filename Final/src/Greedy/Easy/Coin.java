package Greedy.Easy;

import java.util.Arrays;

public class Coin {
     public static  int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        Arrays.sort(coins);
        int n = coins.length;
        int ans = 0;
        int amnt = amount;
        for(int i = n-1;i>=0;i--){
            while(amnt >= coins[i]){
                amnt = amnt - coins[i];
                ans++;
            }
        }
        if(amnt == 0){
            return ans;
        }else{
            return -1;
        }
    }

    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill with a large number
        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }     
}
