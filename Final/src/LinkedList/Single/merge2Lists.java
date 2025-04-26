package LinkedList.Single;
public class merge2Lists {
    public  static int lengthOfList(Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static Node mergeTwoLists(Node list1, Node list2) {
        if(list1==null){
            return list2;
        } 
        if(list2 == null){
            return list1;
        }
      
        Node dummy = new Node(-100);
        int m = lengthOfList(list1);
        int n = lengthOfList(list2);
        int p1 = 1;
        int p2 = 1;
        Node temp = dummy;
        Node temp1 = list1;
        Node temp2 = list2;
        while(p1<=m && p2<=n){
            if(temp1.data<temp2.data && temp1!=null && temp2!=null){
                temp.next = temp1;
                temp = temp.next;
                temp1=temp1.next;
                p1++;
            }else{
                temp.next = temp2;
                temp = temp.next;
                temp2=temp2.next;
                p2++;
            }
        }
        while(p1<=m && temp1!=null){
            temp.next = temp1;
                temp = temp.next;
                temp1=temp1.next;
                p1++;
        }
        while(p2<=n && temp2!=null){
            temp.next = temp2;
                temp = temp.next;
                temp2=temp2.next;
                p2++;
        }
        return dummy.next;
    }
}
