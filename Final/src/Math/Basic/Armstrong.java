package Math.Basic;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		// Calculate the number of
        // digits in the given number
        int k = String.valueOf(num).length();
        // Initialize the sum of digits
        // raised to the power of k to 0
        int sum = 0;
        // Copy the value of the input
        // number to a temporary variable n
        int n = num;
        // Iterate through each
        // digit of the number
        while(n > 0){
            // Extract the last
            // digit of the number
            int ld = n % 10;
            // Add the digit raised to
            // the power of k to the sum
            sum += (int)Math.pow(ld, k); 
            // Remove the last digit
            // from the number
            n = n / 10;
        }
        // Check if the sum of digits raised to
        // the power of k equals the original number
		if(sum == num){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
        s.close();
	}
}
