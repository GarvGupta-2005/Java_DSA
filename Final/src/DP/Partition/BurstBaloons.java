import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBaloons {
    //This is a very Tough and intutive problem as we can see that the sub problems will be dependent on each other 
    //so rather than thinking which will be the first to be deleted we will think which was the last one to be deletd 
    //In this manner we will be able to build our answer as we will know which one was bursted last so it would have existed in the second last call of the function 

    //Recursive code
    public int f(int i,int j,List<Integer> arr){
        if(i>j) return 0;//Indicating no valid partition

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind<=j;ind++){
            int cost = arr.get(i-1)*arr.get(ind)*arr.get(j+1) + f(i,ind-1,arr) + f(ind+1,j,arr);
            maxi = Math.max(cost,maxi);
        }

        return maxi;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        //Adding 1 to start and end will serve the purpose of having only one element at the end
        arr.add(1);
        for(int x : nums){
            arr.add(x);
        }
        arr.add(1);

        return f(1,n,arr);
    }

    //Memoization code
    public int f2(int i,int j,List<Integer> arr,int [][] dp){
        if(i>j) return 0;//Indicating no valid partition

        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind<=j;ind++){
            int cost = arr.get(i-1)*arr.get(ind)*arr.get(j+1) + f2(i,ind-1,arr,dp) + f2(ind+1,j,arr,dp);
            maxi = Math.max(cost,maxi);
        }

        return dp[i][j] =  maxi;
    }

    public int maxCoins2(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        //Adding 1 to start and end will serve the purpose of having only one element at the end
        arr.add(1);
        for(int x : nums){
            arr.add(x);
        }
        arr.add(1);
        int [][] dp = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }


        return f2(1,n,arr,dp);
    }

    //Tabulation
    public int maxCoins3(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        //Adding 1 to start and end will serve the purpose of having only one element at the end
        arr.add(1);
        for(int x : nums){
            arr.add(x);
        }
        arr.add(1);
        int [][] dp = new int[n+2][n+2];
        for(int i = n;i>=1;i--){
            for(int j = 1;j<=n;j++){
                if(i>j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind = i; ind<=j;ind++){
                    int cost = arr.get(i-1)*arr.get(ind)*arr.get(j+1)+ dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(cost,maxi);
                }
            dp[i][j] =  maxi;
            }
        }


        return dp[1][n];
    }
}
