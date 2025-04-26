package Tries;

// Node class representing each character node in the Trie
class Node {
    private Node[] links = new Node[26]; // For 26 lowercase English letters
    private boolean flag = false;        // True if this node marks end of a word

    // Checks if the current node contains the given character
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Returns the child node corresponding to the given character
    Node get(char ch) {
        return links[ch - 'a'];
    }

    // Creates a link between current node and given character
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Marks the end of a word
    void setFlag() {
        this.flag = true;
    }

    // Checks if this node is the end of a word
    boolean isEnd() {
        return this.flag;
    }
}


// Trie class implementing insert, search, and prefix-checking
public class Trie {

    private Node root;

    // Constructor initializes the root node
    public Trie() {
        root = new Node();
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setFlag(); // Mark the end of the inserted word
    }

    // Searches for a word in the Trie
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false; // Character not found
            }
            node = node.get(ch);
        }
        return node.isEnd(); // Check if current node is end of a word
    }

    // Checks if there is any word in the Trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return false; // Character not found
            }
            node = node.get(ch);
        }
        return true; // Prefix exists
    }
}

