package LinkedList.Double;


public class deleteAtRandom {
    
//     class Solution {
//     public Node deleteNode(Node head, int x) {
//         // code here
//         if(head==null){
            
//             return head;        
            
//         }
//         if(x==1){
//             Node temp = head.next;
//             temp.prev = null;
//             head.next = null;
//             return temp;
//         }
        
//         Node temp1 = head;
//         temp1 = getAtPosition(temp1,x);
//         if(temp1.next==null){
//             temp1.prev.next = null;
//             temp1.prev = null;
//             return head;
//         }else{
//             temp1.prev.next = temp1.next;
//             temp1.next.prev = temp1.prev;
//             return head;
//         }
        
        
        
//     }
//     public Node getAtPosition(Node temp,int x){
//         while(x>1 && temp!=null && temp.next!=null){
//             temp = temp.next;
//             x--;
//         }
//         return temp;
//     }
            
//     }
}
