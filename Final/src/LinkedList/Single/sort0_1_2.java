package LinkedList.Single;

public class sort0_1_2 {
    public static Node sortList(Node head) {
        // Write your code here
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;
        Node temp = head;
        while(temp!=null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        if(zero!=null && oneHead.next!=null){
            zero.next = oneHead.next;
        }
        if(one!=null && twoHead.next!=null){
            one.next = twoHead.next;
        }
        two.next = null;
        return zeroHead.next;

    }
}
