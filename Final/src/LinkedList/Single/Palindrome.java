package LinkedList.Single;

import java.util.*;

public class Palindrome {
    public static boolean isPalindrome1(Node head) {
        if(head==null || head.next==null){
            return true;
        }
        //The most naivee and brute approach is to Store the values in stack and then see
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.data!=st.peek()){
                return false;
            }else{
                temp  = temp.next;
                st.pop();
            }
        }
        return true;
    }

//OPtimal Approch
public static Node reverseLinkedList(Node head) {
    // Check if the list is empty or has only one node
    if (head == null || head.next == null) {

        // No change is needed;
        // return the current head
        return head;
    }

    // Recursive step: Reverse the remaining
    // part of the list and get the new head
    Node newHead = reverseLinkedList(head.next);

    // Store the next node in 'front'
    // to reverse the link
    Node front = head.next;

    // Update the 'next' pointer of 'front' to
    // point to the current head, effectively
    // reversing the link direction
    front.next = head;

    // Set the 'next' pointer of the
    // current head to 'null' to
    // break the original link
    head.next = null;

    // Return the new head obtained
    // from the recursion
    return newHead;
}

public static boolean isPalindrome(Node head) {

// The optimal Approach is to reverse the links of the second half of linked list and then check from the original head and the new head whether there values are same or not
    //If their values are same then it is a Palindromic linked list else it is not a Palindromic linked list

    //In even length linked list we stop when fast is at Second last node
    //In odd length we stop fast at Last node


    // Check if the linked list is
    // empty or has only one node
    if (head == null || head.next == null) {
        // It's a palindrome by definition
        return true;
    }

    // Initialize two pointers, slow and fast,
    // to find the middle of the linked list
    Node slow = head;
    Node fast = head;

    // Traverse the linked list to find the
    // middle using slow and fast pointers
    while (fast.next != null && fast.next.next != null) {
        // Move slow pointer one step at a time
        slow = slow.next;

        // Move fast pointer two steps at a time
        fast = fast.next.next;
    }

    // Reverse the second half of the 
    // linked list starting from the middle
    Node newHead = reverseLinkedList(slow.next);

    // Pointer to the first half
    Node first = head;

    // Pointer to the reversed second half
    Node second = newHead;
    while (second != null) {
        // Compare data values of
        // nodes from both halves

        // If values do not match, the
        // list is not a palindrome
        if (first.data != second.data) {
            
            // Reverse the second half back
            // to its original state
            reverseLinkedList(newHead);

            // Not a palindrome
            return false;
        }

        // Move the first pointer
        first = first.next;

        // Move the second pointer
        second = second.next;
    }

    // Reverse the second half back
    // to its original state
    reverseLinkedList(newHead);

    // The linked list is a palindrome
    return true;
}   

}
