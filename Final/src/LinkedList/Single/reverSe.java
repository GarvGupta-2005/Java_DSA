package LinkedList.Single;

public class reverSe {
    public Node reverseList(Node head) {
        if(head==null || head.next == null){
            return head;
        }
        Node prev = null;
        Node temp = head;
        while(temp!=null){
            Node front = temp.next; //Moving one pointer to keep the front node in contact
            temp.next = prev; //Assigning the previou snode to be your correct next
            prev = temp;
            temp = front;
        }
        return prev;
    }
    //The above approach is iterative approach

    //This is the recursive approach
    public static Node reverseLinkedList(Node head) {
        // Base case:
        // If the linked list is empty or has only one node,
        // return the head as it is already reversed.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        Node newHead = reverseLinkedList(head.next);
        
        // Save a reference to the node following
        // the current 'head' node.
        Node front = head.next;
        
        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;
        
        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;
        
        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
    }

}
