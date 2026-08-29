package Stack_Queue.Intro;

public class stackUsingArray {
        public static void main(String[] args) {

       stack s  = new stack(5);
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
    }
}
class stack {
    private int size = 10000;
   private int arr[] = new int[size];
   private int top = -1;
   stack(int size) {
       this.size = size;
       arr = new int[size];
       top = -1;
   }
   void push(int x) {
       top++;
       arr[top] = x;
   }
   int pop() {
       int x = arr[top];
       top--;
       return x;
   }
   int top() {
       return arr[top];
   }
   int size() {
       return top + 1;
   }
}

class myStack {
    
    private int current; //Represents the place where the next element is going to be pushed
    private int [] stack;

    public myStack(int n) {
        // Define Data Structures
        this.stack = new int[n];
        this.current = 0;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if(this.current == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        // check if the stack is full
        if(this.current == this.stack.length){
            return true;
        }else{
            return false;
        }
    }

    public void push(int x) {
        // Inserts x at the top of the stack
         if(this.current == this.stack.length){
            return;
        }
        
        this.stack[this.current] = x;
        this.current = this.current + 1;
        
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(this.current == 0){
            return;
        }
        
        this.current = this.current - 1;
    }

    public int peek() {
        // Returns the top element of the stack
        if(this.current == 0){
            //That means it still empty
            return -1;
        }
        
        return this.stack[this.current - 1];
    }
}
