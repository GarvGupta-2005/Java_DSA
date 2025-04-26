package Stack_Queue.Intro;
import java.util.Queue;
import java.util.*;
public class stackUsingQueue {
    class MyStack {
        Queue <Integer> q;
        public MyStack() {
            q = new LinkedList < > ();
        }
        
        public void push(int x) {
            q.add(x); //Add the new element to the end of queue
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.remove()); //Add all the front elements after the newly added element so that pop returns the top element
            }
        }
        
        public int pop() {
            return q.remove();
        }
        
        public int top() {
            return q.peek();
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }
    
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
