package Bit_Manipulation;

public class even_odd {
   public  static boolean isEven(int n) {
        // code here
        if((n&1)==1){ //Performing AND operation with 1 to check if the last bit is 1 or not //If it is 1 then it is odd as no even number has 1 at the last bit
            return false;
        }
        return true;
    }
}
