package LinkedList.Single;

public class nthNodeFromEnd {
    //The Brute Approach is to traverse the Linked List to the point of " Length - n "
    //This will have us reach the node just before the node to be deleted 
    //The edge cases is if n is the size of linked list then we have to delete the head 
    public static Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int pos = count - n;
        if(pos==0){
            head = head.next;
            return head;
        }
        temp = head;
        pos = pos -1;
        while(pos>0){
            temp = temp.next;
            pos--;
        }
        Node delNode = temp.next;
        temp.next = delNode.next;
        delNode.next = null;
        return head;
    }
    public static Node removeKthNode(Node head, int K)
    {
        // This is the optimal Approach which uses slow and fast pointer
        //First move fast pointer n times;
        //Then move slow and fast simultaneously until fast reaches null;
        //This will result slow before the node which is to be deleted
        Node slow = head;
        Node fast = head;
        for(int i = 0;i<K;i++){
            if(fast!=null){fast = fast.next;}
        }
        if(fast==null){
            head = head.next;
            return head;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        Node del = slow.next;
        slow.next = del.next;
        del.next = null;
        return head;
    }

}
