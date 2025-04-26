package Stack_Queue.Postfix_Prefix_Infix;

import java.util.Stack;


public class postTopre {
    public static String postFixtoPre(String s){
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')){
                String cur = "" + s.charAt(i);
                st.push(cur);
            }else{
                String t1 = st.pop();
                String t2 = st.pop();
                st.push(s.charAt(i)+t1+t2);
            }
            i++;
        }
        return st.peek();
    }
}
