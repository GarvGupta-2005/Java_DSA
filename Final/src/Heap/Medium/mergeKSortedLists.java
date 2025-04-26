package Heap.Medium;

import java.util.PriorityQueue;

class ListNode {
      int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     class Pair implements Comparable<Pair> {
        int val; // Integer value
        ListNode node; // Corresponding ListNode

        Pair(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }

        // Define sorting based on the integer value
        public int compareTo(Pair other) {
            return Integer.compare(this.val, other.val); // Min-heap based on 'val'
        }
    }
public class mergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // Add only non-null heads to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(new Pair(list.val, list));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            Pair p = pq.poll();//Getting the min value Head
            temp.next = p.node;//Starting to build the final linked list
            if(p.node.next!=null){
                pq.add(new Pair(p.node.next.val,p.node.next));//adding the next node of the minimum that we removed earlier
            }
            temp = temp.next; //Pointing temp to its next position for adding new nodes
        }
        return dummy.next;
    }
}
