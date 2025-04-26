package Greedy.Easy;
public class ValidParenthesisAsterisk {

    public static boolean checkValidString(String s) {
        //Recursive code -> O(3^N)
        //DP is also one of the approach 
        //Here We will use Greedy Approach to solve this problem 
        //Rather than counting the values of Asterisk we will be carrying the range
//if ) is encountered we decrement the count, if ( is encountered we increase else 0
//If in the end the min is 0 and max is 1 then that mean we have a valid range and we return true or false;

        int min = 0;
        int max = 0;
        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }else if(s.charAt(i)==')'){
                min = min -1;
                max = max - 1;
            }else{
                min = min - 1;
                max = max + 1;
            }
            if(min < 0) min = 0;//cos ngative means there is a closing bracket at the beginning which can never be a valid string 
            if(max < 0) return false;//means there is no range 
        }
        return min == 0;
    }
}