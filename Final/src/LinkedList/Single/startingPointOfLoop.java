package LinkedList.Single;

import java.util.*;

public class startingPointOfLoop {
    public static Node firstNode(Node head) {
        // Write your code here.
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }else{
                map.put(temp, 1);
            }
            temp = temp.next;
        }
        return null;
     }

     /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public static Node detectCycle(Node head) {
        Node fast = head;
        Node slow  = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){   // after first meeting point set one pointer to head
            fast = head;  // there next meeting point will be the first or starting point of loop
            while(fast!=slow){ //this will surely happen if there is a loop else we will reach end of 
            fast = fast.next; // linked list proving that there is no cycle
            slow = slow.next; // x%l = z
            }
                return fast;
            }
        }
        return null;
    }


}
