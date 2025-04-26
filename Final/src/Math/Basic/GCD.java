package Math.Basic;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args)  
	{
	    // Write your code 
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		int [] ans = new int[t];
		int count = 0;
		while(count<t){
			int dividend = s.nextInt();
			int divisor = s.nextInt();
			while(dividend%divisor!=0){
				int remainder = dividend%divisor;
				dividend = divisor;
				divisor = remainder;
			}
			ans[count++] = divisor;
		}
		for(int i = 0;i<t;i++){
			System.out.println(ans[i]);
		}
        s.close();
	}

	//Even more efficient way to find GCD is by using Euclidean Algorithm which states that 
	//gcd(n1,n2) = gcd(n1-n2,n2) if n1>n2 and this can be used recursively called to find the gcd of 2 numbers
	//If n1 or n2 becomes 0 then the other number is the required GCD
	//The call will be gcd(a,b) = gcd(b,a%b)  where a > b and this will be called recursively until b becomes 0

	public static void gcdEuclidean(int a, int b){
		while(a>0 && b>0){
			if(a>b){
				a = a%b;
			}
			else{
				b = b%a;
			}
			if(a == 0){
				System.out.println(b);
			}
			if(b == 0){
				System.out.println(a);
			}
				
		}
	}
	//The time complexity of this approach is O(log(min(a,b)))
}
