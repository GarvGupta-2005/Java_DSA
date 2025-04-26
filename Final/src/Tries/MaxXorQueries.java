import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Query {
    int mi; // query limit
    int xi; // number to xor
    int idx; // original index

    Query(int mi, int xi, int idx) {
        this.mi = mi;
        this.xi = xi;
        this.idx = idx;
    }
}

class Node {
    // Array to hold links
    // to child nodes (0 and 1)
    Node[] links;

    // Constructor to initialize
    // the array of links
    Node() {
        links = new Node[2];
    }

    // Function to check if a child node
    // exists at a given index (0 or 1)
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    // Function to get the child
    // node at a given index (0 or 1)
    Node get(int ind) {
        return links[ind];
    }

    // Function to set the child
    // node at a given index (0 or 1)
    void put(int ind, Node node) {
        links[ind] = node;
    }
}

// Class definition for
// Trie data structure
class Trie {
    // Pointer to the root
    // node of the trie
    private Node root;

    // Constructor to initialize the
    // trie with an empty root node
    Trie() {
        root = new Node();
    }

    // Function to insert a
    // number into the trie
    void insert(int num) {
        // Start traversal
        // from the root node
        Node node = root;

        // Traverse each bit of the number
        // from the most significant bit
        // to the least significant bit
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th
            // bit of the number
            int bit = (num >> i) & 1;

            // If the current node doesn't
            // have a child node at the
            // current bit, create one
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            // Move to the child node
            // corresponding to the current bit
            node = node.get(bit);
        }
    }

    // Function to find the maximum XOR
    // value achievable with a given number
    int findMax(int num) {
        // Start traversal from the root node
        Node node = root;

        // Initialize the maximum XOR value
        int maxNum = 0;

        // Traverse each bit of the number
        // from the most significant bit to
        // the least significant bit
        for (int i = 31; i >= 0; i--) {

            // Extract the i-th
            // bit of the number
            int bit = (num >> i) & 1;

            // If there exists a different bit
            // in the trie at the current position,
            // choose it to maximize XOR
            if (node.containsKey(1 - bit)) {

                // Set the corresponding
                // bit in the result
                maxNum = maxNum | (1 << i);
                // Move to the child node
                // with the different bit
                node = node.get(1 - bit);
            } else {

                // Move to the child node
                // with the same bit
                node = node.get(bit);
            }
        }

        // Return the maximum XOR value
        return maxNum;
    }
}


public class MaxXorQueries {
    //This is a very Tough and Intutive question to solve
    //To solve the part where we have to xor only those elements that are smaller that mi we will
    //use offline queries method and will insert only those elements in trie which are smaller 
    //than mi and then we will form our answer 
    //We will sort the queries array in the order such that mi are arranged in increasing order 
    //This will ensure the correct place of each answer


    public int[] maximizeXor(int[] arr, int[][] queries) {

        int[] ans = new int[queries.length];

        // Convert queries to list of custom Query objects
        List<Query> offlineQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int xi = queries[i][0];
            int mi = queries[i][1];
            offlineQueries.add(new Query(mi, xi, i));
        }

        // Sort arr and offlineQueries by 'mi'
        Arrays.sort(arr);
        offlineQueries.sort((a, b) -> Integer.compare(a.mi, b.mi));

        Trie trie = new Trie();
        int i = 0, n = arr.length;

        for (Query q : offlineQueries) {
            // Insert numbers ≤ mi into trie
            while (i < n && arr[i] <= q.mi) {
                trie.insert(arr[i]);
                i++;
            }

            // If no elements ≤ mi exist, answer is -1
            if (i == 0) {
                ans[q.idx] = -1;
            } else {
                ans[q.idx] = trie.findMax(q.xi);
            }
        }

        return ans;

    }
}
