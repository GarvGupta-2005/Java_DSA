package LinkedList.Single;

import java.util.HashMap;

public class lengthOfLoop {
    public static int lengthOfloopp(Node head) {
        // The Brute APproach is to use the Hashing Concept
        HashMap<Node,Integer> map = new HashMap<>();
        int count = 1;
        Node temp = head;
        while(temp!=null){
            if(map.containsKey(temp)){
                return count-map.get(temp);
            }else{
                map.put(temp,count);
                count++;
                temp = temp.next;
            }
        }
        return 0;
    }

//This is the optimum approach
static int findLength(Node slow, Node fast){
        
    // count to keep track of 
    // nodes encountered in loop
    int cnt = 1;
    
    // move fast by one step
    fast = fast.next;
    
    // traverse fast till it 
    // reaches back to slow
    while(slow!=fast){
        
        // at each node increase
        // count by 1 and move fast
        // forward by one step
        cnt++;
        fast = fast.next;
    }
    
    // loop terminates when fast reaches
    // slow again and the count is returned
    return cnt;
}

// Function to find the length
// of the loop in a linked list
static int lengthOfLoop2(Node head) {
    Node slow = head;
    Node fast = head;

    // Step 1: Traverse the list to detect a loop
    while (fast != null && fast.next != null) {
        // Move slow one step
        slow = slow.next;  
        
        // Move fast two steps
        fast = fast.next.next; 

        // Step 2: If the slow and fast
        // pointers meet, there is a loop
        if (slow == fast) {
            return findLength(slow, fast);
        }
    }

    // Step 3: If the fast pointer reaches the end
    // there is no loop
    
    return 0; 
}

}
