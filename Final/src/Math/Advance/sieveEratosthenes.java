package Math.Advance;

import java.util.*;

public class sieveEratosthenes  {
    public static void sieve(int n){
        int [] prime = new int[n+1];
        Arrays.fill(prime, 1);
        for(int i = 2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j = i*i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
    }

    //The time complexity of this algorithm is O(nlog(logn))


    //The following code was done by Rajesh Bhaiya 
    class Solution {
        public boolean isPrime(int n){
            int count_fact = 0;
            for(int i = 1;i<=n;i++){
                if(n%i==0){
                    count_fact++;
                }
                if(count_fact>2){
                    break;
                }
            }
            if(count_fact<=2){
                return true;
            }else{
                return false;
            }
        }
        public int countPrimes(int n) {
            
            int [] arr=new int[n+1];
            
            for(int i=2; i<=n;i++ ){
                arr[i]=1;
            }
    
            for(int i=2; i<=n;i++){
    
                for(int j= i+i;j<=n;j+=i){
    
                    arr[j]=0;
                }
            }
    
            int count=0;
            for(int i=0;i<n;i++){
    
                if(arr[i]==1){
                    count++;
                }
            }
            return count;
        
    }
    }
}
