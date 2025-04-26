import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostToCutStick {
     //The cost to cut the stick at the ith pos = arr[j+1] - arr[i-1];
     //Recursive code
    public int f(int i,int j,ArrayList<Integer> arr){
        if(i>j)return 0;//This indicates that the area to cut is not available

        int mini = (int)1e9;

        for(int ind = i; ind<=j; ind++){
            int cost = arr.get(j+1)-arr.get(i-1) + f(i,ind-1,arr) + f(ind+1,j,arr);
            mini  = Math.min(cost,mini);
        }

        return mini;
    }

    public int minCost(int n, int[] cuts) {
        //It is necessary that the array is soted so that the cuts lie at the correct places and will remain in the same order

        ArrayList<Integer> arr = new ArrayList<>();
        //We will have to add 0 and n as the last cut will include the length and the leftmost cut will have 0 to find the cost at each step
        arr.add(0);
        arr.add(n);
        for(int x : cuts){
            arr.add(x);
        }
        Collections.sort(arr);
        int c =  cuts.length;
        //The changing states are the positions where to cut namely i and j
        return f(1,c,arr);


    }

    //Memoization
    public int f2(int i,int j,ArrayList<Integer> arr,int [][] dp){
        if(i>j)return 0;//This indicates that the area to cut is not available

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini = (int)1e9;

        for(int ind = i; ind<=j; ind++){
            int cost = arr.get(j+1)-arr.get(i-1) + f2(i,ind-1,arr,dp) + f2(ind+1,j,arr,dp);
            mini  = Math.min(cost,mini);
        }

        return dp[i][j] =  mini;
    }

    public int minCost2(int n, int[] cuts) {
        //It is necessary that the array is soted so that the cuts lie at the correct places and will remain in the same order

        ArrayList<Integer> arr = new ArrayList<>();
        //We will have to add 0 and n as the last cut will include the length and the leftmost cut will have 0 to find the cost at each step
        arr.add(0);
        arr.add(n);
        for(int x : cuts){
            arr.add(x);
        }
        Collections.sort(arr);
        int c =  cuts.length;
        //The changing states are the positions where to cut namely i and j
        int [][] dp = new int[c+1][c+1];
        for(int i = 0;i<c+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f2(1,c,arr,dp);


    }

    //Tabulation
    public int minCost3(int n, int[] cuts) {
        List<Integer> arr = new ArrayList<>();

        // Add the two edges of the stick
        arr.add(0);
        arr.add(n);

        // Add all the cuts to the list
        for (int x : cuts) {
            arr.add(x);
        }

        // Sort the cut positions
        Collections.sort(arr);

        int m = arr.size();  // Total number of cuts including 0 and n
        int[][] dp = new int[m][m];

        // Build the DP table bottom-up
        for (int len = 2; len < m; len++) {  // length of segment (gap)
            for (int i = 0; i + len < m; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every cut position between i and j
                for (int k = i + 1; k < j; k++) {
                    int cost = arr.get(j) - arr.get(i) + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m - 1];
    }



}
