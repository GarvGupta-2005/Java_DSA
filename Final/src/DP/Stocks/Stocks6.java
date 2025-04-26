package DP.Stocks;

import java.util.Arrays;

public class Stocks6 {
    private int f(int ind, int buy, int[] prices, int fee, int[][] dp) {
        if (ind == prices.length) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit;
        if (buy == 1) {
            int Buy = -prices[ind] + f(ind + 1, 0, prices, fee, dp);
            int notBuy = f(ind + 1, 1, prices, fee, dp);
            profit = Math.max(Buy, notBuy);
        } else {
            int sell = prices[ind] - fee + f(ind + 1, 1, prices, fee, dp); // Fee applied here
            int notSell = f(ind + 1, 0, prices, fee, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 1, prices, fee, dp);
    }
}



