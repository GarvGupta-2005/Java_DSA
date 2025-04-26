package LinkedList.Single;

public class middle { 
    //This is the optimal approach which uses slow and fast pointer also known as hare and tortoise pointer where one pointer moves twice as fast as compared to the other pointer
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        //This piece of code gives us the second middle in case of even length linked list
        //In order ti find first middle element start fast from one place ahead i.e initailise fast = head.next;
        //THis will return the first middle in case of even length linked list
    }
    //The Brute approach is to find the length of linkd list and then determine the midlle node using the length of linked list 
}
