package LinkedList.Single.Hard_Level;
class Node1 {
    int data;      // the data value
    Node1 next;      // the reference to the next Node in the linked list
    // Constructors
    Node1(int data1, Node1 next1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = next1;  // Initialize next with the provided reference
    }
    Node1(int data1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = null;   // Initialize next as null since it's the end of the list
    }
}
public class reverseInGroups {

public static  Node1 reverseList(Node1 head) {
    if(head==null || head.next == null){
        return head;
    }
    Node1 prev = null;
    Node1 temp = head;
    while(temp!=null){
        Node1 front = temp.next; //Moving one pointer to keep the front node in contact
        temp.next = prev; //Assigning the previou snode to be your correct next
        prev = temp;
        temp = front;
    }
    return prev;
}
public static  Node1 getKthNode(Node1 temp,int k){
    k = k-1;
    while(temp!=null && k>0){
        k--;
        temp = temp.next;
    }
    return temp;
}

public static Node1 kReverse(Node1 head, int k) {
    // Write your code here.
    Node1 temp =  head;
    Node1 prevLast = null;
    while(temp!=null){
        Node1 KthNode = getKthNode(temp,k);
        if(KthNode == null){   //If there is no more nodes for the group to be size of k
            if(prevLast !=null){
                prevLast.next = temp;
                break;
            }
        }
        Node1 nextNode = KthNode.next;//This is for maintaining the link for the next grp
        KthNode.next = null; //This is for making a temporary list 
        reverseList(temp);//Reversing the current group
        if(temp==head){
            head = KthNode; 
        }
        else{
            prevLast.next = KthNode;
        }
        prevLast = temp;  //This is for maintaining the link for the next grp
        temp = nextNode;  //This is for moving to the next group
    }
    return head;
}

}