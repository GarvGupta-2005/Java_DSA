package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class expressionAddOperator {
     //The Hard Part about this question is how to deal with the precedence of * operation
//Thus we need to pass Expression, Result_So_Far, And the previous no. used in case we get* operation as the current operat

//This works in case of * as in example of 7+3*2
//Ideally it will be evaluated as 10*2 =20 which is wrong 
//In oreder to correct it we subtract prevnum from res_So_far and then add the product of prevnum and cur_num
//In the above case 10 - 3[prevnum] + 3[prevnum]*2[curnum] = 7 + 6 = 13 whichis the correct answer 


     private static List<String> ans = new ArrayList<>();

    public static List<String> addOperators(String s, int target) {
        dfs( 0, "", 0, 0,s, target);
        return ans;
    }
    private static void dfs(int i, String path, long resSoFar, long prevNum, String s, int target) {
        if (i == s.length()) {
            if (resSoFar == target) ans.add(path);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0') break; // Skip leading zero number
            long currNum = Long.parseLong(s.substring(i, j + 1));
            if (i == 0) {
                dfs(j + 1, path + currNum, currNum, currNum,s, target); // First num, pick it without adding any operator!
            } else {
                dfs(j + 1, path + "+" + currNum, resSoFar + currNum, currNum,s, target);
                dfs(j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, s, target);
                dfs(j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, s, target);
            }
        }
    }
}
