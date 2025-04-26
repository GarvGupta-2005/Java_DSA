package Strings.Basic;

public class biggestOddIntegerinString {
        public static String largestOddNumber(String num) {
            int n = num.length();
            char last = num.charAt(n-1);
            if((last -'0')%2 != 0){
                return num; 
            // if the last digit of the number is odd then we can clearly see that the whole number is odd
           }
           last = '*';
           int firstOddIndex = -1;
           int digit = 0;
           for(int i = n-2; i>=0 ; i--){
            last = num.charAt(i);
            digit = last - '0';
            if(digit%2!=0){
                firstOddIndex = i;
                //here we find the index of first odd digit in string
                break;
            }
            
           }
           String ans = num.substring(0,firstOddIndex+1);
           //This will form the largest odd integer from the beginning of string to the first odd index
            return ans;
    
        }
    }

