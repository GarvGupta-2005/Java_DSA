package LinkedList.Single.Hard_Level;
import java.util.*;
class Node {
    // Data stored in the node
    int data;
    // Pointer to the next node
    Node next;
    // Pointer to a random node in the list
    Node random;

    // Constructors for Node class
    Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    Node(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }

    Node(int x, Node nextNode, Node randomNode) {
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class copyWithRandomPointer{
    // Function to clone the linked list
    public static Node cloneLL(Node head) {
        Node temp = head;
        // Create a HashMap to map original nodes
        // to their corresponding copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copies of each
        // node and store them in the map
        while (temp != null) {
            // Create a new node with the
            // same data as the original node
            Node newNode = new Node(temp.data);
            // Map the original node to its
            // corresponding copied node in the map
            map.put(temp, newNode);
            // Move to the next node in the original list
            temp = temp.next;
        }

        temp = head;
        // Step 2: Connect the next and random
        // pointers of the copied nodes using the map
        while (temp != null) {
            // Access the copied node corresponding
            // to the current original node
            Node copyNode = map.get(temp);
            // Set the next pointer of the copied node
            // to the copied node mapped to the
            // next node in the original list
            copyNode.next = map.get(temp.next);
            // Set the random pointer of the copied node
            // to the copied node mapped to the
            // random node in the original list
            copyNode.random = map.get(temp.random);
            // Move to the next node in the original list
            temp = temp.next;
        }

        // Return the head of the
        // deep copied list from the map
        return map.get(head);
    }


    //The above approach is however not as it usese extra space 
    //We can do it in O(1) space by following the below approach

    //First create a copy of each node and insert it in between the original node and the next node
    //Then assign the random pointers of the copied nodes
    //The assign the next pointers of the copied nodes
    //Also do not forget to sever the links between the original and copied nodes



    void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextElement = temp.next;
            // Create a new node with the same data
            Node copy = new Node(temp.data);
    
            // Point the copy's next to
            // the original node's next
            copy.next = nextElement;
    
            // Point the original
            // node's next to the copy
            temp.next = copy;
    
            // Move to the next original node
            temp = nextElement;
        }
    }
    
    // Function to connect random
    // pointers of the copied nodes
    void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            // Access the copied node
            Node copyNode = temp.next;
    
            // If the original node
            // has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the
                // corresponding copied random node
                copyNode.random = temp.random.next;
            } else {
                // Set the copied node's random to
                // null if the original random is null
                copyNode.random = null;
            }
    
            // Move to the next original node
            temp = temp.next.next;
        }
    }
    
    // Function to retrieve the
    // deep copy of the linked list
    Node getDeepCopyList(Node head) {
        Node temp = head;
        // Create a dummy node
        Node dummyNode = new Node(-1);
        // Initialize a result pointer
        Node res = dummyNode;
    
        while (temp != null) {
            // Creating a new List by
            // pointing to copied nodes
            res.next = temp.next;
            res = res.next;
    
            // Disconnect and revert back to the
            // initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }
    
        // Return the deep copy of the
        // list starting from the dummy node
        return dummyNode.next;
    }
    
    // Function to clone the linked list
    Node CloneLL(Node head) {
        // If the original list
        // is empty, return null
        if (head == null) return null;
    
        // Step 1: Insert copy of
        // nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }
    
}
