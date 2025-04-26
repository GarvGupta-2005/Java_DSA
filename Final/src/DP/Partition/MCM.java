public class MCM{
    static int f(int i,int j,int [] arr){
        if(i == j){
            return 0;//Since there exists only 1 matrix so we can't multiply it with anyone so steps are 0
            
        }
        
        int maxi = (int)1e9;
        for(int k = i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + f(i,k,arr) + f(k+1,j,arr);
            maxi = Math.min(maxi,steps);
        }
        return maxi;
    }
    
    static int matrixMultiplication(int arr[]) {
        // the recursive functiond call f(i,j) represents the minimum steps to multiply matrices from i to j
        int n = arr.length;
        return f(1,n-1,arr);
        
    }

    static int matrixMultiplication2(int arr[]) {
        // the recursive functiond call f(i,j) represents the minimum steps to multiply matrices from i to j
        int n = arr.length;
        int [][] dp = new int[n][n];
        //Since base case are already zeroes so we don't need to fill it again 
        

        //We did not start j from 1 becuase i should be always less than j in order to form a perfect partition
        for(int i = n-1;i>=1;i--){
            for(int j = i+1;j<n;j++){
                int maxi = (int)1e9;
                for(int k = i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    maxi = Math.min(maxi,steps);
                }
                dp[i][j] =  maxi;
            }
        }
        
        return dp[1][n-1];
        
    }
}