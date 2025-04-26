package Math.Advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class printAllPrimeFactors {
    //The Brute Solution is to go from 2 to N and check if N%i == 0 then i is a prime factor of N
    //This will lead to a time complexity of O(N)*O(N) = O(N^2) one for checking if i is prime and other for traversing from 2 to N

    //The better way is to go from 2 to sqrt(N) and check if N%i == 0 then i is a prime factor of N
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true; // 2 is the only even prime number
        if (num % 2 == 0) return false; // Eliminate even numbers greater than 2
        for (int i = 3; i * i <= num; i += 2) { // Check odd numbers up to sqrt(num)
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to find all prime factors of N
    public int[] AllPrimeFactors(int N) {
        if (N <= 1) return new int[0]; // Handle edge case for N = 1 or less

        List<Integer> primeFactors = new ArrayList<>();
        int sqrt = (int) Math.sqrt(N);

        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) {
                if (isPrime(i)) {
                    primeFactors.add(i); // Add the prime factor i
                }
                if ((N / i) != i && isPrime(N / i)) {
                    primeFactors.add(N / i); // Add the prime factor N/i
                }
            }
        }

        // Handle case where N itself is prime
        if (isPrime(N)) {
            primeFactors.add(N);
        }

        // Sort the prime factors
        Collections.sort(primeFactors);

        // Convert List to Array
        int[] ans = new int[primeFactors.size()];
        for (int i = 0; i < primeFactors.size(); i++) {
            ans[i] = primeFactors.get(i);
        }

        return ans;
    }

    public static List<Integer> allPrimeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                ans.add(i);
                while(n%i == 0){
                    n = n/i;
                }
        }
    }
    return ans;
}
//This function is based on the native division method to find the factors of a number 
}
