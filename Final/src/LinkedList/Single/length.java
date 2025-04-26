package LinkedList.Single;

public class length {
        // Function to count nodes of a linked list.
        public int getCount(Node head) {
            Node temp = head;
            // code here
            int count = 0;
            while(temp!=null){
                count++;
                temp = temp.next;
            }
            return count;
        }
    
}
