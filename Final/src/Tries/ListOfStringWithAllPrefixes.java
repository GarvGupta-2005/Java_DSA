package Tries;

class Node {
    private Node[] links = new Node[26];
    private boolean flag = false;

    // Check if the reference trie node exists
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Create reference trie node
    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    // Get the next node for traversal
    public Node get(char ch) {
        return links[ch - 'a'];
    }

    // Mark the end of a word
    public void setEnd() {
        flag = true;
    }

    // Check if it's the end of a word
    public boolean isEnd() {
        return flag;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean containsPrefix(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.containsKey(ch)) {
                node = node.get(ch);
                if (!node.isEnd()) return false;
            } else {
                return false;
            }
        }
        return true;
    }
}

 
public class ListOfStringWithAllPrefixes {
    public static String completeString(int n, String [] words) {
        Trie trie = new Trie();

        // Insert all words into trie
        for (String word : words) {
            trie.insert(word);
        }

        String ans = "";
        for (String word : words) {
            if (trie.containsPrefix(word)) {
                if (word.length() > ans.length()) {
                    ans = word;
                } else if (word.length() == ans.length() && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}
