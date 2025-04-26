package DP.Stocks;

import java.util.*;

public class Stocks3 {
    //Basically we have been given a specific number of transactions that we can perform that is 2
    private int f(int ind,int buy,int cap,int [] prices,int [][][] dp){
        if(cap<=0)return 0;
        if(ind == prices.length)return 0;
        if(dp[ind][buy][cap]!=-1){
            return dp[ind][buy][cap];
        }

        int profit;
        if(buy == 1){
            int Buy = -prices[ind] + f(ind+1,0,cap,prices,dp);
            int notBuy = 0 + f(ind+1,1,cap,prices,dp);
            profit = Math.max(Buy,notBuy);
        }else{
            int sell = prices[ind] + f(ind+1,1,cap-1,prices,dp);
            int notSell = 0 + f(ind+1,0,cap,prices,dp);
            profit = Math.max(sell,notSell);
        }
        return dp[ind][buy][cap] =  profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n][2][3];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,1,2,prices,dp);
    }

    //Tabulation
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3]; // dp[ind][buy][cap]

        // All elements are initialized to 0 by default

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) { // cap = 1 and 2 are valid
                    int profit;
                    if (buy == 1) {
                        int Buy = -prices[ind] + dp[ind + 1][0][cap];
                        int notBuy = dp[ind + 1][1][cap];
                        profit = Math.max(Buy, notBuy);
                    } else {
                        int Sell = prices[ind] + dp[ind + 1][1][cap - 1];
                        int notSell = dp[ind + 1][0][cap];
                        profit = Math.max(Sell, notSell);
                    }
                    dp[ind][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2]; // Starting at index 0, buy allowed, 2 transactions
    }

    //Space Optimised
    static int maxProfit3(int[] prices) {
        int n = prices.length;

        // Create a 2D array 'ahead' and 'cur' to store profit values
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        // Loop through the prices array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(0 + ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        cur[buy][cap] = Math.max(0 + ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }

            // Update 'ahead' with the values in 'cur'
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }

        // The maximum profit with 2 transactions is stored in ahead[0][2]
        return ahead[0][2];
    }
}
