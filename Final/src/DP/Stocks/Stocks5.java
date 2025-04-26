package DP.Stocks;

import java.util.Arrays;

public class Stocks5 {
    //Memorization
    private int f(int ind, int buy, int[] prices, int[][] dp) {
    if (ind >= prices.length) return 0; // Fix: handle ind+1, ind+2 safely

    if (dp[ind][buy] != -1) {
        return dp[ind][buy];
    }

    int profit;
    if (buy == 1) {
        int Buy = -prices[ind] + f(ind + 1, 0, prices, dp);
        int notBuy = 0 + f(ind + 1, 1, prices, dp);
        profit = Math.max(Buy, notBuy);
    } else {
        int sell = prices[ind] + f(ind + 2, 1, prices, dp);
        int notSell = 0 + f(ind + 1, 0, prices, dp);
        profit = Math.max(sell, notSell);
    }

    return dp[ind][buy] = profit;
}

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 1, prices, dp);
    }
}
