package LinkedList.Single;

public class midNodeDelete {
    public static Node deleteMiddle(Node head) {
        if(head==null || head.next == null){
            return null;
        }
        //To delete the middle node we need slow to before the middle node
        //In order to that skip one slow step so that slow pointer ends up just before the mid
        //This will help us in the deletion of the middle node
        Node slow = head;
        Node fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node del = slow.next;
        slow.next = del.next;
        del.next = null;
        return head;
    
    }
}
