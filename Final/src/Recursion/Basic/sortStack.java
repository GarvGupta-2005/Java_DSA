package Recursion.Basic;
import java.util.*;

public class sortStack {
    public static void Sortstack(Stack<Integer> st ){
        if(st.isEmpty()|| st.size()==1){
            return;
        }
        int top = st.pop();
        Sortstack(st);
        insert(st,top);
        return;
    }

    public static void insert(Stack<Integer> st,int top){
        if(st.isEmpty()|| st.peek()<=top){
            st.push(top);
            return;
        }
        int peek_element = st.pop();
        insert(st, top);
        st.push(peek_element);
    }
}
