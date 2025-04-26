package DP.Stocks;

public class Stocks1 {
        public static int maxProfit(int[] p) {
            //The Tip to maximise the profit is to buy on the minimum day and sell it on max day
            int mini = p[0];
            int profit = 0;
            for(int i = 1;i<p.length;i++){
                //First we will calculate the profit if we sell today
                int cost = p[i] - mini;
                //Then we will calculate the profit
                profit = Math.max(cost,profit);
                //Finally we will find the minimum price day
                mini = Math.min(mini,p[i]);
            }
            return profit;
        }
    
}
