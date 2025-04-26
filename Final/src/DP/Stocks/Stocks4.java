package DP.Stocks;

public class Stocks4 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (n == 0 || k == 0) return 0;
    
            int[][] ahead = new int[2][k + 1];
            int[][] cur = new int[2][k + 1];
    
            for (int ind = n - 1; ind >= 0; ind--) {
                for (int buy = 0; buy <= 1; buy++) {
                    for (int cap = 1; cap <= k; cap++) {
                        if (buy == 1) {
                            // We can buy
                            int Buy = -prices[ind] + ahead[0][cap];
                            int skip = ahead[1][cap];
                            cur[buy][cap] = Math.max(Buy, skip);
                        } else {
                            // We can sell
                            int Sell = prices[ind] + ahead[1][cap - 1];
                            int skip = ahead[0][cap];
                            cur[buy][cap] = Math.max(Sell, skip);
                        }
                    }
                }
                // Update ahead
                for (int b = 0; b <= 1; b++) {
                    for (int c = 0; c <= k; c++) {
                        ahead[b][c] = cur[b][c];
                    }
                }
            }
    
            return ahead[1][k]; // start with buy allowed and k transactions
        }
    }
    
}
