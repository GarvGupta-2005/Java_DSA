package Stack_Queue.MonoTonicStack_Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nextgreaterElement {
    public static List<Integer> nextGreaterElement(int [] a){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = a.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i]){
                st.pop();  //removing all the short elements form the top to find the greater element
            }
            if(st.isEmpty()){
                ans.add(i, -1);//This means there is no greater element to the right
            }else{
                st.add(i, st.peek());//Adding the top element of stack as the NGE for this current array element
            }
            st.push(a[i]);//Pushin the current element for the next element
        }
        return ans;
    }
}
