package LinkedList.Single.Hard_Level;

public class rotateByK {
    //This approach is more optimal 
    //First we traverse till the ned nd find the end of node
    //Then we point it to head;
    //Then we traverse from the head to the node fulfiling condition of len-k
    //then we point that node to null helping rotate the node

public static  Node reachTillLen_K(Node head,int pos){
    pos-=1;
    Node temp = head;
    while(temp!=null && pos>0){
        pos--;
        temp = temp.next;
    }
    return temp;
}

    
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head==null || head.next==null){
            return head;
        }
       int len = 1;
       Node tail = head;

       while(tail.next!=null){
        len++;
        tail = tail.next;
       }

       if(k%len==0){
        return head;
       }
       tail.next = head;
       k=k%len;
       Node temp = reachTillLen_K(head,len-k);
       head = temp.next;
       temp.next = null;
       return head;
    }
}
