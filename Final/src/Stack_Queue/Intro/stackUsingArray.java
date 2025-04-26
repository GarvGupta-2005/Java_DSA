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

