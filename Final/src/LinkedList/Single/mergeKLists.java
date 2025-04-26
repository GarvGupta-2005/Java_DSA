package LinkedList.Single;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKLists {
    public static  Node MergeKLists(Node[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });
        
        for (Node node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        Node dummy = new Node(0);
        Node prev = dummy;
        
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            prev.next = node;
            prev = prev.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
}
