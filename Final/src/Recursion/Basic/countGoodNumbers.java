package Recursion.Basic;

public class countGoodNumbers {
    //So basically we will be given a long number n and we have to form a number such that at all places we will have eevn digits and at odd places we will have prime numbers
    //For instance For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
    //The only even digits that can fulfil the condition is 0,2,4,6,8 & the only prime numbers that can fulfil the condition is 2,3,5,7

    //The iterative solution is that for all even places multiply answer by 5 and all odd places multiply it by 4 but this won't work for big numbers as the input can go from 1 to 10^15
        // Define MOD as a class variable for easier reference and readability
        public long MOD = 1_000_000_007;
    
        public int countGoodNumbers1(long n) {
            
            // Calculate the number of even and odd positions in the digit string
            long odd = n/2;
            long even = (n+1)/2;
            
            // Calculate the total number of good digit strings
            // multiplying 5 by even because there could only be 5 even numbers between 0-9
            // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
            return (int)(pow(5,even) * pow(4,odd) % MOD);
        }
        
        public long pow(long x, long n){
            
            // Base case for the recursion
            if(n==0) 
                return 1;
            
            // Recursively calculate x^(n/2)
            long temp = pow(x,n/2);
            
            // If n is even, return (x^(n/2))^2
            if(n%2==0){
                return (temp * temp)% MOD;
            }
            // If n is odd, return (x^(n/2))^2 * x
            else{
                return (x * temp * temp)% MOD;
            }
        }
}
