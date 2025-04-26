package DP.Stocks;

import java.util.*;

public class Stocks2 {

    //Memorization
    private int f(int ind, int buy, int[] prices, int[][] dp) {
        //If we reach the end we can't buy or sell so return 0
        if (ind == prices.length) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        int profit;
        if (buy == 1) {
            int Buy = -prices[ind] + f(ind + 1, 0, prices, dp);//We buy at today's price
            int notBuy = 0 + f(ind + 1, 1, prices, dp);//we don't buy today
            profit = Math.max(Buy, notBuy);
        } else {
            int sell = prices[ind] + f(ind + 1, 1, prices, dp);//we sell todya
            int notSell = 0 + f(ind + 1, 0, prices, dp);//we don't sell today
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

    //Tabulation
    public int maxProfit1(int[] prices) {
        //Now the tabulation so we need dp of one size greater to store the base case as well 
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        //First write the base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        //Main working will be reverse of memorization
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit;
                if (buy == 1) {
                    int Buy = -prices[i] + dp[i + 1][0];//We buy at today's price
                    int notBuy = 0 + dp[i + 1][1];//we don't buy today
                    profit = Math.max(Buy, notBuy);
                } else {
                    int sell = prices[i] + dp[i + 1][1];//we sell todya
                    int notSell = 0 + dp[i + 1][0];//we don't sell today
                    profit = Math.max(sell, notSell);
                }
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }

    //Space optimisation
    public int maxProfit2(int[] prices) {
        //Now the tabulation so we need dp of one size greater to store the base case as well 
        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];
        //First write the base case
        ahead[0] = 0;
        ahead[1] = 0;

        //Main working will be reverse of memorization
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit;
                if (buy == 1) {
                    int Buy = -prices[i] + ahead[0];//We buy at today's price
                    int notBuy = 0 + ahead[1];//we don't buy today
                    profit = Math.max(Buy, notBuy);
                } else {
                    int sell = prices[i] + ahead[1];//we sell todya
                    int notSell = 0 + ahead[0];//we don't sell today
                    profit = Math.max(sell, notSell);
                }
                cur[buy] = profit;
            }
            ahead[0] = cur[0];
            ahead[1] = cur[1];
        }

        return ahead[1];
    }
}
