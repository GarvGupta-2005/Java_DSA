package Stack_Queue.Intro;
import java.util.Stack;
class pair{
    int ele;
    int min;
    pair(int ele,int min){
        this.ele = ele;
        this.min = min;
    }
}
  class MinStack {
    Stack<pair> st ;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.size() == 0){
            st.push(new pair(val,val));
        }    
        else{
            int cur_min = Math.min(val,st.peek().min);
            st.push(new pair(val,cur_min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().ele;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}
public class minStack {
    public static void main(String[] args) {
        MinStack x = new MinStack();
        x.getMin();
    }
}
