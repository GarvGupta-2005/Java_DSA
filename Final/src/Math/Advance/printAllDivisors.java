package Math.Advance;

import java.util.*;

public class printAllDivisors {
    //The Brute way is to go from 1 to N and see if N%i == 0 then i is a divisor of N
    //Time complexity of this approach is O(N)

    //This can be done optimally by going from 1 to sqrt(N) and checking if N%i == 0 then i and N/i are divisors of N
    public static void printDivisor(int n){
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                System.out.println(i);
            }
            if(n/i != i){
                System.out.println(n/i);
            }
        } 
    }
    public static PriorityQueue<Integer> findDivisors(int n) {
        // Initialize an empty
        // ArrayList to store the divisors
        // ArrayList<Integer> divisors = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Iterate up to the square
        // root of n to find divisors
        // Calculate the square root of n
        int sqrtN = (int) Math.sqrt(n);

        // Loop from 1 to the
        // square root of n
        for (int i = 1; i <= sqrtN; ++i) {
            // Check if i divides n
            // without leaving a remainder
            if (n % i == 0) {
                // Add divisor i to the list
                pq.add(i);

                // Add the counterpart divisor
                // if it's different from i
                if (i != n / i) {
                    // Add the counterpart
                    // divisor to the list
                    pq.add(n / i);
                }
            }
        }
        // Return the list of divisors
        return pq;
    }
}
