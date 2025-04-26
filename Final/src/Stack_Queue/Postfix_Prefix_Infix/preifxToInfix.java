package Stack_Queue.Postfix_Prefix_Infix;

import java.util.Stack;

public class preifxToInfix {
    public static String preToInfix(String s){
        int i = s.length()-1;
        Stack<String> st  = new Stack<>();
        while(i>=0){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')){
                String cur = ""+s.charAt(i);
                st.push(cur);
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String res = '(' + t1 + s.charAt(i) + t2 + ')';
                st.push(res);
            }
            i--;
        }
        return st.peek();
    }
}
