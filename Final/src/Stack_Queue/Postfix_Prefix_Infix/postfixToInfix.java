package Stack_Queue.Postfix_Prefix_Infix;

import java.util.Stack;

public class postfixToInfix {
    public static String postToInfi(String s){
        Stack<String> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')){
                String cur = "" + s.charAt(i);
                st.push(cur);
            }else{
                String  s1 = st.pop();
                String  s2 = st.pop();
                String cur = '(' + s2 + s.charAt(i) + s1 +')';
                st.push(cur);
            }
        }
        return st.peek();
    }
}
