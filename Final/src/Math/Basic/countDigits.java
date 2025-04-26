package Math.Basic;

public class countDigits {
    //The Brute force is to extract digits from the number and count them
    public static int cntDigits(int x){
        int ans = 0;
        while(x>0){
            //  int cur = x%10;
            //  cur = cur + 2;//Waste step; Just to show that we can do some operation on the digit
            ans++;
            x = x/10;
        }
        return ans;
    }
    //The optimal operation is to use Log 
    public static int cntDigitsOptimal(int x){
          // Initialize a variable 'cnt' to
        // store the count of digits.
        int cnt = (int) (Math.log10(x) + 1);

        // The expression (int)(Math.log10(n) + 1)
        // calculates the number of digits in 'n'
        // and casts it to an integer.

        // Adding 1 to the result accounts
        // for the case when 'n' is a power of 10,
        // ensuring that the count is correct.

        // Finally, the result is cast
        // to an integer to ensure it is rounded
        // down to the nearest whole number.

        // Return the count of digits in 'n'.
        return cnt;
    }
}
