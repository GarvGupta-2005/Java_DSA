package LinkedList.Single;

import java.util.ArrayList;

public class oddEven {
    public Node oddEvenList(Node head) {
        if(head==null){
            return head;
        }
        //The Brute Approach is to first visit odd and even indices  repectvely and store their values
        //Then change their values in the linked list 
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = head;
        Node temp2 = head.next;
        while(temp1!=null && temp1.next!=null){
            arr.add(temp1.data);
            temp1 = temp1.next.next;
        }
        if(temp1!=null){ //This is to add the last node of Odd lengths linked list
            arr.add(temp1.data);
        }
        while(temp2!=null && temp2.next!=null){
            arr.add(temp2.data);
            temp2 = temp2.next.next;
        }
        temp1 = head;
        for(int i = 0;i<arr.size();i++){
            temp1.data = arr.get(i);
            temp1 = temp1.next; 
        }
        return head;
    }
    public static Node oddEvenList2(Node head) {
        // This is the optimal Approach where we put odds together and then evens together and then we place evenHead next to odd
        Node odd = head;
        Node even = head.next;
        Node oddhead = head;
        Node evenHead = head.next;
        while(even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddhead;
    }

}
