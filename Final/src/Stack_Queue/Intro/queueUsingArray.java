package Stack_Queue.Intro;

class Queue {

    private int arr[];
    private int start, end, currSize, maxSize;
    public Queue() {
        arr = new int[16];
        start = -1;
        end = -1;
        currSize = 0;
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        currSize = 0;
    }
    public void push(int newElement) {
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else
            end = (end + 1) % maxSize;
        arr[end] = newElement;
        System.out.println("The element pushed is " + newElement);
        currSize++;
    }
    public int pop() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % maxSize;
        currSize--;
        return popped;
    }
    public int top() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }
    public int size() {
        return currSize;
    }

}

public class queueUsingArray {
    public static void main(String args[]) {
        Queue q = new Queue(6);
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}


class myQueue {
    private int[] arr;
    private int capacity;
    private int size;

    // Constructor
    public myQueue(int capacity) {
         //Maximum number of elements the queue can hold.
        this.capacity = capacity;
         // Array to store queue elements.
        arr = new int[capacity];
        // Current number of elements in the queue.
        size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Enqueue
    public void enqueue(int x) {
        if (isFull()) {
            return;
        }
        arr[size] = x;
        size++;
    }

    // Dequeue
    public void dequeue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[0];
    }
    //Get last element
    public int getRear() {
    if (isEmpty()) {
        return -1;
    }
    return arr[size - 1];
    }


}


