package Stack_Queue.MonoTonicStack_Questions;

import java.util.Stack;

public class previous_nextSmallerElement {
    public static int [] nextSmaller(int []a){
        int [] res = new int[a.length];
        Stack<Integer> st  = new Stack<>();
        for(int i = 0;i<a.length;i++){
            while(!st.isEmpty() && st.peek()>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(a[i]);
        }
        return res;
    }
}
