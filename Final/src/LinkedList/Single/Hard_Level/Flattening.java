package LinkedList.Single.Hard_Level;

import java.util.ArrayList;
import java.util.Collections;

class Node {
    public int data;
    public Node next;
    public Node child;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    Node(int data, Node next, Node child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
public class Flattening {
    //The Brute Approach is to store all the nodes in a list and then sort them and then create a new linked list
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as
        // the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through the ArrayList and
        // create nodes with elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the element
            temp.child = new Node(arr.get(i));
            // Move the temporary pointer
            // to the newly created node
            temp = temp.child;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.child;
    }

    // Function to flatten a linked list with child pointers
    static Node flattenLinkedList(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();

        // Traverse through the linked list
        while (head != null) {
            // Traverse through the child
            // nodes of each head node
            Node t2 = head;
            while (t2 != null) {
                // Store each node's data in the ArrayList
                arr.add(t2.data);
                // Move to the next child node
                t2 = t2.child;
            }
            // Move to the next head node
            head = head.next;
        }

        // Sort the ArrayList containing
        // node values in ascending order
        Collections.sort(arr);

        // Convert the sorted ArrayList
        // back to a linked list
        return convertArrToLinkedList(arr);
    }


    //This approach is moe optimal as it uses recursion to merge the linked lists beginning from the end and then returns a final linked list 
     // Merges two linked lists in a particular
    // order based on the data value
    public static Node merge(Node list1, Node list2) {
        // Create a dummy node as a
        // placeholder for the result
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        // Merge the lists based on data values
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }

        // Connect the remaining
        // elements if any
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        // Break the last node's
        // link to prevent cycles
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        return dummyNode.child;
    }

    // Flattens a linked list with child pointers
    public static Node flattenLinkedList1(Node head) {
        // If head is null or there
        // is no next node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten the
        // rest of the linked list
        Node mergedHead = flattenLinkedList1(head.next);
        head = merge(head, mergedHead);
        return head;
    }


}
