package Strings.Hard;
import java.util.*;


public class MinReversaltoMAkeBalanced {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else {
                if(!st.isEmpty() &&  st.peek()=='('){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        return st.size();
    }
}
