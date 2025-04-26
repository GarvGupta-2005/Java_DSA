package Math.Basic;

import java.util.Scanner;

public class primeNoCheck {
    //Prime number is defined as  a number having just 2 factors 1 and itself and greater than 1
    //The brute force method is to count from 1 to N and check if N%i == 0 then increment a counter. If counter ecuals 2 then it is a prime number else if it exceeds 2 then it is not a prime number
    //Time complexity of this approach is O(N)

    //The better way is to use the property of prime numbers that they have only 2 factors 1 and itself and all the factors of a number can be achieved before sqrt(N
    public static boolean isPrime(int num) {
		//Your code goes here
		int count = 0;
		for (int i = 1; i*i <= num; i++) {
			if(num%i == 0){
				count++;
				if((num/i)!=i){
					count++;
				}
			}
		}
		if(count==2) return true;
		else{
			return false;
		}
	}
	public static void main(String [] args){
		Scanner s= new Scanner(System.in);
		int num = s.nextInt();
		if(isPrime(num)){
			System.out.print("YES");
		}else{
			System.out.print("NO");
		}
        s.close();
	}
}
