package Array.MediumLevel;

public class BuyandSellStock {
    public int maxProfit(int[] p) {
        int mini = p[0]; //Assuming that on day 1 we have minimum price
        int profit = 0; //Initially profit is 0
        for(int i = 1;i<p.length;i++){
            int cost = p[i]-mini;//Calculating what profit will we have if we sell on that day
            profit = Math.max(cost,profit);//Max profit uptil now
            mini = Math.min(mini,p[i]);//To cjange mini if we encounter a price lower than our mini on any day 
        }
        return profit;
    }
}
