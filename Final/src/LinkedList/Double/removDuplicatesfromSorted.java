package LinkedList.Double;


public class removDuplicatesfromSorted {
    DNode removeDuplicates(DNode head){
        // Code Here.
        
         DNode temp = head;
        while(temp!=null && temp.next!=null){
            DNode nextNode = temp.next;
            while(nextNode!=null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode!=null){
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        
        return head;
}
}
