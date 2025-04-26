package Math.Advance;

import java.util.Arrays;

public class countPrimefromLtoR {
    //The brute solution is to check for each number from L to R if it is prime or not in the given Queries but thus will take O((R-L)*sqrt(R)) time
    //We can use the sieve of Eratosthenes to find all the prime numbers from 1 to R and then for each query we can check if the number is prime or not in the given query using prefix sum
    
    public static  int [] sieve(int n){
        int [] prime = new int[n+1];
        Arrays.fill(prime, 1);
        for(int i = 2;i<=n;i++){
            if(prime[i]==1){
                for(int j = i*i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        return prime;
    }
    public static void queryPrime(int [][] query){
        int n = 1000000;
        int [] prime = sieve(n);
        int cnt = 0;
        for(int i = 2;i<=n;i++){
            cnt = cnt + prime[i];
            prime[i] = cnt;
        }
        for(int i = 0;i<query.length;i++){
            int l = query[i][0];
            int r = query[i][1];
            System.out.println(prime[r]-prime[l-1]);
        }
    }
}
