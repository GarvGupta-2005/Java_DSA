import java.util.*;

public class MaxCoins2 {
        public int helper(int ind,int [] coins,int amount,int [][] dp ){
            //Handling the edge case
            if(ind == 0){
                if(amount%coins[0] == 0){
                   return 1;
                }else{
                    return 0;
                }
            }
    
            if(dp[ind][amount]!=-1){
                return dp[ind][amount];
            }
    
            //NotTake
            int notTake = 0 + helper(ind-1,coins,amount,dp);
            int take = 0;
            if(coins[ind]<=amount){
                take =  helper(ind,coins,amount - coins[ind],dp);
            }
    
            return dp[ind][amount] = take + notTake;
        }
    
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int [][] dp = new int[n][amount+1];
            for(int i = 0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return helper(n-1,coins,amount,dp);
        }
    
}
