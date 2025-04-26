package LinkedList.Single;

import java.util.HashMap;

public class intersection {
     public static Node getIntersectionNode(Node headA, Node headB) {
        //The first Approach is Hashing first put all the nodes of one linked list in a map
        //Then traverse the second linked list if node is repested return the node
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = headA;
        while(temp!=null){
            map.put(temp,1);
            temp = temp.next;
        }
        temp = headB;
        while(temp!=null){
            if(map.containsKey(temp)){
                return temp;
            }
            else{
                temp = temp.next;
            }
        }
        return null;

    }

    public static int findIntersection(Node headA, Node headB) {
        //Write your code here
        if(headA==null || headB ==null ){
            return -1;
        }
        Node t1 = headA;
        Node t2 = headB;
        while(t1!=t2){
            t1 = t1.next;
            t2 = t2.next;
            if(t1==t2){
                return t1.data;
            }
            if(t1==null){
                t1 = headB;
            }
            if(t2==null){
                t2 = headA;
            }
        }
        return -1;
    }

}
