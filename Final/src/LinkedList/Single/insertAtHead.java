package LinkedList.Single;

import java.util.ArrayList;

class Node {
    public int data;
    public Node next;

    // Constructor with both data and next node
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data (assuming next is initially null)
    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class insertAtHead {
    // Function to print the linked list
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to insert a new node at the head of the linked list
    public static Node insertHead(Node head, int val) {
        Node temp = new Node(val);
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        // Sample array and value for insertion
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(24);
        arr.add(36);
        arr.add(48);
        int val = 100;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        printLL(head);

        // Inserting a new node at the head of the linked list
        head = insertHead(head, val);

        // Printing the linked list
        printLL(head);
    }
}
