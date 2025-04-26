package LinkedList.Single;

public class sortLinkedList {
    public static Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Create a dummy node to serve
        // as the head of the merged list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
    
        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            // Compare elements of both lists and
            // link the smaller node to the merged list
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move the temporary pointer
            // to the next node
            temp = temp.next; 
        }
    
        // If any list still has remaining
        // elements, append them to the merged list
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        // Return the merged list starting 
        // from the next of the dummy node
        return dummyNode.next;
    }
    
    // Function to find the middle of a linked list
    public static Node findMiddle(Node head){
        // If the list is empty or has only one node
        // the middle is the head itself
        if (head == null || head.next == null) {
            return head;
        }
    
        // Initializing slow and fast pointers
        Node slow = head;
        Node fast = head.next;
    
        // Move the fast pointer twice
        // as fast as the slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // When the fast pointer reaches the end,
        // the slow pointer will be at the middle
        return slow;
    }
    public  static Node   sortLL(Node head){
        // Base case: if the list is empty or
        // has only one node, it is already
        // sorted, so return the head
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list
        // using the findMiddle function
        Node middle = findMiddle(head);
        
        // Divide the list into two halves
        Node right = middle.next;
        middle.next = null;
        Node left = head;
        
        // Recursively sort the left and right halves
        left = sortLL(left);
        right = sortLL(right);
        
        // Merge the sorted halves using the
        // mergeTwoSortedLinkedLists function
        return mergeTwoSortedLinkedLists(left, right);
    }
}
