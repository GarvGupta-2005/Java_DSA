package Stack_Queue.Intro;
import java.util.*;

class MyQueue {
    Stack < Integer > input;
    Stack < Integer > output;
    public MyQueue() {
         input = new Stack < > ();
         output = new Stack < > ();
    }
    
    public void push(int x) {
        while (input.empty() == false) {
            output.push(input.peek());
            input.pop();
        }
        // Insert the desired element in the stack input
        System.out.println("The element pushed is " + x);
        input.push(x);
        // Pop out elements from the stack output and push them into the stack input
        while (output.empty() == false) {
            input.push(output.peek());
            output.pop();
        }

    }
    
    public int pop() {
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        int val = input.peek();
        input.pop();
        return val;

    }
    
    public int peek() {
        // shift input to output 
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        return input.peek();
    }
    
    public boolean empty() {
        return input.isEmpty();
    }
}

class MyQueue1 {
    Stack < Integer > input = new Stack < > ();
    Stack < Integer > output = new Stack < > ();
    /** Initialize your data structure here. */
    public MyQueue1() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        System.out.println("The element pushed is " + x);
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift input to output 
        if (output.empty())//Transfers all element sto the another stack so the order is reversed then delete the top element which is the front element for the queue and then return the elements to the same order by pushing them back;
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }


        int x = output.peek();
        output.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        // shift input to output 
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }
    int size() {
        return (output.size() + input.size());
    }
}
public class queueUsingStack {
    
}
