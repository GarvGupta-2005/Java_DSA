package LinkedList.Single;

import java.util.*;

public class detectLoop {
    public boolean hasCycle(Node head) {
        //The extreme naive approach is to keep in mind how many times the node is being reached
        //If a node appears more than once in Traversal then it means there is loop 
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return true;
            }else{
                map.put(temp,1);
                temp = temp.next;
            }
        }
        return false;
    }
    public static boolean detectCycle(Node head) {
        // Initialize two pointers, slow and fast,
        // to the head of the linked list
        Node slow = head;
        Node fast = head;

        // Step 2: Traverse the linked list
        // with the slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;

            // Check if slow and fast pointers meet
            if (slow == fast) {
                return true;  // Loop detected
            }
        }

        // If fast reaches the end of the
        // list, there is no loop
        return false;
    }


}
