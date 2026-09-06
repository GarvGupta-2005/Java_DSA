import java.util.HashMap;
import java.util.Map;

/**
 * Node class representing an individual item stored in the doubly linked list.
 * Holds key-value data alongside its access frequency count and pointers.
 */
class Node {
    int key, value, cnt; // 'key' & 'value' store the pair; 'cnt' tracks frequency of access
    Node next;           // Pointer to the next node in the list
    Node prev;           // Pointer to the previous node in the list
    
    // Constructor initializes a node with a key, value, and an initial frequency count of 1
    Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1; // Any newly inserted key starts with access count 1
    }
}

/**
 * Custom Doubly Linked List implementation.
 * Used instead of java.util.List to avoid naming collisions and to enable 
 * O(1) removal/insertion operations using explicit node pointers.
 */
class DoubleLinkedList {
    int size;   // Number of actual data nodes currently in this specific list
    Node head;  // Sentinel (dummy) head node to simplify edge-case insertions
    Node tail;  // Sentinel (dummy) tail node to simplify edge-case deletions
    
    // Constructor sets up dummy bounds (head <-> tail)
    DoubleLinkedList() {
        head = new Node(0, 0); // Dummy node at start
        tail = new Node(0, 0); // Dummy node at end
        head.next = tail;      // Initially, head points to tail
        tail.prev = head;      // Tail points back to head
        size = 0;             // Represents an empty list
    }
    
    /**
     * Inserts a node right after the dummy head (Most Recently Used position for this frequency).
     */
    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;      // Node points forward to original first item
        node.prev = head;      // Node points backward to dummy head
        head.next = node;      // Head points forward to new node
        temp.prev = node;      // Original first item points back to new node
        size++;                // Track increase in element count
    }
    
    /**
     * Removes an arbitrary node from the doubly linked list in O(1) time.
     */
    void removeNode(Node delnode) {
        Node prevNode = delnode.prev;
        Node nextNode = delnode.next;
        prevNode.next = nextNode; // Bypass delnode forward
        nextNode.prev = prevNode; // Bypass delnode backward
        size--;                   // Track decrease in element count
    }
}

/**
 * LFU (Least Frequently Used) Cache Implementation operating in O(1) time complexity.
 */
class LFUCache {

    // Hashmap to map 'key' directly to its corresponding 'Node' pointer for O(1) lookup
    private Map<Integer, Node> keyNode;
    
    // Hashmap mapping a frequency count 'cnt' to a DoubleLinkedList containing all nodes with that frequency
    private Map<Integer, DoubleLinkedList> freqListMap;
    
    private int maxSizeCache; // Maximum capacity allowed in the cache
    private int minFreq;      // Tracks the global minimum frequency across all current items in the cache
    private int curSize;      // Tracks the current total count of items in the cache
    
    // Constructor to initialize the cache data structure with capacity
    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    /**
     * Helper method to update a node's frequency when accessed or modified.
     * Moves the node from its current frequency list to frequency list (cnt + 1).
     */
    private void updateFreqListMap(Node node) {
        // Temporarily remove node entry from key lookup map
        keyNode.remove(node.key);
        
        // Remove node from its current frequency list
        freqListMap.get(node.cnt).removeNode(node);
        
        // If the node was in the minFreq list and that list is now empty, increment global minFreq
        if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }
        
        // Prepare target frequency list (cnt + 1)
        DoubleLinkedList nextHigherFreqList = new DoubleLinkedList();
        if (freqListMap.containsKey(node.cnt + 1)) {
            nextHigherFreqList = freqListMap.get(node.cnt + 1);
        }
        
        // Increment frequency count on the node
        node.cnt += 1;
        
        // Place node at the front of the incremented frequency list
        nextHigherFreqList.addFront(node);
        
        // Save/Update references in both maps
        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }
    
    /**
     * Retrieves the value of the key if present, and updates its access frequency.
     * Returns -1 if key does not exist.
     */
    public int get(int key) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key); // Retrieve matching node reference
            int val = node.value;         // Store value to return
            updateFreqListMap(node);      // Promote frequency count and update list associations
            return val;
        }
        return -1; // Return -1 when key is not present in cache
    }
    
    /**
     * Inserts or updates a key-value pair in the cache.
     * Handles capacity eviction based on LFU (and LRU for tie-breaking) rules.
     */
    public void put(int key, int value) {
        // Base edge case: If cache capacity is 0, ignore all put requests
        if (maxSizeCache == 0) {
            return;
        }
        
        // Scenario 1: Key already exists -> Update value & promote frequency
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;      // Overwrite current value
            updateFreqListMap(node); // Increase its frequency state
        } 
        // Scenario 2: Key does NOT exist -> Insert new entry
        else {
            // Check if cache has reached max capacity
            if (curSize == maxSizeCache) {
                // Fetch the list corresponding to the global minimum frequency
                DoubleLinkedList list = freqListMap.get(minFreq);
                
                // Remove the Least Recently Used (LRU) node in minFreq list (located before tail)
                keyNode.remove(list.tail.prev.key);
                freqListMap.get(minFreq).removeNode(list.tail.prev);
                
                curSize--; // Decrement cache item count
            }
            
            curSize++;  // Increment count for new insertion
            minFreq = 1; // New nodes always start with frequency 1, resetting minFreq to 1
            
            // Get or create the list for frequency 1
            DoubleLinkedList listFreq = new DoubleLinkedList();
            if (freqListMap.containsKey(minFreq)) {
                listFreq = freqListMap.get(minFreq);
            }
            
            // Instantiate new node and add to the front of frequency 1 list
            Node node = new Node(key, value);
            listFreq.addFront(node);
            
            // Register new node in lookup map and frequency map
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}
