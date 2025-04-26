package LinkedList.Single;

public class add2Numbers {
    //Uses the Approach of dummy node 
    public static Node addTwoNumbers(Node head1, Node head2) {
        int carry = 0;
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(temp1!=null || temp2!=null){
            int sum = 0;
            sum+=carry;
            if(temp1!=null){
                sum += temp1.data;
            }
            if(temp2!=null){
                sum+=temp2.data;
            }
            int cur_digit = sum%10;
            carry = sum/10;
            Node newNode = new Node(cur_digit);
            temp.next = newNode;
            temp = newNode;
            if(temp1!=null){
                temp1 = temp1.next;
            }
            if(temp2!=null){
                temp2 = temp2.next;
            }
        }
        if(carry!=0){
            Node last = new Node(carry);
            temp.next = last;
            temp = last;
        }
        return dummy.next;
    }
}
