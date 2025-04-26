package LinkedList.Double;

public class deleteKey {
    public static DNode deleteAllOccurrences(DNode head, int k) {
        // Write your code here.
        DNode temp = head;
        while(temp!=null){
            if(temp.data == k){
                if(temp == head){
                    head = temp.next;
                }
                DNode nextNode = temp.next;
                DNode prevNode = temp.prev;
                if(nextNode!=null){
                    nextNode.prev = prevNode;
                }
                if(prevNode!=null){
                    prevNode.next = nextNode;
                }
                temp.next = null;
                temp.prev = null;
                temp = nextNode;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
