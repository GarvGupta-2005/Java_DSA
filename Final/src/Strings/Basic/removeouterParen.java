package Strings.Basic;

import java.util.Stack;

public class removeouterParen {
    public static String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        //The main concept of this problem is to count the no of Opening brackets in the string
        // if the current char is '(' then first check the stack if it is not  empty then push the char to SB
        //else do noting as it is the beginning of outermost stack
        //The case is opposite for ')' first you pop and then check if the stack is empty then it was        
        // outermost else you add the char as it was part of innermost parenthesis
        StringBuilder sb = new StringBuilder("");
        char cur  = '*';
        for(int i = 0 ;i < s.length() ; i++){
            cur = s.charAt(i);
            if(cur=='('){
                if(st.size()>0){
                    sb.append(cur);
                }
                st.push(cur);
            }
            else{
                st.pop();
                if(st.size()>0){
                    sb.append(cur);
                }
            }
        }
        return sb.toString();
    }

}
