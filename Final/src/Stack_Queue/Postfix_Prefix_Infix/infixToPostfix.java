package Stack_Queue.Postfix_Prefix_Infix;

import java.util.*;

public class infixToPostfix {
    public static int priority(char s){
        if(s == '^'){
            return 3;
        }
        else if(s == '*' || s == '/'){
            return 2;
        }
        else if(s == '+' || s == '-'){
            return 1;
        }else{
            return -1;
        }
    }
    public static String infiToPost(String s){
        Stack<Character> st = new Stack<>();
        String ans = "";
        int i = 0;
        while(i<s.length()){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')){
                ans = ans + s.charAt(i);
            }
            else if(s.charAt(i)=='('){
                st.push('(');
            }else if(s.charAt(i)==')'){
                while(st.isEmpty() && st.peek()!='('){
                    ans = ans + st.pop();
                }
                st.pop();
            }else{
                while(st.isEmpty() && priority(s.charAt(i))<=priority(st.peek())){
                    ans = ans + st.pop();
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            ans = ans + st.pop();
        }
        return ans;
    }
}
